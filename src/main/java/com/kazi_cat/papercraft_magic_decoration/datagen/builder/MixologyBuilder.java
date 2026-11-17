package com.kazi_cat.papercraft_magic_decoration.datagen.builder;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.crafting.recipe.MixologyRecipe;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

public class MixologyBuilder implements RecipeBuilder {
    private static final String NAME = "mixology";

    private final NonNullList<Ingredient> ingredients = NonNullList.withSize(4, Ingredient.EMPTY);
    private int currentIndex;
    private ItemStack result = ItemStack.EMPTY;

    public static MixologyBuilder builder() {
        return new MixologyBuilder();
    }

    public MixologyBuilder addIngredient(ItemLike itemLike) {
        this.ingredients.set(currentIndex++, Ingredient.of(itemLike));
        return this;
    }

    public MixologyBuilder addIngredient(TagKey<Item> itemLike) {
        this.ingredients.set(currentIndex++, Ingredient.of(itemLike));
        return this;
    }

    public MixologyBuilder setResult(ItemStack itemStack) {
        this.result = itemStack.copy();
        return this;
    }

    public MixologyBuilder setResult(ItemLike itemLike) {
        this.result = new ItemStack(itemLike);
        return this;
    }

    @Override
    public RecipeBuilder unlockedBy(String name, Criterion<?> trigger) {
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String groupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return this.result.getItem();
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        ResourceLocation recipeId = PaperKiteManor.modLoc(NAME + "/" + id.getPath());
        NonNullList<Ingredient> recipeIngredients = NonNullList.withSize(this.ingredients.size(), Ingredient.EMPTY);
        for (int index = 0; index < this.ingredients.size(); index++) {
            recipeIngredients.set(index, this.ingredients.get(index));
        }
        output.accept(recipeId, new MixologyRecipe(java.util.List.copyOf(recipeIngredients), this.result.copy()), null);
    }
}
