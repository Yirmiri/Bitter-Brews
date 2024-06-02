package net.azurune.bitter_brews;

import net.azurune.bitter_brews.core.registry.BBFeatures;
import net.azurune.bitter_brews.registry.FabricBBItemGroups;
import net.azurune.bitter_brews.util.BBLootModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;

public class FabricBitterBrews implements ModInitializer {
    
    @Override
    public void onInitialize() {
        BitterBrews.init();
        BBLootModifiers.modifyLoot();
        FabricBBItemGroups.buildCreativeTabs();
        createBiomeModifications();
    }

    public void createBiomeModifications() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_JUNGLE), GenerationStep.Decoration.VEGETAL_DECORATION, BBFeatures.PlacedFeatures.COFFEE_BUSH_PLACED);
    }
}
