package com.kazi_cat.papercraft_magic_decoration.blockentity;

import com.kazi_cat.papercraft_magic_decoration.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class OldOrganBlockEntity extends SimpleAnimatedBlockEntity {
    public static final String TAG_COOLDOWN = "cooldown";

    protected int cooldown;

    public OldOrganBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.OLD_ORGAN_BE.get(), pos, state);
    }

    public void tick(Level level) {
        if (cooldown > 0) {
            cooldown--;
        }
    }

    @Override
    public boolean triggerAnimation() {
        if (cooldown == 0) {
            cooldown = 420;
            super.triggerAnimation();
            return true;
        }
        return false;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, net.minecraft.core.HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);
        if (tag.contains(TAG_COOLDOWN)) {
            cooldown = tag.getInt(TAG_COOLDOWN);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, net.minecraft.core.HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);
        tag.putInt(TAG_COOLDOWN, cooldown);
    }
}
