package com.kazi_cat.papercraft_magic_decoration.init.registry;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.block.dispenser.SporesCollectionPlateBlockDispenseBehavior;
import com.kazi_cat.papercraft_magic_decoration.block.drink.BoxedDrinkBlock;
import com.kazi_cat.papercraft_magic_decoration.block.drink.DrinkBlock;
import com.kazi_cat.papercraft_magic_decoration.init.ModEntities;
import com.kazi_cat.papercraft_magic_decoration.init.ModItems;
import com.kazi_cat.papercraft_magic_decoration.item.DrinkBlockItem;
import com.kazi_cat.papercraft_magic_decoration.network.NetworkHandler;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = PaperKiteManor.MOD_ID)
public class CommonRegistry {
    @SubscribeEvent
    public static void onSetupEvent(FMLCommonSetupEvent event) {
        event.enqueueWork(CommonRegistry::addDispenserBehavior);
    }

    @SubscribeEvent
    public static void onBlockRegistryEvent(RegisterEvent event) {
        if (event.getRegistryKey().equals(Registries.BLOCK)) {
            DrinkRegistry.DRINK_DATA_MAP.forEach(((resourceLocation, data) -> {
                    event.register(Registries.BLOCK, resourceLocation, () -> switch (data.getBlockType()) {
                        case SIMPLE -> new DrinkBlock(data.getProperties(), data.getMaxCount(), data.getShapes().toArray(new VoxelShape[0]));
                        case BOXED -> new BoxedDrinkBlock(data.getProperties(), data.getMaxCount(), data.getShapes().toArray(new VoxelShape[0]));
                    });
            }));
        }

        if (event.getRegistryKey().equals(Registries.ITEM)) {
            DrinkRegistry.DRINK_DATA_MAP.forEach((resourceLocation, data) -> {
                Block block = BuiltInRegistries.BLOCK.get(resourceLocation);
                if (block != null) {
                    event.register(Registries.ITEM, resourceLocation,
                            () -> new DrinkBlockItem(block, data.getFood()));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.AOAO_SPAWN_EGG.get());
            event.accept(ModItems.WHITE_RABBIT_MAID_SPAWN_EGG.get());
            event.accept(ModItems.BLACK_CAT_LOBBY_BOY_SPAWN_EGG.get());
            event.accept(ModItems.AIR_FLOW_CARP_SPAWN_EGG.get());
            event.accept(ModItems.PAPER_TIGER_SPAWN_EGG.get());
        }
    }

    private static void addDispenserBehavior() {
        DispenserBlock.registerBehavior(Items.GLASS_BOTTLE, new SporesCollectionPlateBlockDispenseBehavior(DispenserBlock.DISPENSER_REGISTRY.get(Items.GLASS_BOTTLE)));
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(ModEntities.AOAO.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)
                        && world.getRawBrightness(pos, 0) > 8, RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(ModEntities.WHITE_RABBIT_MAID.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)
                        && world.getRawBrightness(pos, 0) > 8, RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(ModEntities.BLACK_CAT_LOBBY_BOY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)
                        && world.getRawBrightness(pos, 0) > 8, RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(ModEntities.AIR_FLOW_CARP.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)
                        && world.getRawBrightness(pos, 0) > 8, RegisterSpawnPlacementsEvent.Operation.OR);
    }
}
