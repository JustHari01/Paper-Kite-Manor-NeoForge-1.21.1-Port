package com.kazi_cat.papercraft_magic_decoration.init.registry;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.init.ModItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = PaperKiteManor.MOD_ID)
public final class BrewingRegistry {
    private BrewingRegistry() {
    }

    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        event.getBuilder().addRecipe(
                Ingredient.of(Items.JUNGLE_SAPLING),
                Ingredient.of(ModItems.VITALITY_SPORES.get()),
                ModItems.MINI_PALM_TREE.get().getDefaultInstance()
        );
        event.getBuilder().addRecipe(
                Ingredient.of(Items.DARK_OAK_SAPLING),
                Ingredient.of(ModItems.VITALITY_SPORES.get()),
                ModItems.MINI_CANOPY_TREE.get().getDefaultInstance()
        );
    }
}
