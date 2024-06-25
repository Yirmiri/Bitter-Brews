package net.azurune.bitter_brews.registry;

import net.azurune.bitter_brews.BitterBrews;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

public class RegisterFeatures {

    public static class ConfiguredFeatures {
        public static final RegistryKey<ConfiguredFeature<?, ?>> COFFEE_BUSH = createKey("coffee_bush");

        public static RegistryKey<ConfiguredFeature<?, ?>> createKey(String name) {
            return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(BitterBrews.MOD_ID, name));
        }
    }

    public static class PlacedFeatures {
        public static final RegistryKey<PlacedFeature> COFFEE_BUSH_PLACED = createKey("coffee_bush_placed");

        public static RegistryKey<PlacedFeature> createKey(String name) {
            return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(BitterBrews.MOD_ID, name));
        }
    }
}
