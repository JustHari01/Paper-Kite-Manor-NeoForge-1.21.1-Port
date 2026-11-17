package com.kazi_cat.papercraft_magic_decoration.client.render.block;

import com.kazi_cat.papercraft_magic_decoration.client.model.BlockGeoModelManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BaseGeoBlockRenderer<T extends BlockEntity & GeoBlockEntity> extends GeoBlockRenderer<T> {
    public BaseGeoBlockRenderer(BlockEntityType<T> blockEntityType) {
        super(blockEntityType);
    }

    @Override
    public GeoModel<T> getGeoModel() {
        T animatable = this.animatable;
        if (animatable != null && animatable.getLevel() != null) {
            GeoModel<T> geoModel = BlockGeoModelManager.getModel(animatable.getBlockState());
            if (geoModel != null) {
                return geoModel;
            }
        }
        return super.getGeoModel();
    }

    @Override
    public void actuallyRender(PoseStack poseStack, T animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int renderColor) {
        Matrix4f matrix4f = BlockGeoModelManager.getTransformation(animatable.getBlockState());
        if (matrix4f != null) {
            Vector3f translation = matrix4f.getTranslation(new Vector3f());
            Quaternionf rotation = matrix4f.getUnnormalizedRotation(new Quaternionf());
            Vector3f scale = matrix4f.getScale(new Vector3f());
            poseStack.translate(translation.x, translation.y, translation.z);
            poseStack.mulPose(rotation);
            poseStack.scale(scale.x, scale.y, scale.z);
        }
        super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, renderColor);
    }
}
