package net.yirmiri.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.yirmiri.BitterBrews;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoulPepperItem extends Item {
    public SoulPepperItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
            tooltip.add(BitterBrews.id("tooltip." + this).formatted(Formatting.BLUE));
    }
}
