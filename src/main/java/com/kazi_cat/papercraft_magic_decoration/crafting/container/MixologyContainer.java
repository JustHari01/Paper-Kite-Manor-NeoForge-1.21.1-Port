package com.kazi_cat.papercraft_magic_decoration.crafting.container;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.crafting.RecipeInput;

public class MixologyContainer extends SimpleContainer implements RecipeInput {
    public MixologyContainer() {
        super(4);
    }

    @Override
    public int size() {
        return getContainerSize();
    }
}
