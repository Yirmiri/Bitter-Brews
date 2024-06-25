package net.azurune.bitter_brews.item;

import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.registry.RegisterItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.List;

public class GenericDrinkItem extends Item {
    private final int useTime;
    private final boolean hasTooltip;

    public GenericDrinkItem(Item.Settings settings, int useTime, boolean hasTooltip) {
        super(settings);
        this.useTime = useTime;
        this.hasTooltip = hasTooltip;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext ctx, List<Text> tooltip, TooltipType options) {
        super.appendTooltip(stack, ctx, tooltip, options);
        if (hasTooltip) {
            tooltip.add(BitterBrews.id("tooltip." + this).formatted(Formatting.BLUE));
        } else {
            tooltip.add(Text.translatable("effect.none").formatted(Formatting.GRAY));
        }
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
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

    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return useTime;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public SoundEvent getDrinkSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}
