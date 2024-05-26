package net.yirmiri.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import net.yirmiri.register.BBItems;
import net.yirmiri.register.TLStatusEffects;

public class ExtinguishDrinkItem extends GenericDrinkItem {
    public ExtinguishDrinkItem(Settings settings, int useTime, boolean hasTooltip) {
        super(settings, useTime, hasTooltip);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!user.hasStatusEffect(TLStatusEffects.IMPURE)) {
                user.removeStatusEffect(TLStatusEffects.TRAIL_BLAZING);
            }
            user.extinguishWithSound();
        }

        if (stack.isEmpty()) {
            return new ItemStack(BBItems.MUD_CUP);
        } else {
            if (user instanceof PlayerEntity playerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
                ItemStack itemStack = new ItemStack(BBItems.MUD_CUP);
                if (!playerEntity.getInventory().insertStack(itemStack)) {
                    playerEntity.dropItem(itemStack, false);
                }
            }

            return stack;
        }
    }
}