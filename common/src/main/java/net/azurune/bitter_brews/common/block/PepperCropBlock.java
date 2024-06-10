package net.azurune.bitter_brews.common.block;

import net.azurune.bitter_brews.core.registry.BBItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class PepperCropBlock extends NetherWartBlock {
    public PepperCropBlock(BlockBehaviour.Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE, 0));
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        int age = state.getValue(AGE);
        if (age < 3 && source.nextInt(10) == 0) {
            grow(state, level, pos);
        }

        if (age < 3 && source.nextInt(10) == 0 && isHot(level, pos) || level.dimensionType().piglinSafe()) {
            grow(state, level, pos);
        }
    }

    public void grow(BlockState state, ServerLevel level, BlockPos pos) {
        int age = state.getValue(AGE);
        state = state.setValue(AGE, Integer.valueOf(age + 1));
        level.setBlock(pos, state, 2);
    }

    public static boolean isHot(LevelReader reader, BlockPos pos) {
        for (BlockPos blockPos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (reader.getFluidState(blockPos).is(FluidTags.LAVA)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
        return new ItemStack(BBItems.PEPPER_SEEDS.get());
    }
}
