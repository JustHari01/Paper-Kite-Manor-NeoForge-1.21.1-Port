package com.kazi_cat.papercraft_magic_decoration.init;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.inventory.container.*;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;

public interface ModContainers {
    DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, PaperKiteManor.MOD_ID);

    DeferredHolder<MenuType<?>, MenuType<CopperBartenderContainer>> COPPER_BARTENDER_CONTAINER = CONTAINER_TYPES.register("copper_bartender_container", () -> CopperBartenderContainer.TYPE);
    DeferredHolder<MenuType<?>, MenuType<DirtHoleContainer>> DIRT_HOLE_CONTAINER = CONTAINER_TYPES.register("dirt_hole_container", () -> DirtHoleContainer.TYPE);
    DeferredHolder<MenuType<?>, MenuType<KaziLuckyCatContainer>> KAZI_LUCKY_CAT_CONTAINER = CONTAINER_TYPES.register("kazi_lucky_cat_container", () -> KaziLuckyCatContainer.TYPE);
    DeferredHolder<MenuType<?>, MenuType<BunnySuitcaseContainer>> BUNNY_SUITCASE_CONTAINER = CONTAINER_TYPES.register("bunny_suitcase_container", () -> BunnySuitcaseContainer.TYPE);
    DeferredHolder<MenuType<?>, MenuType<LobbyBoyBackpackContainer>> LOBBY_BOY_BACKPACK_CONTAINER = CONTAINER_TYPES.register("lobby_boy_backpack_container", () -> LobbyBoyBackpackContainer.TYPE);
}
