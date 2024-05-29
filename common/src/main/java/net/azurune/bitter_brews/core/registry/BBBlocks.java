package net.azurune.bitter_brews.core.registry;

import net.azurune.bitter_brews.common.block.CoffeeBushBlock;
import net.azurune.bitter_brews.common.util.BBProperties;
import net.azurune.bitter_brews.core.platform.Services;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class BBBlocks {

    //NATURAL
    public static final Supplier<Block> COFFEE_BUSH = registerBlock("coffee_bush", () -> new CoffeeBushBlock(BBProperties.BlockP.COFFEE_BUSH));

    private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return Services.REGISTRY_HELPER.registerBlock(name, blockSupplier);
    }

    private static <T extends Block> Supplier<T> registerBlockWithItem(String name, java.util.function.Supplier<T> blockSupplier) {
        return Services.REGISTRY_HELPER.registerBlockWithItem(name, blockSupplier);
    }

    public static void loadBlocks() {

    }
}
