package net.azurune.bitter_brews.common.block;

import net.azurune.bitter_brews.core.registry.BBDamageTypes;
import net.azurune.bitter_brews.core.registry.BBItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class SoulPepperCropBlock extends PepperCropBlock {
    public SoulPepperCropBlock(BlockBehaviour.Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
        return new ItemStack(BBItems.SOUL_PEPPER_SEEDS.get());
    }

    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        int age = state.getValue(AGE);
        if (!entity.isSteppingCarefully() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity) && age >= 2) {
            DamageSource damagesource = new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(BBDamageTypes.SOUL_PEPPER));
            entity.hurt(damagesource, 2);
        }
        super.entityInside(state, world, pos, entity);
    }

    public static boolean mature(BlockState state) {
        int age = state.getValue(AGE);
        return age < 2;
    }
}
