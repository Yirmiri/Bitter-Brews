package net.yirmiri.register;

import net.minecraft.block.Blocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yirmiri.BitterBrews;
import net.yirmiri.item.CupItem;
import net.yirmiri.item.ExtinguishDrinkItem;
import net.yirmiri.item.GenericDrinkItem;
import net.yirmiri.item.SoulPepperItem;
import net.yirmiri.util.BBProperties;

public class BBItems {
    //MISC
    public static final Item MUD_CUP = register("mud_cup", new CupItem(BBProperties.ItemP.GENERIC_ITEM));
    public static final Item PEPPER = register("pepper", new Item(BBProperties.ItemP.PEPPER));
    public static final Item SOUL_PEPPER = register("soul_pepper", new SoulPepperItem(BBProperties.ItemP.SOUL_PEPPER));
    public static final Item COFFEE_BEANS = register("coffee_beans", new Item(BBProperties.ItemP.GENERIC_ITEM));
    public static final Item TEA_LEAVES = register("tea_leaves", new Item(BBProperties.ItemP.GENERIC_ITEM));
    public static final Item DRIED_TEA_LEAVES = register("dried_tea_leaves", new Item(BBProperties.ItemP.DRIED_TEA_LEAVES));
    public static final Item MANGO = register("mango", new Item(BBProperties.ItemP.MANGO));
    public static final Item PEPPER_SEEDS = register("pepper_seeds", new AliasedBlockItem(BBBlocks.PEPPER_CROP, new Item.Settings()));
    public static final Item SOUL_PEPPER_SEEDS = register("soul_pepper_seeds", new AliasedBlockItem(BBBlocks.SOUL_PEPPER_CROP, new Item.Settings()));

    //DRINKS
    public static final Item CUP_OF_WATER = register("cup_of_water", new GenericDrinkItem(BBProperties.ItemP.GENERIC_ITEM, 32, false));
    public static final Item CUP_OF_MILK = register("cup_of_milk", new ExtinguishDrinkItem(BBProperties.ItemP.MILK, 48, false));
    public static final Item CUP_OF_GREEN_TEA = register("cup_of_green_tea", new GenericDrinkItem(BBProperties.ItemP.GREEN_TEA, 32, true));
    public static final Item CUP_OF_AZALEA_TEA = register("cup_of_azalea_tea", new GenericDrinkItem(BBProperties.ItemP.AZALEA_TEA, 32, true));
    public static final Item CUP_OF_HONEY_TEA = register("cup_of_honey_tea", new GenericDrinkItem(BBProperties.ItemP.HONEY_TEA, 48, true));
    public static final Item CUP_OF_KELP_TEA = register("cup_of_kelp_tea", new GenericDrinkItem(BBProperties.ItemP.KELP_TEA, 32, true));
    public static final Item CUP_OF_MANGO_TEA = register("cup_of_mango_tea", new GenericDrinkItem(BBProperties.ItemP.MANGO_TEA, 32, true));
    public static final Item CUP_OF_FUDGE_SUNDAE = register("cup_of_fudge_sundae", new GenericDrinkItem(BBProperties.ItemP.MILK, 256, true));
    public static final Item CUP_OF_BLACK_TEA = register("cup_of_black_tea", new GenericDrinkItem(BBProperties.ItemP.BLACK_TEA, 32, true));
    public static final Item CUP_OF_CHOCOLATE_MILK = register("cup_of_chocolate_milk", new GenericDrinkItem(BBProperties.ItemP.CHOCOLATE_MILK, 48, true));
    public static final Item CUP_OF_COFFEE = register("cup_of_coffee", new GenericDrinkItem(BBProperties.ItemP.COFFEE, 32, true));
    public static final Item CUP_OF_DARK_COFFEE = register("cup_of_dark_coffee", new GenericDrinkItem(BBProperties.ItemP.DARK_COFFEE, 32, true));
    public static final Item CUP_OF_ESPRESSO = register("cup_of_espresso", new GenericDrinkItem(BBProperties.ItemP.ESPRESSO, 48, true));
    public static final Item CUP_OF_HOT_COCOA = register("cup_of_hot_cocoa", new GenericDrinkItem(BBProperties.ItemP.HOT_COCOA, 48, true));
    public static final Item CUP_OF_ICED_TEA = register("cup_of_iced_tea", new GenericDrinkItem(BBProperties.ItemP.ICED_TEA, 64, true));
    public static final Item CUP_OF_JASMINE_TEA = register("cup_of_jasmine_tea", new GenericDrinkItem(BBProperties.ItemP.JASMINE_TEA, 32, true));

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BitterBrews.MODID, name), item);
    }

    public static void registerBBItems() {
    }
}
