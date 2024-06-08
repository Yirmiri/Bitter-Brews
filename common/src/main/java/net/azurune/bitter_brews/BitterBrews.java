package net.azurune.bitter_brews;

import net.azurune.bitter_brews.core.platform.Services;
import net.azurune.bitter_brews.core.registry.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

public class BitterBrews {

    public static void init() {
        BBItems.loadItems();
        BBBlocks.loadBlocks();
        BBBlockEntityTypes.loadBlockEntityTypes();
        BBRecipeSerializer.loadRecipeSerializers();
        BBMenuTypes.loadMenuTypes();
        BBRecipeTypes.loadRecipeTypes();
        BBStatusEffects.loadEffects();

        if (Services.PLATFORM.isModLoaded("tipsylib")) {
            BitterBrewsConstants.LOGGER.info("Bitter Brews depends off TipsyLib which is a mod that adds many different effects for mod creators to use!");
        }
    }

    public static MutableComponent tooltipId(String key, Object... args) {
        return Component.translatable(BitterBrewsConstants.MOD_ID + "." + key, args);
    }

    public static ResourceLocation id(String name) {
        return new ResourceLocation(BitterBrewsConstants.MOD_ID, name);
    }
}