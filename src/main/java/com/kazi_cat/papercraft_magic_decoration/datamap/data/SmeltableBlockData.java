package com.kazi_cat.papercraft_magic_decoration.datamap.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

public record SmeltableBlockData(Block block, int time, int flips, int cooldown, Item ingredient, Item result) {
    private static final Codec<Item> ITEM_CODEC = ResourceLocation.CODEC.comapFlatMap(id -> {
        Item item = BuiltInRegistries.ITEM.getOptional(id).orElse(null);
        return item != null ? DataResult.success(item) : DataResult.error(() -> "Unknown item: " + id);
    }, BuiltInRegistries.ITEM::getKey);

    private static final Codec<Block> BLOCK_CODEC = ResourceLocation.CODEC.comapFlatMap(id -> {
        Block block = BuiltInRegistries.BLOCK.getOptional(id).orElse(null);
        return block != null ? DataResult.success(block) : DataResult.error(() -> "Unknown item: " + id);
    }, BuiltInRegistries.BLOCK::getKey);

    public static final Codec<SmeltableBlockData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BLOCK_CODEC.fieldOf("block").forGetter(SmeltableBlockData::block),
            Codec.INT.fieldOf("time").forGetter(SmeltableBlockData::time),
            Codec.INT.fieldOf("flips").forGetter(SmeltableBlockData::flips),
            Codec.INT.fieldOf("cooldown").forGetter(SmeltableBlockData::cooldown),
            ITEM_CODEC.fieldOf("ingredient").forGetter(SmeltableBlockData::ingredient),
            ITEM_CODEC.fieldOf("result").forGetter(SmeltableBlockData::result)
    ).apply(instance, SmeltableBlockData::new));
}
