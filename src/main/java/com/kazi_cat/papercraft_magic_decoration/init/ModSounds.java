package com.kazi_cat.papercraft_magic_decoration.init;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;

public interface ModSounds {
    DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, PaperKiteManor.MOD_ID);

    DeferredHolder<SoundEvent, ? extends SoundEvent> AOAO_IDLE = SOUND_EVENTS.register("entity.aoao_idle", () -> SoundEvent.createVariableRangeEvent(PaperKiteManor.modLoc("entity.aoao_idle")));
    DeferredHolder<SoundEvent, ? extends SoundEvent> AOAO_HURT = SOUND_EVENTS.register("entity.aoao_hurt", () -> SoundEvent.createVariableRangeEvent(PaperKiteManor.modLoc("entity.aoao_hurt")));
    DeferredHolder<SoundEvent, ? extends SoundEvent> AOAO_DEATH = SOUND_EVENTS.register("entity.aoao_death", () -> SoundEvent.createVariableRangeEvent(PaperKiteManor.modLoc("entity.aoao_death")));
    DeferredHolder<SoundEvent, ? extends SoundEvent> PAPER_TIGER_IDLE = SOUND_EVENTS.register("entity.paper_tiger_idle", () -> SoundEvent.createVariableRangeEvent(PaperKiteManor.modLoc("entity.paper_tiger_idle")));
    DeferredHolder<SoundEvent, ? extends SoundEvent> PAPER_TIGER_DEATH = SOUND_EVENTS.register("entity.paper_tiger_death", () -> SoundEvent.createVariableRangeEvent(PaperKiteManor.modLoc("entity.paper_tiger_death")));
    DeferredHolder<SoundEvent, ? extends SoundEvent> LOUD_BUTTON_PRESSED = SOUND_EVENTS.register("block.loud_button_pressed", () -> SoundEvent.createVariableRangeEvent(PaperKiteManor.modLoc("block.loud_button_pressed")));
    DeferredHolder<SoundEvent, ? extends SoundEvent> COCKTAIL_SHAKING = SOUND_EVENTS.register("block.cocktail_shaking", () -> SoundEvent.createVariableRangeEvent(PaperKiteManor.modLoc("block.cocktail_shaking")));
    DeferredHolder<SoundEvent, ? extends SoundEvent> ORGAN = SOUND_EVENTS.register("block.organ", () -> SoundEvent.createVariableRangeEvent(PaperKiteManor.modLoc("block.organ")));
    DeferredHolder<SoundEvent, ? extends SoundEvent> KAZI_STAR = SOUND_EVENTS.register("kazi_star", () -> SoundEvent.createVariableRangeEvent(PaperKiteManor.modLoc("kazi_star")));
}
