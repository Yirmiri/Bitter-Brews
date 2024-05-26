package net.yirmiri.register;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yirmiri.BitterBrews;
import net.yirmiri.item.CupItem;
import net.yirmiri.item.GenericDrinkItem;
import net.yirmiri.util.BBProperties;

public class BBItems {
    //MISC
    public static final Item MUD_CUP = register("mud_cup", new CupItem(BBProperties.ItemP.GENERIC_ITEM));

    //DRINKS
    public static final Item CUP_OF_WATER = register("cup_of_water", new GenericDrinkItem(BBProperties.ItemP.GENERIC_DRINK, 32, false));
    public static final Item CUP_OF_MILK = register("cup_of_milk", new GenericDrinkItem(BBProperties.ItemP.GENERIC_DRINK, 32, false));
    public static final Item CUP_OF_GREEN_TEA = register("cup_of_green_tea", new GenericDrinkItem(BBProperties.ItemP.GREEN_TEA, 32, true));
    public static final Item CUP_OF_AZALEA_TEA = register("cup_of_azalea_tea", new GenericDrinkItem(BBProperties.ItemP.AZALEA_TEA, 32, true));
    public static final Item CUP_OF_HONEY_TEA = register("cup_of_honey_tea", new GenericDrinkItem(BBProperties.ItemP.HONEY_TEA, 48, true));
    public static final Item CUP_OF_KELP_TEA = register("cup_of_kelp_tea", new GenericDrinkItem(BBProperties.ItemP.KELP_TEA, 32, true));
    public static final Item CUP_OF_MANGO_TEA = register("cup_of_mango_tea", new GenericDrinkItem(BBProperties.ItemP.MANGO_TEA, 32, true));
    public static final Item CUP_OF_FUDGE_SUNDAE = register("cup_of_fudge_sundae", new GenericDrinkItem(BBProperties.ItemP.GENERIC_DRINK, 256, true));
    public static final Item CUP_OF_BLACK_TEA = register("cup_of_black_tea", new GenericDrinkItem(BBProperties.ItemP.BLACK_TEA, 32, true));
    public static final Item CUP_OF_CHOCOLATE_MILK = register("cup_of_chocolate_milk", new GenericDrinkItem(BBProperties.ItemP.CHOCOLATE_MILK, 48, true));
    public static final Item CUP_OF_COFFEE = register("cup_of_coffee", new GenericDrinkItem(BBProperties.ItemP.COFFEE, 32, true));
    public static final Item CUP_OF_DARK_COFFEE = register("cup_of_dark_coffee", new GenericDrinkItem(BBProperties.ItemP.DARK_COFFEE, 32, true));
    public static final Item CUP_OF_ESPRESSO = register("cup_of_espresso", new GenericDrinkItem(BBProperties.ItemP.ESPRESSO, 48, true));
    public static final Item CUP_OF_HOT_COCOA = register("cup_of_hot_cocoa", new GenericDrinkItem(BBProperties.ItemP.HOT_COCOA, 48, true));

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BitterBrews.MODID, name), item);
    }

    public static void registerBBItems() {
    }
}
