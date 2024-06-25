package net.azurune.bitter_brews.block;

import net.azurune.bitter_brews.registry.RegisterItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class PepperCropBlock extends NetherWartBlock {
    public PepperCropBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState( (this.stateManager.getDefaultState()).with(AGE, 0));
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(RegisterItems.PEPPER_SEEDS);
    }
}
