package net.azurune.bitter_brews.screen;

import net.azurune.bitter_brews.BitterBrews;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.azurune.bitter_brews.block.block_entity.CopperKettleBlockEntity;
import net.azurune.bitter_brews.item.GenericDrinkItem;
import net.azurune.bitter_brews.screen.slot.SimpleOutputSlot;
import net.azurune.bitter_brews.screen.slot.CopperKettleSlot;
import net.azurune.bitter_brews.registry.RegisterScreenHandlers;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;

public class CopperKettleScreenHandler extends ScreenHandler {
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    private final ScreenHandlerContext ctx;
    private final Inventory inventory;

    public CopperKettleScreenHandler(int container, Inventory inventory) {
        this(container, inventory, new SimpleInventory(CopperKettleBlockEntity.INVENTORY_SLOT_COUNT), Scree);
    }

    public CopperKettleScreenHandler(int containerInt, Inventory inv, Inventory inventory, ScreenHandlerContext ctx) {
        super(RegisterScreenHandlers.TEA_KETTLE_SCREEN_HANDLER.get(), containerInt);

        checkSize(inv, CopperKettleBlockEntity.INVENTORY_SLOT_COUNT);
        this.ctx = ctx;
        this.inventory = inventory;

        buildSlots(inventory);
        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        addProperties(ctx); //TODO: THIS IS WORKING WITH PROPERTY DELEGATES, CHANGE TO CONTEXT
    }

    private void buildSlots(Inventory inventory) {
        this.addSlot(new IngredientSlot(inventory, 0, 27, 68));
        this.addSlot(new IngredientSlot(inventory, 1, 17, 26));
        this.addSlot(new IngredientSlot(inventory, 2, 37, 26));
        this.addSlot(new IngredientSlot(inventory, 3, 17, 46));
        this.addSlot(new IngredientSlot(inventory, 4, 37, 46));

        this.addSlot(new OutputSlot(inventory, 5, 99, 46));
    }

    public boolean isCrafting() {
        return ctx.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.ctx.get(0);
        int maxProgress = this.ctx.get(1);
        int progressBarSize = 50;

        return maxProgress != 0 && progress != 0 ? progress * progressBarSize / maxProgress : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        Slot sourceSlot = this.slots.get(index);
        if (!sourceSlot.hasStack()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getStack();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if (!insertItem(sourceStack, INVENTORY_FIRST_SLOT_INDEX, INVENTORY_FIRST_SLOT_INDEX + CopperKettleBlockEntity.INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else if (index < INVENTORY_FIRST_SLOT_INDEX + CopperKettleBlockEntity.INVENTORY_SLOT_COUNT) {
            if (!insertItem(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            BitterBrews.LOGGER.warn("Invalid slotIndex: {}", index);
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) {
            sourceSlot.setStackNoCallbacks(ItemStack.EMPTY);
        } else {
            sourceSlot.markDirty();
        }
        sourceSlot.onTakeItem(player, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
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


class IngredientSlot extends Slot {
    public IngredientSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return !(stack.getItem() instanceof GenericDrinkItem);
    }
}

class OutputSlot extends Slot {
    public OutputSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }
}