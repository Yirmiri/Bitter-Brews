package net.azurune.bitter_brews.item;

import net.azurune.bitter_brews.BitterBrews;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class SoulPepperItem extends Item {
    public SoulPepperItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext ctx, List<Text> tooltip, TooltipType options) {
        super.appendTooltip(stack, ctx, tooltip, options);
        tooltip.add(BitterBrews.id("tooltip." + this).formatted(Formatting.BLUE));
    }
}
