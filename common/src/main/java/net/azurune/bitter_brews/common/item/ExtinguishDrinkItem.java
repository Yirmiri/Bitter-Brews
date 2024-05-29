package net.azurune.bitter_brews.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ExtinguishDrinkItem extends GenericDrinkItem {
    public ExtinguishDrinkItem(Properties settings, int useTime, boolean hasTooltip) {
        super(settings, useTime, hasTooltip);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        super.finishUsingItem(stack, world, user);
        if (user instanceof ServerPlayer serverPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.awardStat(Stats.ITEM_USED.get(this));
            if (!user.hasEffect(TLStatusEffects.IMPURE)) {
                user.removeEffect(TLStatusEffects.TRAIL_BLAZING);
            }
            user.extinguishFire();
        }

        if (stack.isEmpty()) {
            return new ItemStack(BBItems.MUD_CUP);
        } else {
            if (user instanceof Player playerEntity && !((Player)user).getAbilities().instabuild) {
                ItemStack itemStack = new ItemStack(BBItems.MUD_CUP);
                if (!playerEntity.getInventory().add(itemStack)) {
                    playerEntity.drop(itemStack, false);
                }
            }

            return stack;
        }
    }
}
