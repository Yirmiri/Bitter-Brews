package net.azurune.bitter_brews.block;

import net.azurune.bitter_brews.block.block_entity.CopperKettleBlockEntity;
import net.azurune.bitter_brews.registry.RegisterBlockEntities;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.shape.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CopperKettleBlock extends AbstractKettleBlock {
    public CopperKettleBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CopperKettleBlockEntity(blockPos, blockState);
    }


    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            BlockEntity entity = level.getBlockEntity(pos);
            if(entity instanceof CopperKettleBlockEntity teaKettleBlockEntity) {
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

        return createTickerHelper(entityType, RegisterBlockEntities.TEA_KETTLE_BLOCK_ENTITY.get(), (level, pos, state, blockEntity) -> blockEntity.tick(level, pos, state));
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
}
