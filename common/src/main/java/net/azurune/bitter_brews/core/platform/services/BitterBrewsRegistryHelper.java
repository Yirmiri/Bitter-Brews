package net.azurune.bitter_brews.core.platform.services;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface BitterBrewsRegistryHelper {

    <T> Supplier<T> register(Registry<? super T> registry, String name, Supplier<T> entry);


    <T extends Block> Supplier<T> registerBlockWithItem(String id, java.util.function.Supplier<T> blockSupplier);

    <T extends Block> Supplier<T> registerBlock(String id, java.util.function.Supplier<T> blockSupplier);


}
