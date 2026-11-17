package com.kazi_cat.papercraft_magic_decoration.init.registry;

import net.neoforged.fml.common.EventBusSubscriber;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.datamap.resources.SmeltableBlockDataReloadListener;
import com.kazi_cat.papercraft_magic_decoration.network.NetworkHandler;
import com.kazi_cat.papercraft_magic_decoration.network.message.SmeltableBlockDataSyncS2CMessage;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

@EventBusSubscriber(modid = PaperKiteManor.MOD_ID)
public class DatapackReloadListenerEvent {
    @SubscribeEvent
    public static void onAddReloadListenerEvent(AddReloadListenerEvent event) {
        event.addListener(new SmeltableBlockDataReloadListener());
    }

    @SubscribeEvent
    public static void onDatapackSyncEvent(OnDatapackSyncEvent event) {
        SmeltableBlockDataSyncS2CMessage message = SmeltableBlockDataSyncS2CMessage.fromServer();
        event.getRelevantPlayers().forEach(player -> NetworkHandler.sendToClientPlayer(message, player));
    }
}
