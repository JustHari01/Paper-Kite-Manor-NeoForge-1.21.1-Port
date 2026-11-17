package com.kazi_cat.papercraft_magic_decoration.datagen.recipe;

import com.google.common.collect.Lists;
import com.kazi_cat.papercraft_magic_decoration.datagen.builder.DistillationBuilder;
import com.kazi_cat.papercraft_magic_decoration.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;



public class DistillationRecipeProvider extends ModRecipeProvider {
    public DistillationRecipeProvider(PackOutput output, java.util.concurrent.CompletableFuture<net.minecraft.core.HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public void buildRecipes(RecipeOutput consumer) {
        DistillationBuilder.builder()
                .setWineBase(Ingredient.of(ModItems.WHISKEY_RAW.get()))
                .setIngredients(Lists.newArrayList(
                        Ingredient.of(Items.APPLE),
                        Ingredient.of(Items.APPLE),
                        Ingredient.of(Items.APPLE),
                        Ingredient.of(Items.APPLE)
                ))
                .setResult(ModItems.BOTTLE_OF_LAND_NO1.get())
                .setTime(1200)
                .save(consumer);

        DistillationBuilder.builder()
                .setWineBase(Ingredient.of(ModItems.WHISKEY_RAW.get()))
                .setIngredients(Lists.newArrayList(
                        Ingredient.of(Items.BLAZE_POWDER),
                        Ingredient.of(Items.BLAZE_POWDER),
                        Ingredient.of(Items.BLAZE_POWDER),
                        Ingredient.of(Items.BLAZE_POWDER)
                ))
                .setResult(ModItems.BOTTLE_OF_BLAZE_WHISKEY.get())
                .setTime(1200)
                .save(consumer);

        DistillationBuilder.builder()
                .setWineBase(Ingredient.of(ModItems.WHISKEY_RAW.get()))
                .setIngredients(Lists.newArrayList(
                        Ingredient.of(Items.SEA_PICKLE),
                        Ingredient.of(Items.SEA_PICKLE),
                        Ingredient.of(Items.SEA_PICKLE),
                        Ingredient.of(Items.SEA_PICKLE)
                ))
                .setResult(ModItems.BOTTLE_OF_FERRY_WHISKEY.get())
                .setTime(1200)
                .save(consumer);

        DistillationBuilder.builder()
                .setWineBase(Ingredient.of(ModItems.WHISKEY_RAW.get()))
                .setIngredients(Lists.newArrayList(
                        Ingredient.of(Items.WARPED_FUNGUS),
                        Ingredient.of(Items.WARPED_FUNGUS),
                        Ingredient.of(Items.WARPED_FUNGUS),
                        Ingredient.of(Items.WARPED_FUNGUS)
                ))
                .setResult(ModItems.BOTTLE_OF_FLY_WHISKEY.get())
                .setTime(1200)
                .save(consumer);

        DistillationBuilder.builder()
                .setWineBase(Ingredient.of(ModItems.WHISKEY_RAW.get()))
                .setIngredients(Lists.newArrayList(
                        Ingredient.of(Items.CACTUS),
                        Ingredient.of(Items.CACTUS),
                        Ingredient.of(Items.CACTUS),
                        Ingredient.of(Items.CACTUS)
                ))
                .setResult(ModItems.BOTTLE_OF_LUCKY_CACTUS.get())
                .setTime(1200)
                .save(consumer);

        DistillationBuilder.builder()
                .setWineBase(Ingredient.of(ModItems.WHISKEY_RAW.get()))
                .setIngredients(Lists.newArrayList(
                        Ingredient.of(Items.WITHER_ROSE),
                        Ingredient.of(Items.WITHER_ROSE),
                        Ingredient.of(Items.WITHER_ROSE),
                        Ingredient.of(Items.WITHER_ROSE)
                ))
                .setResult(ModItems.BOTTLE_OF_POISON_RUM.get())
                .setTime(1200)
                .save(consumer);

        DistillationBuilder.builder()
                .setWineBase(Ingredient.of(ModItems.WHISKEY_RAW.get()))
                .setIngredients(Lists.newArrayList(
                        Ingredient.of(Items.TORCHFLOWER),
                        Ingredient.of(Items.TORCHFLOWER),
                        Ingredient.of(Items.TORCHFLOWER),
                        Ingredient.of(Items.TORCHFLOWER)
                ))
                .setResult(ModItems.PACK_OF_GUANG_S.get())
                .setTime(1200)
                .save(consumer);
    }
}
