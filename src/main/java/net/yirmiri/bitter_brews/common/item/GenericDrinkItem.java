package net.yirmiri.bitter_brews.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.yirmiri.bitter_brews.BitterBrews;
import net.yirmiri.bitter_brews.core.registry.BBItems;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GenericDrinkItem extends Item {
    private final int useTime;
    private final boolean hasTooltip;

    public GenericDrinkItem(Properties settings, int useTime, boolean hasTooltip) {
        super(settings);
        this.useTime = useTime;
        this.hasTooltip = hasTooltip;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, TooltipContext tooltipContext, @NotNull List<Component> toolTipComponents, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemStack, tooltipContext, toolTipComponents, flag);
        if (hasTooltip) {
            toolTipComponents.add(BitterBrews.tooltipId("tooltip." + this).withStyle(ChatFormatting.BLUE));
        } else {
            toolTipComponents.add(Component.translatable("effect.none").withStyle(ChatFormatting.GRAY));
        }
    }

    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        super.finishUsingItem(stack, world, user);
        if (user instanceof ServerPlayer player) {
            CriteriaTriggers.CONSUME_ITEM.trigger(player, stack);
            player.awardStat(Stats.ITEM_USED.get(this));
        }

        if (stack.isEmpty()) {
            return new ItemStack(BBItems.MUD_CUP.get());
        } else {
            if (user instanceof Player player && !((Player)user).getAbilities().instabuild) {
                ItemStack itemStack = new ItemStack(BBItems.MUD_CUP.get());
                if (!player.getInventory().add(itemStack)) {
                    player.drop(itemStack, false);
                }
            }

            return stack;
        }
    }

    public int getUseDuration(ItemStack stack) {
        return useTime;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(world, user, hand);
    }
}
