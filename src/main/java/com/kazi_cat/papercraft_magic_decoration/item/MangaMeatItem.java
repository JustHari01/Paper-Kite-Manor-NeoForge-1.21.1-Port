package com.kazi_cat.papercraft_magic_decoration.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class MangaMeatItem extends ItemNameGeoBlockItem {
    public MangaMeatItem(Block block, Properties settings) {
        super(block, settings);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        entity.eat(level, stack.copy());
        ItemStack remainder = stack.copy();
        remainder.hurtAndBreak(1, entity, entity.getUsedItemHand() == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
        return remainder;
    }

    @Override
    public InteractionResult place(BlockPlaceContext context) {
        ItemStack itemStack = context.getItemInHand();
        if (itemStack.isDamaged()) {
            return InteractionResult.FAIL;
        }
        return super.place(context);
    }

    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity entity) {
        return 100;
    }
}
