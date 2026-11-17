package com.kazi_cat.papercraft_magic_decoration.network;

import com.kazi_cat.papercraft_magic_decoration.network.message.OffersSyncS2CMessage;
import com.kazi_cat.papercraft_magic_decoration.network.message.SmeltableBlockDataSyncS2CMessage;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public final class NetworkHandler {
    private NetworkHandler() {}

    public static void registerPayloadHandlers(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");
        registrar.playToClient(OffersSyncS2CMessage.TYPE, OffersSyncS2CMessage.STREAM_CODEC,
                OffersSyncS2CMessage::handle);
        registrar.playToClient(SmeltableBlockDataSyncS2CMessage.TYPE, SmeltableBlockDataSyncS2CMessage.STREAM_CODEC,
                SmeltableBlockDataSyncS2CMessage::handle);
    }

    public static void sendToClientPlayer(CustomPacketPayload message, Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            PacketDistributor.sendToPlayer(serverPlayer, message);
        }
    }

    public static void sendToTrackingEntity(CustomPacketPayload message, Entity centerEntity) {
        PacketDistributor.sendToPlayersTrackingEntity(centerEntity, message);
    }

    public static void sendToServer(CustomPacketPayload message) {
        PacketDistributor.sendToServer(message);
    }
}