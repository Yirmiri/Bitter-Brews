package net.azurune.bitter_brews.common.screen;

import net.azurune.bitter_brews.BitterBrewsConstants;
import net.azurune.bitter_brews.common.block_entity.TeaKettleBlockEntity;
import net.azurune.bitter_brews.common.item.GenericDrinkItem;
import net.azurune.bitter_brews.common.screen.slot.SimpleOutputSlot;
import net.azurune.bitter_brews.common.screen.slot.TeaKettleSlot;
import net.azurune.bitter_brews.core.registry.BBMenuTypes;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerListener;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class TeaKettleMenu extends AbstractContainerMenu implements ContainerListener {
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int INVENTORY_SLOT_COUNT = 6;
    private static final int INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    private final ContainerData data;
    private final TeaKettleBlockEntity kettle;
    private final SimpleContainer container;

    public TeaKettleMenu(int container, Inventory inventory, TeaKettleBlockEntity kettle, List<ItemStack> stacks) {
        this(container, inventory, new SimpleContainer(6), new SimpleContainerData(6), kettle, stacks);
    }

    public TeaKettleMenu(int container, Inventory inventory) {
        this(container, inventory, new SimpleContainer(6), new SimpleContainerData(6), null, List.of());
    }

    public TeaKettleMenu(int containerInt, Inventory inv, SimpleContainer container, ContainerData data, TeaKettleBlockEntity kettle, List<ItemStack> stacks) {
        super(BBMenuTypes.TEA_KETTLE_MENU.get(), containerInt);
        checkContainerSize(inv, 6);
        this.data = data;
        this.kettle = kettle;
        this.container = container;
        this.load(stacks);
        container.addListener(this);
        buildSlots(container);
        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        addDataSlots(data);
    }

    private void buildSlots(Container container) {
        this.addSlot(new TeaKettleSlot(container, 0, 28, 92, stack -> stack.getItem() instanceof GenericDrinkItem));
        this.addSlot(new TeaKettleSlot(container, 1, 18, 48, stack -> !(stack.getItem() instanceof GenericDrinkItem)));
        this.addSlot(new TeaKettleSlot(container, 2, 38, 48, stack -> !(stack.getItem() instanceof GenericDrinkItem)));
        this.addSlot(new TeaKettleSlot(container, 3, 18, 70, stack -> !(stack.getItem() instanceof GenericDrinkItem)));
        this.addSlot(new TeaKettleSlot(container, 4, 38, 70, stack -> !(stack.getItem() instanceof GenericDrinkItem)));
        this.addSlot(new SimpleOutputSlot(container, 5, 100, 70));
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
            if (!moveItemStackTo(sourceStack, INVENTORY_FIRST_SLOT_INDEX, INVENTORY_FIRST_SLOT_INDEX + INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else if (index < INVENTORY_FIRST_SLOT_INDEX + INVENTORY_SLOT_COUNT) {
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
        return true;
    }

    private void addPlayerInventory(Inventory inventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(inventory, l + i * 9 + 9, 8 + l * 18, 126 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory inventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(inventory, i, 18 + i * 18, 176));
        }
    }

    @Override
    public void containerChanged(Container container) {
        if (this.kettle == null) return;
        this.kettle.updateItems(this.getAllContainerItems(container));
    }

    private List<ItemStack> getAllContainerItems(Container container) {
        List<ItemStack> items = new ArrayList<>();
        for (int i = 0; i < container.getContainerSize(); i++) {
            items.add(container.getItem(i));
        }
        return items;
    }

    public void updateOutput(ItemStack stack) {
        this.container.setItem(5, stack);
    }

    public TeaKettleMenu load(List<ItemStack> stacks) {
        for (int i = 0; i < stacks.size(); i++) {
            this.container.setItem(i, stacks.get(i));
        }
        return this;
    }

}
