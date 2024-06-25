package net.azurune.bitter_brews.item;

import net.azurune.bitter_brews.registry.RegisterItems;
import net.azurune.tipsylib.registry.TLStatusEffects;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class ExtinguishDrinkItem extends GenericDrinkItem {
    public ExtinguishDrinkItem(Item.Settings settings, int useTime, boolean hasTooltip) {
        super(settings, useTime, hasTooltip);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!user.hasStatusEffect(TLStatusEffects.IMPURITY)) {
                user.removeStatusEffect(TLStatusEffects.TRAIL_BLAZING);
            }
            user.extinguishWithSound();
        }

        if (stack.isEmpty()) {
            return new ItemStack(RegisterItems.MUD_CUP);
        } else {
            if (user instanceof PlayerEntity playerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
                ItemStack itemStack = new ItemStack(RegisterItems.MUD_CUP);
                if (!playerEntity.getInventory().insertStack(itemStack)) {
                    playerEntity.dropItem(itemStack, false);
                }
            }
            return stack;
        }
    }
}
