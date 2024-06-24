package net.yirmiri.bitter_brews;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.yirmiri.bitter_brews.common.util.BBItemGroups;
import net.yirmiri.bitter_brews.core.registry.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BitterBrews {

    public static void init() {
        BBItems.loadItems();
        BBBlocks.loadBlocks();
        BBBlockEntityTypes.loadBlockEntityTypes();
        BBRecipeSerializer.loadRecipeSerializers();
        BBMenuTypes.loadMenuTypes();
        BBRecipeTypes.loadRecipeTypes();
        BBItemGroups.buildCreativeTabs();
    }

    public static MutableComponent tooltipId(String key, Object... args) {
        return Component.translatable(BitterBrewsConstants.MOD_ID + "." + key, args);
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(BitterBrewsConstants.MOD_ID, name);
    }


    public static <T> Supplier<T> register(Registry<? super T> registry, String name, Supplier<T> entry) {
        T value = entry.get();
        Registry.register(registry, BitterBrews.id(name), value);
        return () -> value;
    }



    public static <T extends Block> Supplier<T> registerBlockWithItem(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, id(id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, id(id), new BlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, id(id), blockSupplier.get());
        return () -> block;
    }

    @FunctionalInterface
    public interface BlockEntitySupplier<T extends BlockEntity> {
        @NotNull
        T create(BlockPos pos, BlockState state);
    }

    public static <T extends BlockEntity> BlockEntityType<T> createBlockEntity(BitterBrews.BlockEntitySupplier<T> blockEntitySupplier, Block... blocks) {
        return FabricBlockEntityTypeBuilder.create(blockEntitySupplier::create, blocks).build();
    }
}