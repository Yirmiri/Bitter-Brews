package net.azurune.bitter_brews.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class ZeusDrinkItem extends GenericDrinkItem {

    public ZeusDrinkItem(Settings settings, int useTime, boolean hasTooltip) {
        super(settings, useTime, hasTooltip);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        Random random = Random.createThreadSafe();

        for (int i = 0; i < random.nextBetween(1, 5); i++) {
            LightningEntity bolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            bolt.setPos(user.getX() + random.nextBetween(-5, 5) / 2f, user.getY(), user.getZ() + random.nextBetween(-5, 5) / 2f);
            world.spawnEntity(bolt);
        }

        return super.finishUsing(stack, world, user);
    }

    //TODO: cough zeus update the tooltip for 1.21 fabric yourself

//    @Override
//    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag context) {
//        super.appendHoverText(stack, level, tooltip, context);
//        if (level != null && level.isClientSide) {
//            boolean matches = Minecraft.getInstance().player.getUUID().equals(UUID.fromString("4bc0a7a9-497a-4aa1-a5af-cee312f94b01"));
//            if (matches) tooltip.add(Component.literal("Hi honey!! 💞")); //- Zeus
//        }
//    }
}
