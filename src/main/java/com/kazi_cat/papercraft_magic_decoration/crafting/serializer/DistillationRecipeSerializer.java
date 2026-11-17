package com.kazi_cat.papercraft_magic_decoration.crafting.serializer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.kazi_cat.papercraft_magic_decoration.crafting.recipe.DistillationRecipe;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.ArrayList;
import java.util.List;

public class DistillationRecipeSerializer implements RecipeSerializer<DistillationRecipe> {
    private static final MapCodec<DistillationRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Ingredient.CODEC_NONEMPTY.fieldOf("wineBase").forGetter(DistillationRecipe::wineBase),
            Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").forGetter(DistillationRecipe::ingredients),
            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(DistillationRecipe::result),
            Codec.INT.fieldOf("time").forGetter(DistillationRecipe::time)
    ).apply(instance, DistillationRecipe::new));

    private static final StreamCodec<RegistryFriendlyByteBuf, DistillationRecipe> STREAM_CODEC = StreamCodec.of(
            (buffer, recipe) -> {
                buffer.writeVarInt(recipe.time());
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.wineBase());
                buffer.writeVarInt(recipe.ingredients().size());
                recipe.ingredients().forEach(ingredient -> Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient));
                ItemStack.STREAM_CODEC.encode(buffer, recipe.result());
            },
            buffer -> {
                int time = buffer.readVarInt();
                Ingredient wineBase = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
                int size = buffer.readVarInt();
                if (size < 0 || size > 64) {
                    throw new IllegalArgumentException("Invalid distillation ingredient count: " + size);
                }
                List<Ingredient> ingredients = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    ingredients.add(Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
                }
                return new DistillationRecipe(wineBase, ingredients, ItemStack.STREAM_CODEC.decode(buffer), time);
            }
    );

    @Override
    public MapCodec<DistillationRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, DistillationRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
