package com.kazi_cat.papercraft_magic_decoration.crafting.serializer;

import com.kazi_cat.papercraft_magic_decoration.crafting.recipe.PaperMakingRecipe;
import net.minecraft.world.item.crafting.SingleItemRecipe;

public class PaperMakingRecipeSerializer extends SingleItemRecipe.Serializer<PaperMakingRecipe> {
    public PaperMakingRecipeSerializer() {
        super(PaperMakingRecipe::new);
    }
}
