package net.azurune.bitter_brews.core.compat.arts_and_crafts;

import net.azurune.bitter_brews.common.item.GenericDrinkItem;
import net.azurune.bitter_brews.common.util.BBProperties;
import net.azurune.bitter_brews.core.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ACItems {

    //DRINKS
    public static final Supplier<Item> CUP_OF_CHALK = registerItem("cup_of_chalk", () -> new GenericDrinkItem(BBProperties.ItemP.AC_CHALK, 32, true));

    private static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return Services.REGISTRY_HELPER.register(BuiltInRegistries.ITEM, name, itemSupplier);
    }

    public static void loadACItems() {
    }
}
