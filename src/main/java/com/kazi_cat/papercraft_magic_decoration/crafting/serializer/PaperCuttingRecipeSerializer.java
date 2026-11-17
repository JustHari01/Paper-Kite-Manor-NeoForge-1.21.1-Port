package com.kazi_cat.papercraft_magic_decoration.crafting.serializer;

import com.kazi_cat.papercraft_magic_decoration.crafting.recipe.PaperCuttingRecipe;
import net.minecraft.world.item.crafting.SingleItemRecipe;

public class PaperCuttingRecipeSerializer extends SingleItemRecipe.Serializer<PaperCuttingRecipe> {
    public PaperCuttingRecipeSerializer() {
        super(PaperCuttingRecipe::new);
    }
}
