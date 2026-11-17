package com.kazi_cat.papercraft_magic_decoration.crafting.recipe;

import com.kazi_cat.papercraft_magic_decoration.init.ModRecipes;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class PaperCuttingRecipe extends SingleItemRecipe {
    public PaperCuttingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipes.PAPERCUTTING_RECIPE, ModRecipes.PAPERCUTTING_SERIALIZER.get(),
                group, ingredient, result);
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        return this.ingredient.test(input.item());
    }

    @Override
    public NonNullList<Ingredient> getIngredients() { return NonNullList.of(Ingredient.EMPTY, ingredient); }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public ItemStack getResult() {
        return this.result;
    }

    @Override
    public boolean isSpecial() { return true; }

    @Override
    public RecipeSerializer<?> getSerializer() { return ModRecipes.PAPERCUTTING_SERIALIZER.get(); }
}
