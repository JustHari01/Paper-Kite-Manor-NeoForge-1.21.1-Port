package com.kazi_cat.papercraft_magic_decoration.event;

import net.neoforged.fml.common.EventBusSubscriber;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.init.ModItems;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

@EventBusSubscriber(modid = PaperKiteManor.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ItemAttributeEvent {
    @SubscribeEvent
    static void onItemAttributeModifier(ItemAttributeModifierEvent event) {
        if (event.getItemStack().is(ModItems.SAUSAGE_MACE_WEAPON.get())) {
            event.addModifier(
                    Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(PaperKiteManor.modLoc("attack_damage_modifier"),
                            7.0,
                            AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND
            );

            event.addModifier(
                    Attributes.ATTACK_SPEED,
                    new AttributeModifier(PaperKiteManor.modLoc("weapon_speed_modifier"),
                            -2.8,
                            AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND
            );
        }
    }
}
