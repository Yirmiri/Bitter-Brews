package net.azurune.bitter_brews.block;

import net.azurune.bitter_brews.registry.RegisterDamageTypes;
import net.azurune.bitter_brews.registry.RegisterItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class SoulPepperCropBlock extends NetherWartBlock {
    public SoulPepperCropBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState( (this.stateManager.getDefaultState()).with(AGE, 0));
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(RegisterItems.SOUL_PEPPER_SEEDS);
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        int age = state.get(AGE);
        if (!entity.bypassesSteppingEffects() && entity instanceof LivingEntity && age >= 2) {
            entity.damage(RegisterDamageTypes.of(world, RegisterDamageTypes.SOUL_PEPPER), 2);
        }
        super.onEntityCollision(state, world, pos, entity);
    }

    public static boolean mature(BlockState state) {
        int age = state.get(AGE);
        return age < 2;
    }
}
