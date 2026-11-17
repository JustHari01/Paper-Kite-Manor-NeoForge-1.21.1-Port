package com.kazi_cat.papercraft_magic_decoration.crafting.recipe;

import com.kazi_cat.papercraft_magic_decoration.init.ModRecipes;
import com.kazi_cat.papercraft_magic_decoration.crafting.container.MixologyContainer;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record MixologyRecipe(java.util.List<Ingredient> ingredients, ItemStack result) implements Recipe<MixologyContainer> {
    @Override
    public boolean matches(MixologyContainer simpleContainer, Level level) {
        if (simpleContainer.size() < 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (!ingredients.get(i).test(simpleContainer.getItem(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack assemble(MixologyContainer simpleContainer, HolderLookup.Provider provider) {
        return getResultItem(provider).copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> copy = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);
        for (int i = 0; i < ingredients.size(); i++) {
            copy.set(i, ingredients.get(i));
        }
        return copy;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() { return ModRecipes.MIXOLOGY_SERIALIZER.get(); }

    @Override
    public RecipeType<?> getType() { return ModRecipes.MIXOLOGY_RECIPE; }

    @Override
    public boolean isSpecial() { return true; }

    @Override
    public boolean canCraftInDimensions(int width, int height) { return false; }
}
