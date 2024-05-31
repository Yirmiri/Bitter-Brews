package net.azurune.bitter_brews.common.block_entity;


import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.common.recipe.TeaKettleRecipe;
import net.azurune.bitter_brews.common.screen.TeaKettleMenu;
import net.azurune.bitter_brews.core.registry.BBBlockEntityTypes;
import net.azurune.bitter_brews.core.registry.BBRecipeSerializer;
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
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class TeaKettleBlockEntity extends BlockEntity implements MenuProvider, ImplementedInventory {

    protected NonNullList<ItemStack> inventory;

    private static final int CUP_SLOT = 0;
    private static final int INPUT_SLOT_1 = 1;
    private static final int INPUT_SLOT_2 = 2;
    private static final int INPUT_SLOT_3 = 3;
    private static final int INPUT_SLOT_4 = 4;
    private static final int OUTPUT_SLOT = 5;

    protected final ContainerData containerData;
    private int progress = 0;
    private int maxProgress = 72;

    public TeaKettleBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BBBlockEntityTypes.TEA_KETTLE_BLOCK_ENTITY.get(), blockPos, blockState);
        this.inventory = NonNullList.withSize(6, ItemStack.EMPTY);
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
                    case 0 -> TeaKettleBlockEntity.this.progress = value;
                    case 1 -> TeaKettleBlockEntity.this.maxProgress = value;
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
        ContainerHelper.saveAllItems(nbt, inventory);
        nbt.putInt("tea_kettle.progress", progress);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        ContainerHelper.loadAllItems(nbt, inventory);
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
    public void tick(Level level, BlockPos pos, BlockState state) {
        BlockState blockState = level.getBlockState(pos.below());

        if (hasRecipe() && (blockState.is(BBTags.BlockTags.HEAT_SOURCES) || getLevel().dimensionType().piglinSafe())) {
            increaseBrewingProgress();
            setChanged(level, pos, state);

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void craftItem() {
        Optional<TeaKettleRecipe> recipe = getCurrentRecipe();

        this.removeItem(CUP_SLOT, 1);
        this.removeItem(INPUT_SLOT_1, 1);
        this.removeItem(INPUT_SLOT_2, 1);
        this.removeItem(INPUT_SLOT_3, 1);
        this.removeItem(INPUT_SLOT_4, 1);

        recipe.ifPresent(teaKettleRecipe -> this.setItem(OUTPUT_SLOT, new ItemStack(teaKettleRecipe.getResultItem(null).getItem(),
                getItem(OUTPUT_SLOT).getCount() + teaKettleRecipe.getResultItem(null).getCount())));
    }
    private void resetProgress() {
        progress = 0;
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<TeaKettleRecipe>> recipe = getCurrentRecipe();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null))
                && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }

    private Optional<RecipeHolder<TeaKettleRecipe>> getCurrentRecipe() {
        SimpleContainer inv = new SimpleContainer(this.getContainerSize());
        for(int i = 0; i < this.getContainerSize(); i++) {
            inv.setItem(i, this.getItem(i));
        }

        return getLevel().getRecipeManager().getRecipeFor(TeaKettleRecipe.Type.INSTANCE, inv, getLevel());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getItem(OUTPUT_SLOT).isEmpty() || this.getItem(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getItem(OUTPUT_SLOT).getCount() + count <= this.getItem(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseBrewingProgress() {
        progress++;
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
        return inventory;
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
