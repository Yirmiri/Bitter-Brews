package net.azurune.bitter_brews.core.registry;

import net.azurune.bitter_brews.common.screen.CopperKettleMenu;
import net.azurune.bitter_brews.core.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class BBMenuTypes {


    public static final Supplier<MenuType<CopperKettleMenu>> TEA_KETTLE_MENU = registerMenu("tea_kettle_menu", () -> new MenuType<>(CopperKettleMenu::new, FeatureFlags.VANILLA_SET));


    private static <T extends AbstractContainerMenu> Supplier registerMenu(String name, Supplier<MenuType<T>> menuType) {
        return Services.REGISTRY_HELPER.register(BuiltInRegistries.MENU, name, menuType);
    }

    public static void loadMenuTypes() {

    }

}
