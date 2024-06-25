package net.azurune.bitter_brews.registry;

import net.azurune.bitter_brews.item.SoulPepperItem;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.item.CupItem;
import net.azurune.bitter_brews.util.BBProperties;

import java.util.HashMap;
import java.util.Map;

public class RegisterItems {
    /**
     * holds all the items as Item and their ID's as Strings
     */
    private static Map<String, Item> itemHashMap = new HashMap<>();

    public static Map<String, Item> getItemHashMap = itemHashMap;

    /**
     * Adds item to itemHashMap with name as it's Key
     * @param name Key in the itemHashMap and the ID of the item
     * @param item Item class instance of the specified item
     * @return item to be stored in a field/variable
     */
    private static Item register(String name, Item item) {
        itemHashMap.put(name, item);
        return item;
    }

    //MISC
    public static final Item MUD_CUP = register("mud_cup", new CupItem(BBProperties.ItemP.GENERIC_ITEM));
    public static final Item PEPPER = register("pepper", new Item(BBProperties.ItemP.PEPPER));
    public static final Item SOUL_PEPPER = register("soul_pepper", new SoulPepperItem(BBProperties.ItemP.SOUL_PEPPER));
    public static final Item COFFEE_BEANS = register("coffee_beans", new Item(BBProperties.ItemP.GENERIC_ITEM));
    public static final Item TEA_LEAVES = register("tea_leaves", new Item(BBProperties.ItemP.GENERIC_ITEM));
    public static final Item DRIED_TEA_LEAVES = register("dried_tea_leaves", new Item(BBProperties.ItemP.DRIED_TEA_LEAVES));
    public static final Item MANGO = register("mango", new Item(BBProperties.ItemP.MANGO));
    public static final Item PEPPER_SEEDS = register("pepper_seeds", new AliasedBlockItem(RegisterBlocks.PEPPER_CROP, new Item.Settings()));
    public static final Item SOUL_PEPPER_SEEDS = register("soul_pepper_seeds", new AliasedBlockItem(RegisterBlocks.SOUL_PEPPER_CROP, new Item.Settings()));

    /**
     * Registers all the items that are in the itemHashMap
     */
    public static void registerItems() {
        itemHashMap.forEach((id, item) -> {
            Registry.register(Registries.ITEM, Identifier.of(BitterBrews.MOD_ID, id), item);
        });
        RegisterDrinkItems.registerDrinks();
    }
}
