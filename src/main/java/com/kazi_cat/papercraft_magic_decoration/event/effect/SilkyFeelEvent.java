package com.kazi_cat.papercraft_magic_decoration.event.effect;

import net.neoforged.fml.common.EventBusSubscriber;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.init.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

@EventBusSubscriber(modid = PaperKiteManor.MOD_ID)
public class SilkyFeelEvent {
    @SubscribeEvent
    public static void onLivingTick(EntityTickEvent.Pre event) {
        if (!(event.getEntity() instanceof LivingEntity entity)) {
            return;
        }
        MobEffectInstance effect = entity.getEffect(ModEffects.SILKY_FEEL);
        if (effect != null) {
            float targetFriction = 0.98F * (entity.onGround() ? 0.98F : 1);
            Vec3 delta = entity.getDeltaMovement();
            entity.setDeltaMovement(delta.x * targetFriction, delta.y, delta.z * targetFriction);
        }
    }
}
