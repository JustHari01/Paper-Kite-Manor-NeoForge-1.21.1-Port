package com.kazi_cat.papercraft_magic_decoration.datagen.recipe;

import com.google.common.collect.Lists;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;

import java.util.List;


public class ModRecipeGenerator extends ModRecipeProvider {
    private final List<ModRecipeProvider> providers = Lists.newArrayList();

    public ModRecipeGenerator(PackOutput output, java.util.concurrent.CompletableFuture<net.minecraft.core.HolderLookup.Provider> registries) {
        super(output, registries);
        providers.add(new ShapedRecipeProvider(output, registries));
        providers.add(new ShapelessRecipeProvider(output, registries));
        providers.add(new SingleItemRecipeProvider(output, registries));
        providers.add(new PaperMakingRecipeProvider(output, registries));
        providers.add(new PaperCuttingRecipeProvider(output, registries));
        providers.add(new MixologyRecipeProvider(output, registries));
        providers.add(new DistillationRecipeProvider(output, registries));
    }

    @Override
    public void buildRecipes(RecipeOutput consumer) {
        for (ModRecipeProvider provider : providers) {
            provider.buildRecipes(consumer);
        }
    }
}
