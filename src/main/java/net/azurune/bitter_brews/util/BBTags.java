package net.azurune.bitter_brews.util;

import com.jcraft.jorbis.Block;
import net.azurune.bitter_brews.BitterBrews;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class BBTags {
    public static class ItemTags {
        public static final TagKey<Item> BREWS = create("brews");

        private static TagKey<Item> create(String id) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(BitterBrews.MOD_ID, id));
        }
    }

    public static class BlockTags {
        public static final TagKey<Block> HEAT_SOURCES = create("heat_sources");

        private static TagKey<Block> create(String id) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(BitterBrews.MOD_ID, id));
        }
    }
}