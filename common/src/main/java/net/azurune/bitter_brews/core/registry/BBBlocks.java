package net.azurune.bitter_brews.core.registry;

import net.azurune.bitter_brews.common.block.*;
import net.azurune.bitter_brews.common.util.BBProperties;
import net.azurune.bitter_brews.core.platform.Services;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlowLichenBlock;

import java.util.function.Supplier;

public class BBBlocks {

    //MISC
    public static final Supplier<Block> MUD_STOVE = registerBlockWithItem("mud_stove", () -> new StoveBlock(BBProperties.BlockP.MUD_STOVE, 1));
    public static final Supplier<Block> MUD_COUNTER = registerBlockWithItem("mud_counter", () -> new CounterBlock(BBProperties.BlockP.MUD_COUNTER));
    //public static final Block COPPER_TEA_KETTLE = registerBlockWithItem("copper_tea_kettle", () -> new TeaKettleBlock(BBProperties.BlockP.COPPER_TEA_KETTLE));

    //NATURAL
    public static final Supplier<Block> AZALEA_FLOWER = registerBlockWithItem("azalea_flower", () -> new GlowLichenBlock(BBProperties.BlockP.AZALEA_FLOWER));
    public static final Supplier<Block> PEPPER_CROP = registerBlock("pepper_crop", () -> new PepperCropBlock(BBProperties.BlockP.PEPPER_CROP));
    public static final Supplier<Block> SOUL_PEPPER_CROP = registerBlock("soul_pepper_crop", () -> new SoulPepperCropBlock(BBProperties.BlockP.SOUL_PEPPER_CROP));
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
