package net.azurune.bitter_brews;

import net.azurune.bitter_brews.util.BBLootModifiers;
import net.fabricmc.api.ModInitializer;
import net.azurune.bitter_brews.registry.*;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitterBrews implements ModInitializer {

    public static final String MOD_ID = "bitter_brews";
    public static final String MOD_NAME = "Bitter Brews";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static MutableText id(String key, Object... args) {
        return Text.translatable(MOD_ID + "." + key, args);
    }

    @Override
    public void onInitialize() {
        RegisterItems.registerItems();
        RegisterBlocks.registerBlocks();
        RegisterBlockEntities.registerBlockEntities();
        BBRecipeSerializer.registerRecipeSerializers();
        RegisterScreenHandlers.registerMenuTypes();
        BBRecipeTypes.registerRecipeTypes();
        RegisterItemGroups.registerCustomTabs();
        BBLootModifiers.modifyLoot();
    }
}