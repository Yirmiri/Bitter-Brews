package net.yirmiri.bitter_brews.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.yirmiri.bitter_brews.BitterBrews;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SoulPepperItem extends Item {
    public SoulPepperItem(Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, TooltipContext tooltipContext, @NotNull List<Component> toolTipComponents, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemStack, tooltipContext, toolTipComponents, flag);
        toolTipComponents.add(BitterBrews.tooltipId("tooltip." + this).withStyle(ChatFormatting.BLUE));
    }
}
