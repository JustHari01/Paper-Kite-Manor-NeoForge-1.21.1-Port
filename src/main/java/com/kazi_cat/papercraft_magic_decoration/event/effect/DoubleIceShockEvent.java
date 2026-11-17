package com.kazi_cat.papercraft_magic_decoration.event.effect;

import net.neoforged.fml.common.EventBusSubscriber;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.init.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

import java.util.Objects;

@EventBusSubscriber(modid = PaperKiteManor.MOD_ID)
public class DoubleIceShockEvent {
    @SubscribeEvent
    public static void onCriticalHit(CriticalHitEvent event) {
        if (event.isCriticalHit()) {
            if (event.getTarget().level().isClientSide() || !(event.getTarget() instanceof LivingEntity living)) return;
            if (!event.getEntity().hasEffect(ModEffects.DOUBLE_ICE_SHOCK)) return;
            MobEffectInstance effectInstance = Objects.requireNonNull(event.getEntity().getEffect(ModEffects.DOUBLE_ICE_SHOCK));

            event.setDamageMultiplier(event.getDamageMultiplier() * (effectInstance.getAmplifier() + 2));
            event.setCriticalHit(true);

            living.addEffect(new MobEffectInstance(
                    MobEffects.MOVEMENT_SLOWDOWN,
                    60,
                    effectInstance.getAmplifier()
            ));
        }
    }
}
