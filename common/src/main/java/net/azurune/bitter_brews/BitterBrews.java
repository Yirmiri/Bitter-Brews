package net.azurune.bitter_brews;

import net.azurune.bitter_brews.core.platform.Services;
import net.azurune.bitter_brews.core.registry.BBItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class BitterBrews {

    // The loader specific projects are able to import and use any code from the common project. This allows you to
    // write the majority of your code here and load it from your loader specific projects. This example has some
    // code that gets invoked by the entry point of the loader specific projects.
    public static void init() {

        BitterBrewsConstants.LOG.info("Hello from Common init on {}! we are currently in a {} environment!", Services.PLATFORM.getPlatformName(), Services.PLATFORM.getEnvironmentName());
        BitterBrewsConstants.LOG.info("The ID for diamonds is {}", BuiltInRegistries.ITEM.getKey(Items.DIAMOND));

        BBItems.loadItems();


        // the platform specific approach.
        if (Services.PLATFORM.isModLoaded("tipsylib")) {

            BitterBrewsConstants.LOG.info("Bitter Brews Depends off TipsyLib which is a mod that adds many different effects for mod creators to use!");
        }
    }

    public static MutableComponent tooltipId(String key, Object... args) {
        return Component.translatable(BitterBrewsConstants.MOD_ID + "." + key, args);
    }

    public static ResourceLocation id(String name) {
        return new ResourceLocation(BitterBrewsConstants.MOD_ID, name);
    }
}