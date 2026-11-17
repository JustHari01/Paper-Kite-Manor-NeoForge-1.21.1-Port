package com.kazi_cat.papercraft_magic_decoration.datagen.recipe;

import com.kazi_cat.papercraft_magic_decoration.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;



public class ShapelessRecipeProvider extends ModRecipeProvider {
    public ShapelessRecipeProvider(PackOutput output, java.util.concurrent.CompletableFuture<net.minecraft.core.HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public void buildRecipes(RecipeOutput consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COFFEE_FRUIT.get(), 1)
                .requires(Items.CARROT)
                .requires(ModItems.VITALITY_SPORES.get())
                .requires(Items.COCOA_BEANS)
                .unlockedBy("has_vitality_spores", has(ModItems.VITALITY_SPORES.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.DARK_COCOA_IN_MOLD.get(), 1)
                .requires(Items.BUCKET)
                .requires(Items.COCOA_BEANS, 3)
                .unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MILK_COCOA_IN_MOLD.get(), 1)
                .requires(Items.MILK_BUCKET)
                .requires(Items.SUGAR)
                .requires(Items.COCOA_BEANS, 2)
                .unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.PRALINE_COCOA_IN_MOLD.get(), 1)
                .requires(Items.BUCKET)
                .requires(ModItems.GLOW_CASHEWS.get())
                .requires(Items.COCOA_BEANS, 2)
                .unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
                .save(consumer);
    }
}
