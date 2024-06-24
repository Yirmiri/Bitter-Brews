package net.yirmiri.bitter_brews.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public class HorizontalDirectionalBlockWithBlockEntity extends BaseEntityBlock {
    public static final DirectionProperty FACING;

    @Nullable @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return null;
    }

    protected HorizontalDirectionalBlockWithBlockEntity(Properties properties) {
        super(properties);
    }

    public static final MapCodec<HorizontalDirectionalBlockWithBlockEntity> CODEC = simpleCodec(HorizontalDirectionalBlockWithBlockEntity::new);

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return HorizontalDirectionalBlockWithBlockEntity.CODEC;
    }

    public BlockState rotate(BlockState state, Rotation rotate) {
        return state.setValue(FACING, rotate.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
    }
}
