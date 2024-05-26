package net.yirmiri.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.GlowLichenBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yirmiri.BitterBrews;
import net.yirmiri.block.*;
import net.yirmiri.util.BBProperties;

public class BBBlocks {
    //MISC
    public static final Block MUD_STOVE = register("mud_stove", new StoveBlock(BBProperties.BlockP.MUD_STOVE, 1));
    public static final Block MUD_COUNTER = register("mud_counter", new CounterBlock(BBProperties.BlockP.MUD_COUNTER));
    public static final Block COPPER_TEA_KETTLE = register("copper_tea_kettle", new TeaKettleBlock(BBProperties.BlockP.COPPER_TEA_KETTLE));

    //NATURAL
    public static final Block AZALEA_FLOWER = register("azalea_flower", new GlowLichenBlock(BBProperties.BlockP.AZALEA_FLOWER));
    public static final Block PEPPER_CROP = register("pepper_crop", new PepperCropBlock(BBProperties.BlockP.PEPPER_CROP));
    public static final Block SOUL_PEPPER_CROP = register("soul_pepper_crop", new SoulPepperCropBlock(BBProperties.BlockP.SOUL_PEPPER_CROP));
    public static final Block COFFEE_BUSH = register("coffee_bush", new CoffeeBushBlock(BBProperties.BlockP.COFFEE_BUSH));

    private static Block register(String name, Block block) {
        registerItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BitterBrews.MODID, name), block);
    }

    private static Block registerWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(BitterBrews.MODID, name), block);
    }

    private static Item registerItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BitterBrews.MODID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerBBBlocks() {
    }
}
