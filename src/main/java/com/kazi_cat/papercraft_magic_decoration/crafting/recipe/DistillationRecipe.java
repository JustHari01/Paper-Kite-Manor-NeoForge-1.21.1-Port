package com.kazi_cat.papercraft_magic_decoration.crafting.recipe;

import com.kazi_cat.papercraft_magic_decoration.crafting.container.DistillationContainer;
import com.kazi_cat.papercraft_magic_decoration.init.ModRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.RecipeMatcher;

public record DistillationRecipe(Ingredient wineBase, java.util.List<Ingredient> ingredients,
                                 ItemStack result, int time) implements Recipe<DistillationContainer> {
    @Override
    public boolean matches(DistillationContainer container, Level level) {
        return wineBase.test(container.getWineBase()) && RecipeMatcher.findMatches(container.getItems(), ingredients) != null;
    }

    @Override
    public ItemStack assemble(DistillationContainer container, HolderLookup.Provider provider) {return getResultItem(provider).copy();}

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
    public RecipeSerializer<?> getSerializer() { return ModRecipes.DISTILLATION_SERIALIZER.get(); }

    @Override
    public RecipeType<?> getType() { return ModRecipes.DISTILLATION_RECIPE; }

    @Override
    public boolean isSpecial() { return true; }

    @Override
    public boolean canCraftInDimensions(int width, int height) { return false; }
}
