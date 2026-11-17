package com.kazi_cat.papercraft_magic_decoration.effect;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.resources.ResourceLocation;

public class SilkyFeelEffect extends BaseEffect {
    public SilkyFeelEffect(int color) {
        super(color);
        this.addAttributeModifier(
                Attributes.STEP_HEIGHT,
                ResourceLocation.fromNamespaceAndPath("papercraft_magic_decoration", "silky_feel_step_height"),
                0.5,
                AttributeModifier.Operation.ADD_VALUE
        );
    }
}
