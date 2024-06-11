package net.azurune.bitter_brews.common.item;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class LightningDrinkItem extends GenericDrinkItem {

    public LightningDrinkItem(Properties settings, int useTime, boolean hasTooltip) {
        super(settings, useTime, hasTooltip);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity user) {
        for (int i = 0; i < 5; i++) {
            LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            bolt.teleportTo(user.getX() + i - 2.5F, user.getY(), user.getZ() + i - 2.5F);
            level.addFreshEntity(bolt);
        }
        return super.finishUsingItem(stack, level, user);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag context) {
        super.appendHoverText(stack, level, tooltip, context);
        if (level != null && level.isClientSide) {
            boolean matches = Minecraft.getInstance().player.getUUID().equals(UUID.fromString("4bc0a7a9-497a-4aa1-a5af-cee312f94b01"));
            if (matches) tooltip.add(Component.literal("Hi honey!! 💞"));
        }
    }

}
