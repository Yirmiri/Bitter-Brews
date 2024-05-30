package net.azurune.bitter_brews;

import net.azurune.bitter_brews.registry.FabricBBItemGroups;
import net.azurune.bitter_brews.util.BBLootModifiers;
import net.fabricmc.api.ModInitializer;

public class FabricBitterBrews implements ModInitializer {
    
    @Override
    public void onInitialize() {
        BitterBrews.init();
        BBLootModifiers.modifyLoot();
        FabricBBItemGroups.buildCreativeTabs();
    }
}
