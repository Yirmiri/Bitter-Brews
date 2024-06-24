package net.yirmiri.bitter_brews.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yirmiri.bitter_brews.common.block_entity.TeaKettleBlockEntity;
import net.yirmiri.bitter_brews.core.registry.BBBlockEntityTypes;
import org.jetbrains.annotations.Nullable;

public class TeaKettleBlock extends HorizontalDirectionalBlockWithBlockEntity {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final VoxelShape SHAPE;

    public TeaKettleBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }
    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TeaKettleBlockEntity(blockPos, blockState);
    }


    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            BlockEntity entity = level.getBlockEntity(pos);
            if(entity instanceof TeaKettleBlockEntity teaKettleBlockEntity) {
                player.openMenu(teaKettleBlockEntity);
            } else {
                throw new IllegalStateException("It seems our container is missing, uh oh!");
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Nullable @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState blockState, BlockEntityType<T> entityType) {
        if(world.isClientSide()) {
            return null;
        }

        return createTickerHelper(entityType, BBBlockEntityTypes.TEA_KETTLE_BLOCK_ENTITY.get(), (level, pos, state, blockEntity) -> blockEntity.tick(level, pos, state));
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState blockState, boolean isMoving) {
        if (state.getBlock() != blockState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof TeaKettleBlockEntity) {
                ((TeaKettleBlockEntity) blockEntity).drops();
            }
        }

        super.onRemove(state, level, pos, blockState, isMoving);
    }

    static { //wtf
        SHAPE = Block.box(3, 0, 3, 13, 7, 13);
        Block.box(4, 7, 4, 12, 8, 12);
        Block.box(-0.5, 6, 7, 5, 8.5, 9);
        Block.box(3, 7, 8, 13, 13, 8);
        Block.box(13, 0, 8, 18, 7, 8);
        Block.box(-1.5, 5.75, 6.75, 1.75, 7.5, 9.25);
    }
}
