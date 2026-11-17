package com.kazi_cat.papercraft_magic_decoration.block.base;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;

public final class LegacyUseInteractions {
    private LegacyUseInteractions() {}

    public static ItemInteractionResult asItemResult(InteractionResult result) {
        return switch (result) {
            case SUCCESS, SUCCESS_NO_ITEM_USED -> ItemInteractionResult.SUCCESS;
            case CONSUME -> ItemInteractionResult.CONSUME;
            case CONSUME_PARTIAL -> ItemInteractionResult.CONSUME_PARTIAL;
            case FAIL -> ItemInteractionResult.FAIL;
            case PASS -> ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        };
    }
}
