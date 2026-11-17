package com.kazi_cat.papercraft_magic_decoration.network.message;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.entity.BlackCatLobbyBoyEntity;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.ArrayList;
import java.util.List;

public record OffersSyncS2CMessage(int entityId, List<BlackCatLobbyBoyEntity.Offer> offers)
        implements CustomPacketPayload {
    private static final int MAX_OFFERS = 64;

    public static final Type<OffersSyncS2CMessage> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath(PaperKiteManor.MOD_ID, "offers_sync"));

    public static final StreamCodec<RegistryFriendlyByteBuf, OffersSyncS2CMessage> STREAM_CODEC = new StreamCodec<>() {
        @Override
        public OffersSyncS2CMessage decode(RegistryFriendlyByteBuf buf) {
            int entityId = buf.readVarInt();
            int length = buf.readVarInt();
            if (length < 0 || length > MAX_OFFERS) {
                throw new IllegalArgumentException("Invalid offer list length: " + length);
            }
            List<BlackCatLobbyBoyEntity.Offer> offers = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                int price = buf.readVarInt();
                int tradeLimit = buf.readVarInt();
                offers.add(BlackCatLobbyBoyEntity.Offer.of(price, ItemStack.STREAM_CODEC.decode(buf), tradeLimit));
            }
            return new OffersSyncS2CMessage(entityId, offers);
        }

        @Override
        public void encode(RegistryFriendlyByteBuf buf, OffersSyncS2CMessage message) {
            if (message.offers.size() > MAX_OFFERS) {
                throw new IllegalArgumentException("Too many offers to sync: " + message.offers.size());
            }
            buf.writeVarInt(message.entityId);
            buf.writeVarInt(message.offers.size());
            message.offers.forEach(offer -> {
                buf.writeVarInt(offer.price);
                buf.writeVarInt(offer.tradeLimit);
                ItemStack.STREAM_CODEC.encode(buf, offer.result);
            });
        }
    };

    public OffersSyncS2CMessage {
        offers = List.copyOf(offers);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        Entity entity = context.player().level().getEntity(entityId);
        if (entity instanceof BlackCatLobbyBoyEntity blackCat) {
            blackCat.setOffers(offers);
        }
    }
}
