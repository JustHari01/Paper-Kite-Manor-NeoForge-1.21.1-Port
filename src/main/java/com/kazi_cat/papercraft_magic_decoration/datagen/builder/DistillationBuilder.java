package com.kazi_cat.papercraft_magic_decoration.datagen.builder;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.crafting.recipe.DistillationRecipe;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DistillationBuilder implements RecipeBuilder {
    private static final String NAME = "distillation";

    private Ingredient wineBase;
    private List<Ingredient> ingredients = List.of();
    private ItemStack result = ItemStack.EMPTY;
    private int time;

    public static DistillationBuilder builder() {
        return new DistillationBuilder();
    }

    public DistillationBuilder setWineBase(Ingredient wineBase) {
        this.wineBase = wineBase;
        return this;
    }

    public DistillationBuilder setIngredients(List<Ingredient> ingredients) {
        this.ingredients = List.copyOf(ingredients);
        return this;
    }

    public DistillationBuilder setResult(ItemStack itemStack) {
        this.result = itemStack.copy();
        return this;
    }

    public DistillationBuilder setResult(ItemLike itemLike) {
        this.result = new ItemStack(itemLike);
        return this;
    }

    public DistillationBuilder setTime(int time) {
        this.time = time;
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
        output.accept(recipeId, new DistillationRecipe(this.wineBase, java.util.List.copyOf(recipeIngredients), this.result.copy(), this.time), null);
    }
}
