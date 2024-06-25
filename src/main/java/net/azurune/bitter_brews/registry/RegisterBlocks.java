package net.azurune.bitter_brews.registry;

import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.block.*;
import net.azurune.bitter_brews.util.BBProperties;
import net.minecraft.block.Block;
import net.minecraft.block.GlowLichenBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class RegisterBlocks {
    /**
     * holds all the blocks and items as Block and Item and their ID's as Strings
     */
    private static Map<String, Pair<Item, Block>> blockHashMap = new HashMap<>();
    public static Map<String, Pair<Item, Block>> getBlockHashMap = blockHashMap;

    /**
     * Adds block to blockHashMap with id as it's Key, can create an item for it if shouldRegisterItem is true
     * @param id Key in the blockHashMap and the ID of the block & item
     * @param block Block class instance of the specified block
     * @param shouldRegisterItem whether the method should create and register an Item for the block
     * @return block to be stored in a field/variable
     */
    private static Block register(String id, Block block, boolean shouldRegisterItem) {
        Pair<Item, Block> registeredPair = new Pair(null, null);

        if (shouldRegisterItem) registeredPair.setLeft(new BlockItem(block, new Item.Settings()));
        registeredPair.setRight(block);

        blockHashMap.put(id, registeredPair);
        return block;
    }

    //MISC
    public static final Block MUD_STOVE = register("mud_stove", new StoveBlock(BBProperties.BlockP.MUD_STOVE, 1), true);
    public static final Block MUD_COUNTER = register("mud_counter", new CounterBlock(BBProperties.BlockP.MUD_COUNTER), true);
    public static final Block COPPER_KETTLE = register("copper_kettle", new CopperKettleBlock(BBProperties.BlockP.COPPER_KETTLE), true);

    //NATURAL
    public static final Block AZALEA_FLOWER = register("azalea_flower", new GlowLichenBlock(BBProperties.BlockP.AZALEA_FLOWER), true);
    public static final Block COFFEE_BUSH = register("coffee_bush", new CoffeeBushBlock(BBProperties.BlockP.COFFEE_BUSH), true);
    public static final Block PEPPER_CROP = register("pepper_crop", new PepperCropBlock(BBProperties.BlockP.PEPPER_CROP), false);
    public static final Block SOUL_PEPPER_CROP = register("soul_pepper_crop", new SoulPepperCropBlock(BBProperties.BlockP.SOUL_PEPPER_CROP), false);

    /**
     * Registers all the blocks & items that are in the blockHashMap
     */
    public static void registerBlocks() {
        blockHashMap.forEach((id, pair) -> {
            Item item = pair.getLeft();
            Block block = pair.getRight();

            if (item != null) Registry.register(Registries.ITEM, Identifier.of(BitterBrews.MOD_ID, id), item);
            Registry.register(Registries.BLOCK, Identifier.of(BitterBrews.MOD_ID, id), block);
        });
    }
}
