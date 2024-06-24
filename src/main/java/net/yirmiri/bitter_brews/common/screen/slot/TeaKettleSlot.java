package net.yirmiri.bitter_brews.common.screen.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.util.function.Predicate;

public class TeaKettleSlot extends Slot {
    private final Predicate<ItemStack> itemFilter;

    public TeaKettleSlot(Container container, int index, int x, int y, Predicate<ItemStack> filter) {
        super(container, index, x, y);
        this.itemFilter = filter;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return this.itemFilter.test(stack);
    }
}
