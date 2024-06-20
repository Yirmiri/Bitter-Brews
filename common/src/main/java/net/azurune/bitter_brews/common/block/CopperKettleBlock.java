package net.azurune.bitter_brews.common.block;

import net.azurune.bitter_brews.common.block_entity.CopperKettleBlockEntity;
import net.azurune.bitter_brews.core.registry.BBBlockEntityTypes;
import net.azurune.bitter_brews.core.registry.BBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CopperKettleBlock extends HorizontalDirectionalBlockWithBlockEntity {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final VoxelShape SHAPE;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public CopperKettleBlock(BlockBehaviour.Properties settings) {
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
        builder.add(FACING, LIT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        LevelAccessor accessor = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite())
                .setValue(LIT, Boolean.valueOf(isHeated(accessor.getBlockState(pos.below()))));
    }

    private boolean isHeated(BlockState state) {
        return state.is(BBTags.BlockTags.HEAT_SOURCES);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CopperKettleBlockEntity(blockPos, blockState);
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            BlockEntity entity = level.getBlockEntity(pos);
            if(entity instanceof CopperKettleBlockEntity copperKettleBlockEntity) {
                player.openMenu(copperKettleBlockEntity);
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

        return createTickerHelper(entityType, BBBlockEntityTypes.COPPER_KETTLE_BLOCK_ENTITY.get(), (level, pos, state, blockEntity) -> blockEntity.tick(level, pos, state));
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        if (state.getValue(LIT)) {
            double x = pos.getX() + 0.5;
            double y = pos.getY();
            double z = pos.getZ() + 0.5;
            if (source.nextDouble() < 0.1) {
                level.playLocalSound(x, y, z, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState blockState, boolean isMoving) {
        if (state.getBlock() != blockState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof CopperKettleBlockEntity) {
                ((CopperKettleBlockEntity) blockEntity).drops();
            }
        }

        super.onRemove(state, level, pos, blockState, isMoving);
    }

    static {
        SHAPE = Block.box(3, 0, 3, 13, 7, 13);
        Block.box(4, 7, 4, 12, 8, 12);
        Block.box(-0.5, 6, 7, 5, 8.5, 9);
        Block.box(3, 7, 8, 13, 13, 8);
        Block.box(13, 0, 8, 18, 7, 8);
        Block.box(-1.5, 5.75, 6.75, 1.75, 7.5, 9.25);
    }
}
