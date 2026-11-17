package com.kazi_cat.papercraft_magic_decoration.init;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.effect.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public interface ModEffects {
    DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, PaperKiteManor.MOD_ID);

    DeferredHolder<MobEffect, ? extends MobEffect> WINES_AROMA = EFFECTS.register("wines_aroma", () -> new WinesAromaEffect(0x8B5DF0));
    DeferredHolder<MobEffect, ? extends MobEffect> BLOODTHIRSTY_DEVIL = EFFECTS.register("bloodthirsty_devil", () -> new BloodThirstyDevilEffect(0xCD0F32));
    DeferredHolder<MobEffect, ? extends MobEffect> CAT_EYE = EFFECTS.register("cat_eye", () -> new CatEyeEffect(0x161231));
    DeferredHolder<MobEffect, ? extends MobEffect> ACID_JAZZ = EFFECTS.register("acid_jazz", () -> new BaseEffect(0xFF831A));
    DeferredHolder<MobEffect, ? extends MobEffect> SKY_TRACTION = EFFECTS.register("sky_traction", () -> new SkyTractionEffect(0x8ABBCB));
    DeferredHolder<MobEffect, ? extends MobEffect> LOVE_BAND_AID = EFFECTS.register("love_band_aid", () -> new BaseEffect(0xFFBDD9));
    DeferredHolder<MobEffect, ? extends MobEffect> DOUBLE_ICE_SHOCK = EFFECTS.register("double_ice_shock", () -> new BaseEffect(0xbcfffc));
    DeferredHolder<MobEffect, ? extends MobEffect> SILKY_FEEL = EFFECTS.register("silky_feel", () -> new SilkyFeelEffect(0x2a0e08));
}
