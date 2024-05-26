package net.yirmiri.block;

import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.yirmiri.register.BBItems;

public class PepperCropBlock extends NetherWartBlock {
    public PepperCropBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState( (this.stateManager.getDefaultState()).with(AGE, 0));
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(BBItems.PEPPER_SEEDS);
    }
}
