package net.azurune.bitter_brews.core.registry;

import net.azurune.bitter_brews.common.screen.TeaKettleMenu;
import net.azurune.bitter_brews.core.platform.Services;
import net.minecraft.world.inventory.AbstractContainerMenu;

import java.util.function.Supplier;

public class BBMenuTypes {


    public static final Supplier<TeaKettleMenu> TEA_KETTLE_MENU = registerMenu("tea_kettle_menu", TeaKettleMenu::new);



    private static <T extends AbstractContainerMenu> Supplier registerMenu(String name, Supplier<T> menuType) {
        return Services.REGISTRY_HELPER.registerMenu(name, menuType);
    }

}
