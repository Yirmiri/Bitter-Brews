package net.yirmiri.bitter_brews.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.yirmiri.bitter_brews.core.registry.BBDamageTypes;
import net.yirmiri.bitter_brews.core.registry.BBItems;

public class SoulPepperCropBlock extends NetherWartBlock {
    public SoulPepperCropBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(BBItems.SOUL_PEPPER_SEEDS.get());
    }

    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        int age = state.getValue(AGE);
        if (!entity.isSteppingCarefully() && entity instanceof LivingEntity && age >= 2) {
            ItemStack itemStack = ((LivingEntity) entity).getItemBySlot(EquipmentSlot.FEET);
            ItemEnchantments itemEnchantments = itemStack.get(DataComponents.ENCHANTMENTS);
            if (!itemEnchantments.equals(Enchantments.FROST_WALKER)) {
                DamageSource damagesource = new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(BBDamageTypes.SOUL_PEPPER));
                entity.hurt(damagesource, 2);
            }
        }
        super.entityInside(state, world, pos, entity);
    }

    public static boolean mature(BlockState state) {
        int age = state.getValue(AGE);
        return age < 2;
    }
}
