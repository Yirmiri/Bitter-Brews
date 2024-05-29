package net.azurune.bitter_brews.core.registry;

import net.azurune.bitter_brews.common.item.CupItem;
import net.azurune.bitter_brews.common.item.ExtinguishDrinkItem;
import net.azurune.bitter_brews.common.item.GenericDrinkItem;
import net.azurune.bitter_brews.common.item.SoulPepperItem;
import net.azurune.bitter_brews.common.util.BBProperties;
import net.azurune.bitter_brews.core.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

import java.util.function.Supplier;

public class BBItems {

    //MISC
    public static final Supplier<Item> MUD_CUP = registerItem("mud_cup", () -> new CupItem(BBProperties.ItemP.GENERIC_ITEM));
    public static final Supplier<Item> PEPPER = registerItem("pepper", () -> new Item(BBProperties.ItemP.PEPPER));
    public static final Supplier<Item> SOUL_PEPPER = registerItem("soul_pepper", () -> new SoulPepperItem(BBProperties.ItemP.SOUL_PEPPER));
    public static final Supplier<Item> COFFEE_BEANS = registerItem("coffee_beans", () -> new Item(BBProperties.ItemP.GENERIC_ITEM));
    public static final Supplier<Item> TEA_LEAVES = registerItem("tea_leaves", () -> new Item(BBProperties.ItemP.GENERIC_ITEM));
    public static final Supplier<Item> DRIED_TEA_LEAVES = registerItem("dried_tea_leaves", () -> new Item(BBProperties.ItemP.DRIED_TEA_LEAVES));
    public static final Supplier<Item> MANGO = registerItem("mango", () -> new Item(BBProperties.ItemP.MANGO));
    public static final Supplier<Item> PEPPER_SEEDS = registerItem("pepper_seeds", () -> new ItemNameBlockItem(BBBlocks.PEPPER_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> SOUL_PEPPER_SEEDS = registerItem("soul_pepper_seeds", () -> new ItemNameBlockItem(BBBlocks.SOUL_PEPPER_CROP.get(), new Item.Properties()));

    //DRINKS
    public static final Supplier<Item> CUP_OF_WATER = registerItem("cup_of_water", () -> new GenericDrinkItem(BBProperties.ItemP.GENERIC_ITEM, 32, false));
    public static final Supplier<Item> CUP_OF_MILK = registerItem("cup_of_milk", () -> new ExtinguishDrinkItem(BBProperties.ItemP.MILK, 48, false));
    public static final Supplier<Item> CUP_OF_GREEN_TEA = registerItem("cup_of_green_tea", () -> new GenericDrinkItem(BBProperties.ItemP.GREEN_TEA, 32, true));
    public static final Supplier<Item> CUP_OF_AZALEA_TEA = registerItem("cup_of_azalea_tea", () -> new GenericDrinkItem(BBProperties.ItemP.AZALEA_TEA, 32, true));
    public static final Supplier<Item> CUP_OF_HONEY_TEA = registerItem("cup_of_honey_tea", () -> new GenericDrinkItem(BBProperties.ItemP.HONEY_TEA, 48, true));
    public static final Supplier<Item> CUP_OF_KELP_TEA = registerItem("cup_of_kelp_tea", () -> new GenericDrinkItem(BBProperties.ItemP.KELP_TEA, 32, true));
    public static final Supplier<Item> CUP_OF_MANGO_TEA = registerItem("cup_of_mango_tea", () -> new GenericDrinkItem(BBProperties.ItemP.MANGO_TEA, 32, true));
    public static final Supplier<Item> CUP_OF_FUDGE_SUNDAE = registerItem("cup_of_fudge_sundae", () -> new GenericDrinkItem(BBProperties.ItemP.MILK, 256, true));
    public static final Supplier<Item> CUP_OF_BLACK_TEA = registerItem("cup_of_black_tea", () -> new GenericDrinkItem(BBProperties.ItemP.BLACK_TEA, 32, true));
    public static final Supplier<Item> CUP_OF_CHOCOLATE_MILK = registerItem("cup_of_chocolate_milk", () -> new GenericDrinkItem(BBProperties.ItemP.CHOCOLATE_MILK, 48, true));
    public static final Supplier<Item> CUP_OF_COFFEE = registerItem("cup_of_coffee", () -> new GenericDrinkItem(BBProperties.ItemP.COFFEE, 32, true));
    public static final Supplier<Item> CUP_OF_DARK_COFFEE = registerItem("cup_of_dark_coffee", () -> new GenericDrinkItem(BBProperties.ItemP.DARK_COFFEE, 32, true));
    public static final Supplier<Item> CUP_OF_ESPRESSO = registerItem("cup_of_espresso", () -> new GenericDrinkItem(BBProperties.ItemP.ESPRESSO, 48, true));
    public static final Supplier<Item> CUP_OF_HOT_COCOA = registerItem("cup_of_hot_cocoa", () -> new GenericDrinkItem(BBProperties.ItemP.HOT_COCOA, 48, true));
    public static final Supplier<Item> CUP_OF_ICED_TEA = registerItem("cup_of_iced_tea", () -> new GenericDrinkItem(BBProperties.ItemP.ICED_TEA, 64, true));
    public static final Supplier<Item> CUP_OF_JASMINE_TEA = registerItem("cup_of_jasmine_tea", () -> new GenericDrinkItem(BBProperties.ItemP.JASMINE_TEA, 32, true));


    private static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return Services.REGISTRY_HELPER.register(BuiltInRegistries.ITEM, name, itemSupplier);
    }

    public static void loadItems() {

    }
}
