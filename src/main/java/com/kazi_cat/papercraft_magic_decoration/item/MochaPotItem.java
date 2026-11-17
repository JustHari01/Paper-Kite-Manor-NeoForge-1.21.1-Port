package com.kazi_cat.papercraft_magic_decoration.item;

import com.kazi_cat.papercraft_magic_decoration.init.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MochaPotItem extends BlockItem {
    public MochaPotItem() {
        super(ModBlocks.MOCHA_POT.get(), new Properties().stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        CustomData blockEntityData = stack.get(DataComponents.BLOCK_ENTITY_DATA);
        CompoundTag tag = blockEntityData == null ? null : blockEntityData.copyTag();
        if (tag != null && tag.contains("result")) {
            ItemStack itemStack = context.registries() == null ? ItemStack.EMPTY : ItemStack.parseOptional(context.registries(), tag.getCompound("result"));
            tooltip.add(itemStack.getHoverName().copy().withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(ItemStack.EMPTY.getHoverName().copy().withStyle(ChatFormatting.GRAY));
        }
    }
}
