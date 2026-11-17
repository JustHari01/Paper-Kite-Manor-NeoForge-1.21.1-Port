package com.kazi_cat.papercraft_magic_decoration.event.effect;

import net.neoforged.fml.common.EventBusSubscriber;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.init.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

import java.util.Objects;

@EventBusSubscriber(modid = PaperKiteManor.MOD_ID)
public class LoveBandAidEvent {
    @SubscribeEvent
    public static void onLivingHurt(LivingIncomingDamageEvent event) {
        LivingEntity target = event.getEntity();
        Level level = target.level();
        if (!(target.hasEffect(ModEffects.LOVE_BAND_AID)) || level.isClientSide()) {
            return;
        }

        int amplifier = Objects.requireNonNull(target.getEffect(ModEffects.LOVE_BAND_AID)).getAmplifier();
        target.heal(amplifier + 1);
        target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, amplifier));
    }
}
