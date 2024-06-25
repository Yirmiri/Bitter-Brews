package net.azurune.bitter_brews.registry;

import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.item.ExtinguishDrinkItem;
import net.azurune.bitter_brews.item.GenericDrinkItem;
import net.azurune.bitter_brews.item.ZeusDrinkItem;
import net.azurune.bitter_brews.util.BBProperties;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class RegisterDrinkItems {
    private static Map<String, Item> drinkHashMap = new HashMap<>();

    public static Map<String, Item> getDrinkHashMap() { return drinkHashMap; }

    /**
     * Adds item to drinkHashMap with name as it's Key
     * @param name Key in the drinkHashMap and the ID of the item
     * @param item Item class instance of the specified item
     * @return item to be stored in a field/variable
     */
    private static Item register(String name, Item item) {
        drinkHashMap.put(name, item);
        return item;
    }

    //DRINKS
    public static final Item CUP_OF_WATER = register("cup_of_water", new GenericDrinkItem(BBProperties.ItemP.WATER, 32, false));
    public static final Item CUP_OF_MILK = register("cup_of_milk", new ExtinguishDrinkItem(BBProperties.ItemP.MILK, 32, false));
    public static final Item CUP_OF_GREEN_TEA = register("cup_of_green_tea", new GenericDrinkItem(BBProperties.ItemP.GREEN_TEA, 32, true));
    public static final Item CUP_OF_AZALEA_TEA = register("cup_of_azalea_tea", new GenericDrinkItem(BBProperties.ItemP.AZALEA_TEA, 32, true));
    public static final Item CUP_OF_HONEY_TEA = register("cup_of_honey_tea", new GenericDrinkItem(BBProperties.ItemP.HONEY_TEA, 48, true));
    public static final Item CUP_OF_KELP_TEA = register("cup_of_kelp_tea", new GenericDrinkItem(BBProperties.ItemP.KELP_TEA, 32, true));
    public static final Item CUP_OF_MANGO_TEA = register("cup_of_mango_tea", new GenericDrinkItem(BBProperties.ItemP.MANGO_TEA, 48, true));
    public static final Item CUP_OF_FUDGE_SUNDAE = register("cup_of_fudge_sundae", new GenericDrinkItem(BBProperties.ItemP.FUDGE_SUNDAE, 256, true));
    public static final Item CUP_OF_BLACK_TEA = register("cup_of_black_tea", new GenericDrinkItem(BBProperties.ItemP.BLACK_TEA, 48, true));
    public static final Item CUP_OF_CHOCOLATE_MILK = register("cup_of_chocolate_milk", new GenericDrinkItem(BBProperties.ItemP.CHOCOLATE_MILK, 48, true));
    public static final Item CUP_OF_COFFEE = register("cup_of_coffee", new GenericDrinkItem(BBProperties.ItemP.COFFEE, 48, true));
    public static final Item CUP_OF_DARK_COFFEE = register("cup_of_dark_coffee", new GenericDrinkItem(BBProperties.ItemP.DARK_COFFEE, 48, true));
    public static final Item CUP_OF_ESPRESSO = register("cup_of_espresso", new GenericDrinkItem(BBProperties.ItemP.ESPRESSO, 48, true));
    public static final Item CUP_OF_HOT_COCOA = register("cup_of_hot_cocoa", new GenericDrinkItem(BBProperties.ItemP.HOT_COCOA, 48, true));
    public static final Item CUP_OF_ICED_TEA = register("cup_of_iced_tea", new GenericDrinkItem(BBProperties.ItemP.ICED_TEA, 48, true));
    public static final Item CUP_OF_JASMINE_TEA = register("cup_of_jasmine_tea", new GenericDrinkItem(BBProperties.ItemP.JASMINE_TEA, 32, true));
    public static final Item CUP_OF_MELON_JUICE = register("cup_of_melon_juice", new GenericDrinkItem(BBProperties.ItemP.MELON_JUICE, 32, true));
    public static final Item CUP_OF_SWEET_BERRY_JUICE = register("cup_of_sweet_berry_juice", new GenericDrinkItem(BBProperties.ItemP.SWEET_BERRY_JUICE, 32, true));
    public static final Item CUP_OF_GLOW_BERRY_JUICE = register("cup_of_glow_berry_juice", new GenericDrinkItem(BBProperties.ItemP.GLOW_BERRY_JUICE, 32, true));
    public static final Item CUP_OF_CRIMSON_TEA = register("cup_of_crimson_tea", new GenericDrinkItem(BBProperties.ItemP.CRIMSON_TEA, 32, true));
    public static final Item CUP_OF_WARPED_TEA = register("cup_of_warped_tea", new GenericDrinkItem(BBProperties.ItemP.WARPED_TEA, 32, true));
    public static final Item CUP_OF_SHROOMLIGHT_TEA = register("cup_of_shroomlight_tea", new GenericDrinkItem(BBProperties.ItemP.SHROOMLIGHT_TEA, 32, true));
    public static final Item CUP_OF_CHORUS_JUICE = register("cup_of_chorus_juice", new GenericDrinkItem(BBProperties.ItemP.CHORUS_JUICE, 64, true));
    public static final Item CUP_OF_LIGHTNING = register("cup_of_lightning", new ZeusDrinkItem(BBProperties.ItemP.ZEUS, 1, true));

    public static void registerDrinks() {
        drinkHashMap.forEach((id, item) -> {
            Registry.register(Registries.ITEM, Identifier.of(BitterBrews.MOD_ID, id), item);
        });
    }
}
