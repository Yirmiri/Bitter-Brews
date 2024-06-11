package net.azurune.bitter_brews.platform;

import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.BitterBrewsConstants;
import net.azurune.bitter_brews.core.platform.services.BitterBrewsRegistryHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class FabricBitterBrewsRegistryHelper implements BitterBrewsRegistryHelper {

    @Override
    public <T> Supplier<T> register(Registry<? super T> registry, String name, Supplier<T> entry) {
        T value = entry.get();
        Registry.register(registry, BitterBrews.id(name), value);
        return () -> value;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlockWithItem(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(BitterBrewsConstants.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(BitterBrewsConstants.MOD_ID, id), new BlockItem(block, new Item.Properties()));
        return () -> block;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(BitterBrewsConstants.MOD_ID, id), blockSupplier.get());
        return () -> block;
    }

}
