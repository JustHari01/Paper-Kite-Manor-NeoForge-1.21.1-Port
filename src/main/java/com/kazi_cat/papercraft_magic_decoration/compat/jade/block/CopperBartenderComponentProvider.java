package com.kazi_cat.papercraft_magic_decoration.compat.jade.block;

import com.kazi_cat.papercraft_magic_decoration.blockentity.CopperBartenderBlockEntity;
import com.kazi_cat.papercraft_magic_decoration.compat.jade.ModPlugin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import snownee.jade.api.Accessor;
import snownee.jade.api.view.*;

import java.util.ArrayList;
import java.util.List;

public enum CopperBartenderComponentProvider implements IServerExtensionProvider<ItemStack>, IClientExtensionProvider<ItemStack, ItemView> {
    INSTANCE;

    @Override
    public List<ClientViewGroup<ItemView>> getClientGroups(Accessor<?> accessor, List<ViewGroup<ItemStack>> list) {
        return ClientViewGroup.map(list, ItemView::new, null);
    }

    @Override
    @Nullable
    public List<ViewGroup<ItemStack>> getGroups(Accessor<?> accessor) {
        Object target = accessor.getTarget();
        if (target instanceof CopperBartenderBlockEntity bartender) {
            List<ItemStack> stacks = new ArrayList<>();
            for (int i = 0; i < bartender.getItems().getSlots(); i++) {
                stacks.add(bartender.getItems().getStackInSlot(i));
            }
            return List.of(new ViewGroup<>(stacks));
        }
        return null;
    }

    @Override
    public ResourceLocation getUid() {
        return ModPlugin.COPPER_BARTENDER;
    }
}
