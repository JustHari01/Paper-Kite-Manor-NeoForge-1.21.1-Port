package com.kazi_cat.papercraft_magic_decoration.crafting.serializer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.kazi_cat.papercraft_magic_decoration.crafting.recipe.MixologyRecipe;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.ArrayList;
import java.util.List;

public class MixologyRecipeSerializer implements RecipeSerializer<MixologyRecipe> {
    private static final MapCodec<MixologyRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").forGetter(MixologyRecipe::ingredients),
            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(MixologyRecipe::result)
    ).apply(instance, MixologyRecipe::new));

    private static final StreamCodec<RegistryFriendlyByteBuf, MixologyRecipe> STREAM_CODEC = StreamCodec.of(
            (buffer, recipe) -> {
                buffer.writeVarInt(recipe.ingredients().size());
                recipe.ingredients().forEach(ingredient -> Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient));
                ItemStack.STREAM_CODEC.encode(buffer, recipe.result());
            },
            buffer -> {
                int size = buffer.readVarInt();
                if (size < 0 || size > 64) {
                    throw new IllegalArgumentException("Invalid mixology ingredient count: " + size);
                }
                List<Ingredient> ingredients = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    ingredients.add(Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
                }
                return new MixologyRecipe(ingredients, ItemStack.STREAM_CODEC.decode(buffer));
            }
    );

    @Override
    public MapCodec<MixologyRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, MixologyRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
