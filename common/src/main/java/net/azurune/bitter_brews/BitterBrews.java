package net.azurune.bitter_brews;

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
    }

    public static MutableComponent tooltipId(String key, Object... args) {
        return Component.translatable(BitterBrewsConstants.MOD_ID + "." + key, args);
    }

    public static ResourceLocation id(String name) {
        return new ResourceLocation(BitterBrewsConstants.MOD_ID, name);
    }
}