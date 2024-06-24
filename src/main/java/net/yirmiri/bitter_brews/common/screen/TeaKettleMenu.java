package net.yirmiri.bitter_brews.common.screen;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.yirmiri.bitter_brews.BitterBrewsConstants;
import net.yirmiri.bitter_brews.common.block_entity.TeaKettleBlockEntity;
import net.yirmiri.bitter_brews.common.item.GenericDrinkItem;
import net.yirmiri.bitter_brews.common.screen.slot.SimpleOutputSlot;
import net.yirmiri.bitter_brews.common.screen.slot.TeaKettleSlot;
import net.yirmiri.bitter_brews.core.registry.BBMenuTypes;

public class TeaKettleMenu extends AbstractContainerMenu {
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    private final ContainerData data;
    private final Container container;

    public TeaKettleMenu(int container, Inventory inventory) {
        this(container, inventory, new SimpleContainer(TeaKettleBlockEntity.INVENTORY_SLOT_COUNT), new SimpleContainerData(6));
    }

    public TeaKettleMenu(int containerInt, Inventory inv, Container container, ContainerData data) {
        super(BBMenuTypes.TEA_KETTLE_MENU.get(), containerInt);
        checkContainerSize(inv, TeaKettleBlockEntity.INVENTORY_SLOT_COUNT);
        this.data = data;
        this.container = container;
        buildSlots(container);
        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        addDataSlots(data);
    }

    private void buildSlots(Container container) {
        this.addSlot(new TeaKettleSlot(container, 0, 27, 68, stack -> stack.getItem() instanceof GenericDrinkItem));
        this.addSlot(new TeaKettleSlot(container, 1, 17, 26, stack -> !(stack.getItem() instanceof GenericDrinkItem)));
        this.addSlot(new TeaKettleSlot(container, 2, 37, 26, stack -> !(stack.getItem() instanceof GenericDrinkItem)));
        this.addSlot(new TeaKettleSlot(container, 3, 17, 46, stack -> !(stack.getItem() instanceof GenericDrinkItem)));
        this.addSlot(new TeaKettleSlot(container, 4, 37, 46, stack -> !(stack.getItem() instanceof GenericDrinkItem)));
        this.addSlot(new SimpleOutputSlot(container, 5, 99, 46));
    }//

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressBarSize = 50;

        return maxProgress != 0 && progress != 0 ? progress * progressBarSize / maxProgress : 0;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot sourceSlot = this.slots.get(index);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, INVENTORY_FIRST_SLOT_INDEX, INVENTORY_FIRST_SLOT_INDEX + TeaKettleBlockEntity.INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else if (index < INVENTORY_FIRST_SLOT_INDEX + TeaKettleBlockEntity.INVENTORY_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            BitterBrewsConstants.LOGGER.warn("Invalid slotIndex: {}", index);
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(player, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    private void addPlayerInventory(Inventory inventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(inventory, l + i * 9 + 9, 9 + l * 18, 97 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory inventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(inventory, i, 9 + i * 18, 155));
        }
    }

}
