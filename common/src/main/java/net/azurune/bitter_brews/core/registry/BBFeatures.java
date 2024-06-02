package net.azurune.bitter_brews.core.registry;

import net.azurune.bitter_brews.BitterBrews;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class BBFeatures {

    public static class ConfiguredFeatures {

        public static final ResourceKey<ConfiguredFeature<?, ?>> COFFEE_BUSH = createKey("coffee_bush");

        public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, BitterBrews.id(name));
        }
    }

    public static class PlacedFeatures {

        public static final ResourceKey<PlacedFeature> COFFEE_BUSH_PLACED = createKey("coffee_bush_placed");

        public static ResourceKey<PlacedFeature> createKey(String name) {
            return ResourceKey.create(Registries.PLACED_FEATURE, BitterBrews.id(name));
        }
    }
}
