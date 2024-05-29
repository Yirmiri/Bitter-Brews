package net.azurune.bitter_brews.common.item;

import net.azurune.bitter_brews.core.registry.BBItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class CupItem extends Item {
    public CupItem(Item.Properties settings) {
        super(settings);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        BlockHitResult blockHitResult = getPlayerPOVHitResult(level, user, ClipContext.Fluid.SOURCE_ONLY);
        if (blockHitResult.getType() != HitResult.Type.MISS) {
            if (blockHitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = blockHitResult.getBlockPos();
                if (!level.mayInteract(user, blockPos)) {
                    return InteractionResultHolder.pass(itemStack);
                }

                if (level.getFluidState(blockPos).is(FluidTags.WATER)) {
                    level.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                    level.gameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
                    return InteractionResultHolder.success(this.fill(itemStack, user, (new ItemStack(BBItems.CUP_OF_WATER.get()))));
                }
            }

        }
        return InteractionResultHolder.pass(itemStack);
    }

    protected ItemStack fill(ItemStack stack, Player player, ItemStack outputStack) {
        player.awardStat(Stats.ITEM_USED.get(this));
        return ItemUtils.createFilledResult(stack, player, outputStack);
    }
}
