package net.yirmiri.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.yirmiri.register.BBDamageTypes;
import net.yirmiri.register.BBItems;

public class SoulPepperCropBlock extends NetherWartBlock {
    public SoulPepperCropBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState( (this.stateManager.getDefaultState()).with(AGE, 0));
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(BBItems.SOUL_PEPPER_SEEDS);
    }

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        int i = state.get(AGE);
        if (!entity.bypassesSteppingEffects() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity) && i >= 2) {
            entity.damage(BBDamageTypes.of(world, BBDamageTypes.SOUL_PEPPER), 2);
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    public static boolean mature(BlockState state) {
        int i = state.get(AGE);
        return i < 2;
    }
}
