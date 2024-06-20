package net.azurune.bitter_brews.common.block_entity;


import net.azurune.bitter_brews.common.recipe.CopperKettleRecipe;
import net.azurune.bitter_brews.common.screen.CopperKettleMenu;
import net.azurune.bitter_brews.core.registry.BBBlockEntityTypes;
import net.azurune.bitter_brews.core.registry.BBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CopperKettleBlockEntity extends BlockEntity implements MenuProvider, WorldlyContainer {
    private static final int OUTPUT_SLOT = 5;
    public static final int INVENTORY_SLOT_COUNT = 6;
    private static final int[] SLOTS = {0,2,3,4,5};
    protected final ContainerData containerData;
    private int progress = 0;
    private int maxProgress = 200;

    private final NonNullList<ItemStack> items = NonNullList.withSize(INVENTORY_SLOT_COUNT, ItemStack.EMPTY);

    public CopperKettleBlockEntity(BlockPos pos, BlockState state) {
        super(BBBlockEntityTypes.COPPER_KETTLE_BLOCK_ENTITY.get(), pos, state);
        this.containerData = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CopperKettleBlockEntity.this.progress;
                    case 1 -> CopperKettleBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        CopperKettleBlockEntity.this.progress = value;
                    case 1:
                        CopperKettleBlockEntity.this.maxProgress = value;
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
        nbt.putInt("copper_kettle.progress", progress);
        ContainerHelper.saveAllItems(nbt, items);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.progress = nbt.getInt("copper_kettle.progress");
        ContainerHelper.loadAllItems(nbt, items);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Rebel :D");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(getContainerSize());
        for (int i = 0; i < getContainerSize(); i++) {
            inventory.setItem(i, getItem(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    private boolean isCrafting() {
        return hasRecipe() && canInsertOutputSlot();
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        BlockState blockState = level.getBlockState(pos.below());
        if (!level.isClientSide()) {
            if (blockState.is(BBTags.BlockTags.HEAT_SOURCES) || getLevel().dimensionType().piglinSafe()) {
                if (canInsertOutputSlot() && hasRecipe()) {
                    increaseCraftingProgress();
                    setChanged(level, pos, state);
                    if (hasCraftingFinished()) {
                        craftItem();
                        resetProgress();
                    }
                } else {
                    decreaseCraftingProgress();
                }
            }
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Optional<CopperKettleRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            ItemStack current = this.getItem(i);
            if (recipe.get().containsItem(current)) {
                this.removeItem(i, 1);
            }

            if (level instanceof ServerLevel) {
                ExperienceOrb.award((ServerLevel)level, Vec3.atCenterOf(this.getBlockPos()), 1);
            }
        }

        this.setItem(OUTPUT_SLOT, new ItemStack(recipe.get().getResultItem(this.getLevel().registryAccess()).getItem(),
                this.getItem(OUTPUT_SLOT).getCount() + recipe.get().getResultItem(
                        this.getLevel().registryAccess()).getCount()));
        setChanged();
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
        Optional<CopperKettleRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) return false;
        ItemStack output = recipe.get().getResultItem(this.getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getItem(OUTPUT_SLOT).isEmpty() || this.getItem(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getItem(OUTPUT_SLOT).getMaxStackSize() >= this.getItem(OUTPUT_SLOT).getCount() + count;
    }

    private Optional<CopperKettleRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.getContainerSize());
        for (int i = 0; i < this.getContainerSize(); i++) {
            inventory.setItem(i, this.getItem(i));
        }
        return this.getLevel().getRecipeManager().getRecipeFor(CopperKettleRecipe.Type.INSTANCE, inventory, this.getLevel());
    }

    private boolean canInsertOutputSlot() {
        return this.getItem(OUTPUT_SLOT).isEmpty() || this.getItem(OUTPUT_SLOT).getCount() < this.getItem(OUTPUT_SLOT).getMaxStackSize();
    }

    @Nullable @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new CopperKettleMenu(i, inventory, this, this.containerData);
    }

    @Nullable @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public int[] getSlotsForFace(final Direction direction) {
        return SLOTS;
    }

    @Override
    public boolean canPlaceItemThroughFace(final int i, final ItemStack itemStack, @Nullable final Direction direction) {
        return true;
    }

    @Override
    public boolean canTakeItemThroughFace(final int i, final ItemStack itemStack, final Direction direction) {
        return true;
    }

    @Override
    public int getContainerSize() {
        return INVENTORY_SLOT_COUNT;
    }

    @Override
    public boolean isEmpty() {
        return this.items.stream().allMatch(ItemStack::isEmpty);
    }

    @Override
    public ItemStack getItem(final int slotIndex) {
        return this.items.get(slotIndex);
    }

    @Override
    public ItemStack removeItem(final int slotIndex, final int count) {
        final ItemStack itemstack = ContainerHelper.removeItem(this.items, slotIndex, count);
        if (!itemstack.isEmpty()) {
            this.setChanged();
        }

        return itemstack;
    }

    @Override
    public ItemStack removeItemNoUpdate(final int slotIndex) {
        return ContainerHelper.takeItem(this.items, slotIndex);
    }

    @Override
    public void setItem(final int slotIndex, final ItemStack itemStack) {
        this.items.set(slotIndex, itemStack);
        if (itemStack.getCount() > this.getMaxStackSize()) {
            itemStack.setCount(this.getMaxStackSize());
        }
        this.setChanged();
    }

    @Override
    public boolean stillValid(final Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }
}
