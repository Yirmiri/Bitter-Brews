package net.azurune.bitter_brews.common.block_entity;


import net.azurune.bitter_brews.common.screen.TeaKettleMenu;
import net.azurune.bitter_brews.core.registry.BBBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class TeaKettleBlockEntity extends BlockEntity implements MenuProvider {

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
        return Component.translatable("gui.bitter_brews.copper_tea_kettle");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new TeaKettleMenu(i, inventory);
    }
}
