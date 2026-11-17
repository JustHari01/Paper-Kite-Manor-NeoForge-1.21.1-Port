package com.kazi_cat.papercraft_magic_decoration.block.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class MultipartBlock extends LegacyUseBlock {
    private static final ConcurrentMap<Integer, IntegerProperty> PART_PROPERTIES = new ConcurrentHashMap<>();
    protected final IntegerProperty partProperty;

    public MultipartBlock(Properties properties, int parts) {
        super(properties);
        this.partProperty = partProperty(parts);
    }

    public static IntegerProperty partProperty(int parts) {
        return PART_PROPERTIES.computeIfAbsent(parts, count -> IntegerProperty.create("part", 0, count - 1));
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        handleRemove(level, pos, state, player);
        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void onBlockExploded(BlockState state, Level level, BlockPos pos, Explosion explosion) {
        handleRemove(level, pos, state, null);
        super.onBlockExploded(state, level, pos, explosion);
    }

    @Override
    public @Nullable PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.BLOCK;
    }

    public abstract List<BlockPos> getOrderedParts(BlockPos pos, BlockState state);

    public void handleRemove(Level level, BlockPos pos, BlockState state, @Nullable Player player) {
        boolean drop = !(player != null && player.isCreative());
        for (var part : getOrderedParts(pos, state)) {
            level.destroyBlock(part, drop);
        }
    }

    public IntegerProperty getPartProperty() { return this.partProperty; }
}
