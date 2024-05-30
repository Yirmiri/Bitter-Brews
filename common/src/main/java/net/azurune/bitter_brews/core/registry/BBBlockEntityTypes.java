package net.azurune.bitter_brews.core.registry;

import net.azurune.bitter_brews.common.block_entity.TeaKettleBlockEntity;
import net.azurune.bitter_brews.core.platform.Services;
import net.azurune.bitter_brews.core.platform.services.IPlatformHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class BBBlockEntityTypes {

    public static final Supplier<BlockEntityType<TeaKettleBlockEntity>> TEA_KETTLE_BLOCK_ENTITY = registerBlockEntityType("tea_kettle_block_entity", () ->
            createBlockEntity(TeaKettleBlockEntity::new,
                    BBBlocks.COPPER_TEA_KETTLE.get()
            )
    );


    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(String name, Supplier<BlockEntityType<T>> type) {
        return Services.REGISTRY_HELPER.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, name, type);
    }
    private static <T extends BlockEntity> BlockEntityType<T> createBlockEntity(IPlatformHelper.BlockEntitySupplier<T> blockEntitySupplier, Block block) {
        return Services.PLATFORM.createBlockEntity(blockEntitySupplier, block);
    }

    public static void loadBlockEntityTypes() {

    }
}
