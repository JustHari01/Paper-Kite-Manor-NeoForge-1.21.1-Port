package com.kazi_cat.papercraft_magic_decoration.network.message;

import com.kazi_cat.papercraft_magic_decoration.PaperKiteManor;
import com.kazi_cat.papercraft_magic_decoration.datamap.data.SmeltableBlockData;
import com.kazi_cat.papercraft_magic_decoration.datamap.resources.SmeltableBlockDataReloadListener;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public final class SmeltableBlockDataSyncS2CMessage implements CustomPacketPayload {
    private static final String ENTRIES = "entries";

    public static final Type<SmeltableBlockDataSyncS2CMessage> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath(PaperKiteManor.MOD_ID, "smeltable_block_data_sync"));

    public static final StreamCodec<RegistryFriendlyByteBuf, SmeltableBlockDataSyncS2CMessage> STREAM_CODEC = new StreamCodec<>() {
        @Override
        public SmeltableBlockDataSyncS2CMessage decode(RegistryFriendlyByteBuf buf) {
            CompoundTag data = buf.readNbt();
            return new SmeltableBlockDataSyncS2CMessage(data == null ? new CompoundTag() : data);
        }

        @Override
        public void encode(RegistryFriendlyByteBuf buf, SmeltableBlockDataSyncS2CMessage message) {
            buf.writeNbt(message.data);
        }
    };

    private final CompoundTag data;

    public SmeltableBlockDataSyncS2CMessage(CompoundTag data) {
        this.data = data.copy();
    }

    public static SmeltableBlockDataSyncS2CMessage fromServer() {
        CompoundTag syncData = new CompoundTag();
        ListTag entries = new ListTag();
        for (SmeltableBlockData entry : SmeltableBlockDataReloadListener.INSTANCE.values()) {
            var result = SmeltableBlockData.CODEC.encodeStart(NbtOps.INSTANCE, entry);
            result.result().ifPresentOrElse(tag -> {
                if (tag instanceof CompoundTag compoundTag) {
                    entries.add(compoundTag);
                }
            }, () -> result.error().ifPresent(error -> PaperKiteManor.LOGGER.error(
                    "Failed to encode smeltable block data for sync: {}", error.message())));
        }
        syncData.put(ENTRIES, entries);
        return new SmeltableBlockDataSyncS2CMessage(syncData);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        SmeltableBlockDataReloadListener.INSTANCE.clear();
        ListTag entries = data.getList(ENTRIES, Tag.TAG_COMPOUND);
        for (int i = 0; i < entries.size(); i++) {
            CompoundTag entry = entries.getCompound(i);
            var result = SmeltableBlockData.CODEC.parse(NbtOps.INSTANCE, entry);
            result.result().ifPresentOrElse(value -> SmeltableBlockDataReloadListener.INSTANCE.put(value.block(), value),
                    () -> result.error().ifPresent(error -> PaperKiteManor.LOGGER.error(
                            "Failed to decode synced smeltable block data: {}", error.message())));
        }
    }
}