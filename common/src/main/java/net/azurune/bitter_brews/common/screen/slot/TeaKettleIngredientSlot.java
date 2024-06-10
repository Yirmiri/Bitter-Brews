package net.azurune.bitter_brews.common.screen.slot;

import net.azurune.bitter_brews.common.item.FuelSlotItem;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class TeaKettleIngredientSlot extends Slot {
    public TeaKettleIngredientSlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return !(stack.getItem() instanceof FuelSlotItem);
    }
}
