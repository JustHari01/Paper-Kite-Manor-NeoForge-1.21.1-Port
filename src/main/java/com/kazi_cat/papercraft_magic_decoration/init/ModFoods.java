package com.kazi_cat.papercraft_magic_decoration.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public interface ModFoods {
    FoodProperties SMOKED_SALMON_HEAD = (new FoodProperties.Builder())
            .nutrition(5).saturationModifier(0.6f)
            .build();

    FoodProperties CHUNKY_SALMON = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(0.3f)
            .build();

    FoodProperties CHUNKY_SMOKED_SALMON = (new FoodProperties.Builder())
            .nutrition(10).saturationModifier(0.6f)
            .build();

    FoodProperties MANGA_MEAT = (new FoodProperties.Builder())
            .nutrition(15).saturationModifier(0.6f)
            .build();

    FoodProperties LARGE_STEAK = (new FoodProperties.Builder())
            .nutrition(12).saturationModifier(0.7f)
            .build();

    FoodProperties CUBED_SAUSAGE = (new FoodProperties.Builder())
            .nutrition(14).saturationModifier(0.7f)
            .build();

    FoodProperties FRIED_CHICKEN_LEG = (new FoodProperties.Builder())
            .nutrition(8).saturationModifier(0.6f)
            .build();

    FoodProperties DRINK_DEFAULT = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .alwaysEdible().build();

    FoodProperties BLAZE_WHISKEY = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 6000, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 1), 1)
            .alwaysEdible().build();

    FoodProperties FERRY_WHISKEY = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 6000, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 6000, 1), 1)
            .alwaysEdible().build();

    FoodProperties FLY_WHISKEY = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 2400, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 1200, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400, 1), 1)
            .alwaysEdible().build();

    FoodProperties LAND_NO1 = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 120, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 6000, 3), 1)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 2), 1)
            .alwaysEdible().build();

    FoodProperties LUCKY_CACTUS = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 6000, 3), 1)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 6000, 1), 1)
            .alwaysEdible().build();

    FoodProperties POISON_RUM = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 120, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 120, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 3), 1)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 600, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 1), 1)
            .alwaysEdible().build();

    FoodProperties BLOODY_MARY = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 120, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 2), 1)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 6000, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 1), 1)
            .alwaysEdible().build();

    FoodProperties DIPLOMATICO_COFFEE = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 2), 1)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 0), 1)
            .alwaysEdible().build();

    FoodProperties DEVIL_MARGARITA = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.BLOODTHIRSTY_DEVIL, 1200, 0), 1)
            .alwaysEdible().build();

    FoodProperties DIONYSUS = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.WINES_AROMA, 2400, 0), 1)
            .alwaysEdible().build();

    FoodProperties KALEIDOSCOPE_WHISKEY_SOUR = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.ACID_JAZZ, 2400, 0), 1)
            .alwaysEdible().build();

    FoodProperties LONG_ISLAND_POPSICLE_TEA = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.DOUBLE_ICE_SHOCK, 2400, 0), 1)
            .alwaysEdible().build();

    FoodProperties NOCTURNAL_CAT_COFFEE = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.CAT_EYE, 6000, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 6000, 0), 1)
            .alwaysEdible().build();

    FoodProperties GOLD_MEDAL_COFFEE = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.CAT_EYE, 6000, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 6000, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 3), 1)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1)
            .alwaysEdible().build();

    FoodProperties WHITE_RABBIT_MOCHA = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 6000, 0), 1)
            .effect(() -> new MobEffectInstance(ModEffects.LOVE_BAND_AID, 6000, 0), 1)
            .alwaysEdible().build();

    FoodProperties GUANG_S = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 120, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 1), 1)
            .alwaysEdible().build();

    FoodProperties TRUFFLE_CHOCOLATE = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(1)
            .effect(() -> new MobEffectInstance(ModEffects.SILKY_FEEL, 3600), 1)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1), 1)
            .alwaysEdible().build();

    FoodProperties MILK_CHOCOLATE = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(1)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0), 1)
            .alwaysEdible().build();

    FoodProperties PRALINE_CHOCOLATE = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(1)
            .effect(() -> new MobEffectInstance(ModEffects.SKY_TRACTION, 6000, 0), 1)
            .alwaysEdible().build();

    FoodProperties COFFEE_PASTINACA_SATIVA_TUBER = (new FoodProperties.Builder())
            .nutrition(6).saturationModifier(0.3f)
            .build();

    FoodProperties GLOW_CASHEWS = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0.2f)
            .effect(() -> new MobEffectInstance(ModEffects.SKY_TRACTION, 2400, 0), 1)
            .alwaysEdible().build();
}
