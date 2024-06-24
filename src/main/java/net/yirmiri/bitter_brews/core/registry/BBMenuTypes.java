package net.yirmiri.bitter_brews.core.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.yirmiri.bitter_brews.BitterBrews;
import net.yirmiri.bitter_brews.common.screen.TeaKettleMenu;

import java.util.function.Supplier;

public class BBMenuTypes {


    public static final Supplier<MenuType<TeaKettleMenu>> TEA_KETTLE_MENU = registerMenu("tea_kettle_menu", () -> new MenuType<>(TeaKettleMenu::new, FeatureFlags.VANILLA_SET));


    private static <T extends AbstractContainerMenu> Supplier registerMenu(String name, Supplier<MenuType<T>> menuType) {
        return BitterBrews.register(BuiltInRegistries.MENU, name, menuType);
    }

    public static void loadMenuTypes() {

    }

}
