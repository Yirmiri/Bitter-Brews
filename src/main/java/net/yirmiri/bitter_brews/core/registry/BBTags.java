package net.yirmiri.bitter_brews.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.yirmiri.bitter_brews.BitterBrews;

public class BBTags {
    public static class ItemTags {
        public static final TagKey<Item> BREWS = tag("brews");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, BitterBrews.id(name));
        }
    }

    public static class BlockTags {
        public static final TagKey<Block> HEAT_SOURCES = tag("heat_sources");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, BitterBrews.id(name));
        }
    }
}
