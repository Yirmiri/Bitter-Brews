package net.azurune.bitter_brews.common.block_entity;


import net.azurune.bitter_brews.common.recipe.TeaKettleRecipe;
import net.azurune.bitter_brews.common.screen.TeaKettleMenu;
import net.azurune.bitter_brews.core.registry.BBBlockEntityTypes;
import net.azurune.bitter_brews.core.registry.BBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class TeaKettleBlockEntity extends BlockEntity implements MenuProvider, ImplementedInventory {

    private static final int CUP_SLOT = 0;
    private static final int INPUT_SLOT_1 = 1;
    private static final int INPUT_SLOT_2 = 2;
    private static final int INPUT_SLOT_3 = 3;
    private static final int INPUT_SLOT_4 = 4;
    private static final int OUTPUT_SLOT = 5;

    protected final ContainerData containerData;
    private int progress = 0;
    private int maxProgress = 200;

    //private static BooleanProperty teaKettleBlock;
    private final NonNullList<ItemStack> items = NonNullList.withSize(6, ItemStack.EMPTY);

    public TeaKettleBlockEntity(BlockPos pos, BlockState state) {
        super(BBBlockEntityTypes.TEA_KETTLE_BLOCK_ENTITY.get(), pos, state);
        //teaKettleBlock = ((TeaKettleBlock)state.getBlock()).getMillingState();
        this.containerData = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> TeaKettleBlockEntity.this.progress;
                    case 1 -> TeaKettleBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: TeaKettleBlockEntity.this.progress = value;
                    case 1: TeaKettleBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }


    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        ContainerHelper.saveAllItems(nbt, items);
        nbt.putInt("tea_kettle.progress", progress);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        ContainerHelper.loadAllItems(nbt, items);
        progress = nbt.getInt("tea_kettle.progress");
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("This took too much work honestly");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(getContainerSize());
        for(int i = 0; i < getContainerSize(); i++) {
            inventory.setItem(i, getItem(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }
    private boolean isCrafting() {
        return hasRecipe() && canInsertOutputSlot();
    }

    public void tick(Level world, BlockPos pos, BlockState state) {
        System.out.println(hasRecipe());
        System.out.println(isCrafting());
        System.out.println(progress);
        if (!world.isClientSide()) {
            if (canInsertOutputSlot() && hasRecipe()) {
                increaseCraftingProgress();
                setChanged(world, pos, state);
                if (hasCraftingFinished()) {
                    craftItem();
                    resetProgress();
                }
            } else {
                decreaseCraftingProgress();
            }
        }
    }
    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Optional<TeaKettleRecipe> recipe = getCurrentRecipe();

        this.removeItem(INPUT_SLOT_1, 1);
        this.setItem(OUTPUT_SLOT, new ItemStack(recipe.get().getResultItem(null).getItem(),
                this.getItem(OUTPUT_SLOT).getCount() + recipe.get().getResultItem(null).getCount()));
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }
    private void decreaseCraftingProgress() {
        if (this.progress > 0) {
            this.progress -= 2;
        }
    }

    private boolean hasRecipe() {
        Optional<TeaKettleRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) return false;
        ItemStack output = recipe.get().getResultItem(null);

        return canInsertAmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getItem(OUTPUT_SLOT).isEmpty() || this.getItem(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getItem(OUTPUT_SLOT).getMaxStackSize() >= this.getItem(OUTPUT_SLOT).getCount() + count;
    }

    private Optional<TeaKettleRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.getContainerSize());
        for (int i = 0; i < this.getContainerSize(); i++) {
            inventory.setItem(i, this.getItem(i));
        }
        return this.getLevel().getRecipeManager().getRecipeFor(TeaKettleRecipe.Type.INSTANCE, inventory, this.getLevel());
    }

    private boolean canInsertOutputSlot() {
        return this.getItem(OUTPUT_SLOT).isEmpty() ||
                this.getItem(OUTPUT_SLOT).getCount() < this.getItem(OUTPUT_SLOT).getMaxStackSize();
    }


    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new TeaKettleMenu(i, inventory);
    }

    /**
     * Gets the item list of this inventory.
     * Must return the same instance every time it's called.
     *
     * @return the item list
     */
    @Override
    public NonNullList<ItemStack> getItems() {
        return items;
    }

    @Nullable @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}