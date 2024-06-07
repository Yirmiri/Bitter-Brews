package net.azurune.bitter_brews.registry;

import net.azurune.bitter_brews.core.registry.BBBlocks;
import net.azurune.bitter_brews.core.registry.BBItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class FabricBBItemGroups {

    public static void buildCreativeTabs() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.addAfter(Items.NETHER_WART, BBItems.PEPPER_SEEDS.get());
            entries.addAfter(BBItems.PEPPER_SEEDS.get(), BBItems.SOUL_PEPPER_SEEDS.get());
            entries.addAfter(Items.FLOWERING_AZALEA, BBBlocks.AZALEA_FLOWER.get());
            entries.addAfter(Items.SWEET_BERRIES, BBBlocks.COFFEE_BUSH.get());
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.SMOKER, BBBlocks.MUD_STOVE.get());
            entries.addAfter(BBBlocks.MUD_STOVE.get(), BBBlocks.MUD_COUNTER.get());
            entries.addAfter(BBBlocks.MUD_COUNTER.get(), BBBlocks.COPPER_TEA_KETTLE.get());
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> {
            entries.addAfter(Items.ENCHANTED_GOLDEN_APPLE, BBItems.MANGO.get());
            entries.addAfter(Items.BEETROOT, BBItems.PEPPER.get());
            entries.addAfter(BBItems.PEPPER.get(), BBItems.SOUL_PEPPER.get());
            entries.addAfter(Items.DRIED_KELP, BBItems.DRIED_TEA_LEAVES.get());
            entries.addAfter(Items.SPIDER_EYE, BBItems.CUP_OF_WATER.get());
            entries.addAfter(BBItems.CUP_OF_WATER.get(), BBItems.CUP_OF_MILK.get());
            entries.addAfter(BBItems.CUP_OF_MILK.get(), BBItems.CUP_OF_CHOCOLATE_MILK.get());
            entries.addAfter(BBItems.CUP_OF_CHOCOLATE_MILK.get(), BBItems.CUP_OF_MELON_JUICE.get());
            entries.addAfter(BBItems.CUP_OF_MELON_JUICE.get(), BBItems.CUP_OF_SWEET_BERRY_JUICE.get());
            entries.addAfter(BBItems.CUP_OF_SWEET_BERRY_JUICE.get(), BBItems.CUP_OF_GLOW_BERRY_JUICE.get());
            entries.addAfter(BBItems.CUP_OF_GLOW_BERRY_JUICE.get(), BBItems.CUP_OF_CHORUS_JUICE.get());
            entries.addAfter(BBItems.CUP_OF_CHORUS_JUICE.get(), BBItems.CUP_OF_GREEN_TEA.get());
            entries.addAfter(BBItems.CUP_OF_GREEN_TEA.get(), BBItems.CUP_OF_AZALEA_TEA.get());
            entries.addAfter(BBItems.CUP_OF_AZALEA_TEA.get(), BBItems.CUP_OF_BLACK_TEA.get());
            entries.addAfter(BBItems.CUP_OF_BLACK_TEA.get(), BBItems.CUP_OF_ICED_TEA.get());
            entries.addAfter(BBItems.CUP_OF_ICED_TEA.get(), BBItems.CUP_OF_HONEY_TEA.get());
            entries.addAfter(BBItems.CUP_OF_HONEY_TEA.get(), BBItems.CUP_OF_MANGO_TEA.get());
            entries.addAfter(BBItems.CUP_OF_MANGO_TEA.get(), BBItems.CUP_OF_KELP_TEA.get());
            entries.addAfter(BBItems.CUP_OF_KELP_TEA.get(), BBItems.CUP_OF_JASMINE_TEA.get());
            entries.addAfter(BBItems.CUP_OF_JASMINE_TEA.get(), BBItems.CUP_OF_CRIMSON_TEA.get());
            entries.addAfter(BBItems.CUP_OF_CRIMSON_TEA.get(), BBItems.CUP_OF_WARPED_TEA.get());
            entries.addAfter(BBItems.CUP_OF_WARPED_TEA.get(), BBItems.CUP_OF_SHROOMLIGHT_TEA.get());
            entries.addAfter(BBItems.CUP_OF_SHROOMLIGHT_TEA.get(), BBItems.CUP_OF_COFFEE.get());
            entries.addAfter(BBItems.CUP_OF_COFFEE.get(), BBItems.CUP_OF_DARK_COFFEE.get());
            entries.addAfter(BBItems.CUP_OF_DARK_COFFEE.get(), BBItems.CUP_OF_ESPRESSO.get());
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.KELP, BBItems.TEA_LEAVES.get());
            entries.addAfter(BBItems.TEA_LEAVES.get(), BBBlocks.AZALEA_FLOWER.get());
            entries.addAfter(Items.COCOA_BEANS, BBItems.COFFEE_BEANS.get());
            entries.addAfter(Items.GLASS_BOTTLE, BBItems.MUD_CUP.get());
        });
    }
}
