package com.kazi_cat.papercraft_magic_decoration.event.effect;

import net.neoforged.fml.common.EventBusSubscriber;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.init.ModEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

import java.util.Objects;

@EventBusSubscriber(modid = PaperKiteManor.MOD_ID)
public class AcidJazzEvent {
    @SubscribeEvent
    public static void onLivingHurt(LivingIncomingDamageEvent event) {
        LivingEntity target = event.getEntity();
        Level level = target.level();
        if (!(target.hasEffect(ModEffects.ACID_JAZZ)) || level.isClientSide()) {
            return;
        }

        MobEffectInstance instance = Objects.requireNonNull(target.getEffect(ModEffects.ACID_JAZZ));
        float multiplier = (float) (1 - 0.8 * (1 - Math.pow(0.5, instance.getAmplifier() + 1)));
        float amount = event.getAmount();
        event.setAmount(amount * multiplier);

        if (event.getSource().getEntity() instanceof LivingEntity living && living.isAlive()) {
            living.hurt(target.damageSources().magic(), amount * (1 - multiplier));
            Vec3 knockback = living.position().add(target.position().multiply(-1, -1, -1))
                    .normalize().multiply(1.5, 1.5, 1.5);
            living.addDeltaMovement(knockback);
            level.playSound(null, living.blockPosition(), SoundEvents.FIRE_EXTINGUISH, SoundSource.NEUTRAL);
        }
    }
}
