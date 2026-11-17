package com.kazi_cat.papercraft_magic_decoration.init;

import net.neoforged.fml.common.EventBusSubscriber;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.entity.*;
import com.kazi_cat.papercraft_magic_decoration.entity.projectile.FlyingChickenEntity;
import com.kazi_cat.papercraft_magic_decoration.entity.projectile.ThrownFireWhiskeyEntity;
import com.kazi_cat.papercraft_magic_decoration.entity.projectile.ThrownVodkaEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(modid = PaperKiteManor.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, PaperKiteManor.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<AoaoEntity>> AOAO = ENTITY_TYPES.register("aoao", () -> AoaoEntity.TYPE);
    public static final DeferredHolder<EntityType<?>, EntityType<WhiteRabbitMaidEntity>> WHITE_RABBIT_MAID = ENTITY_TYPES.register("white_rabbit_maid", () -> WhiteRabbitMaidEntity.TYPE);
    public static final DeferredHolder<EntityType<?>, EntityType<BlackCatLobbyBoyEntity>> BLACK_CAT_LOBBY_BOY = ENTITY_TYPES.register("black_cat_lobby_boy", () -> BlackCatLobbyBoyEntity.TYPE);
    public static final DeferredHolder<EntityType<?>, EntityType<AirFlowCarpEntity>> AIR_FLOW_CARP = ENTITY_TYPES.register("air_flow_carp", () -> AirFlowCarpEntity.TYPE);
    public static final DeferredHolder<EntityType<?>, EntityType<PaperTigerEntity>> PAPER_TIGER = ENTITY_TYPES.register("paper_tiger", () -> PaperTigerEntity.TYPE);

    public static final DeferredHolder<EntityType<?>, EntityType<FlyingChickenEntity>> FLYING_CHICKEN = ENTITY_TYPES.register("flying_chicken_projectile", () -> FlyingChickenEntity.TYPE);
    public static final DeferredHolder<EntityType<?>, EntityType<ThrownVodkaEntity>> THROWN_VODKA = ENTITY_TYPES.register("thrown_vodka", () -> ThrownVodkaEntity.TYPE);
    public static final DeferredHolder<EntityType<?>, EntityType<ThrownFireWhiskeyEntity>> THROWN_FIRE_WHISKEY = ENTITY_TYPES.register("thrown_fire_whiskey", () -> ThrownFireWhiskeyEntity.TYPE);

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerEntity(
                Capabilities.ItemHandler.ENTITY,
                WHITE_RABBIT_MAID.get(),
                (entity, context) -> (IItemHandler) entity.getCombinedInventory());
    }

    @SubscribeEvent
    static void addEntityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(AoaoEntity.TYPE, Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.ARMOR, 0)
                .add(Attributes.ATTACK_DAMAGE, 0)
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5)
                .build());

        event.put(WhiteRabbitMaidEntity.TYPE, Mob.createMobAttributes()
                .add(Attributes.ARMOR, 0)
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.ATTACK_DAMAGE, 0)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5)
                .build());

        event.put(BlackCatLobbyBoyEntity.TYPE, Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.MAX_HEALTH, 40)
                .add(Attributes.ARMOR, 6)
                .add(Attributes.ATTACK_DAMAGE, 0)
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5)
                .build());

        event.put(AirFlowCarpEntity.TYPE, Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.MAX_HEALTH, 40)
                .add(Attributes.ARMOR, 0)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.FLYING_SPEED, 0.3)
                .build());

        event.put(PaperTigerEntity.TYPE, Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.MAX_HEALTH, 40)
                .add(Attributes.ARMOR, 2)
                .add(Attributes.ATTACK_DAMAGE, 0)
                .add(Attributes.ATTACK_KNOCKBACK, 0)
                .add(Attributes.FOLLOW_RANGE, 16)
                .build());
    }
}
