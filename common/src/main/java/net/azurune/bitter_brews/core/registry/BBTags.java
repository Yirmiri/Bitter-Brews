package net.azurune.bitter_brews.core.registry;

import net.azurune.bitter_brews.BitterBrewsConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BBTags {
    public static class ItemTags {
        public static final TagKey<Item> BREWS
                = tag("brews");


        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(BitterBrewsConstants.MOD_ID, name));
        }
    }
    public static class BlockTags {
        public static final TagKey<Block> HEAT_SOURCES
                = tag("heat_sources");


        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(BitterBrewsConstants.MOD_ID, name));
        }
    }
}
