package net.yirmiri.register;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yirmiri.BitterBrews;

public class BBItemGroups {
    public static ItemGroup BITTER_BREWS = Registry.register(Registries.ITEM_GROUP, new Identifier(BitterBrews.MODID, "bitter_brews"),
            FabricItemGroup.builder().icon(() -> new ItemStack(BBBlocks.MUD_STOVE)).displayName(Text.translatable("itemgroup.bitter_brews")).entries((displayContext, entries) -> {
                entries.add(BBBlocks.MUD_STOVE);
                entries.add(BBBlocks.MUD_COUNTER);

                entries.add(BBItems.TEA_LEAVES);
                entries.add(BBItems.DRIED_TEA_LEAVES);
                entries.add(BBBlocks.AZALEA_FLOWER);
                entries.add(BBItems.COFFEE_BEANS);

                entries.add(BBItems.MANGO);
                entries.add(BBItems.PEPPER);
                entries.add(BBItems.SOUL_PEPPER);
                entries.add(BBItems.PEPPER_SEEDS);
                entries.add(BBItems.SOUL_PEPPER_SEEDS);

                entries.add(BBItems.MUD_CUP);
                entries.add(BBItems.CUP_OF_WATER);
                entries.add(BBItems.CUP_OF_GREEN_TEA);
                entries.add(BBItems.CUP_OF_AZALEA_TEA);
                entries.add(BBItems.CUP_OF_BLACK_TEA);
                entries.add(BBItems.CUP_OF_ICED_TEA);
                entries.add(BBItems.CUP_OF_HONEY_TEA);
                entries.add(BBItems.CUP_OF_MANGO_TEA);
                entries.add(BBItems.CUP_OF_KELP_TEA);
                entries.add(BBItems.CUP_OF_JASMINE_TEA);
                entries.add(BBItems.CUP_OF_COFFEE);
                entries.add(BBItems.CUP_OF_DARK_COFFEE);
                entries.add(BBItems.CUP_OF_ESPRESSO);
                entries.add(BBItems.CUP_OF_MILK);
                entries.add(BBItems.CUP_OF_CHOCOLATE_MILK);
                entries.add(BBItems.CUP_OF_HOT_COCOA);
            }).build());

    public static void registerAddToVanilla() {
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addBefore(Items.NETHER_WART, BBItems.PEPPER_SEEDS);
        entries.addAfter(BBItems.PEPPER_SEEDS, BBItems.SOUL_PEPPER_SEEDS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Blocks.SMOKER, BBBlocks.MUD_STOVE);
            entries.addAfter(BBBlocks.MUD_STOVE, BBBlocks.MUD_COUNTER);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.ENCHANTED_GOLDEN_APPLE, BBItems.MANGO);
            entries.addAfter(Items.BEETROOT, BBItems.PEPPER);
            entries.addAfter(BBItems.PEPPER, BBItems.SOUL_PEPPER);
            entries.addBefore(Items.DRIED_KELP, BBItems.DRIED_TEA_LEAVES);
            entries.addAfter(Items.SPIDER_EYE, BBItems.CUP_OF_WATER);
            entries.addAfter(BBItems.CUP_OF_WATER, BBItems.CUP_OF_GREEN_TEA);
            entries.addAfter(BBItems.CUP_OF_GREEN_TEA, BBItems.CUP_OF_AZALEA_TEA);
            entries.addAfter(BBItems.CUP_OF_AZALEA_TEA, BBItems.CUP_OF_BLACK_TEA);
            entries.addAfter(BBItems.CUP_OF_BLACK_TEA, BBItems.CUP_OF_ICED_TEA);
            entries.addAfter(BBItems.CUP_OF_ICED_TEA, BBItems.CUP_OF_HONEY_TEA);
            entries.addAfter(BBItems.CUP_OF_HONEY_TEA, BBItems.CUP_OF_MANGO_TEA);
            entries.addAfter(BBItems.CUP_OF_MANGO_TEA, BBItems.CUP_OF_KELP_TEA);
            entries.addAfter(BBItems.CUP_OF_KELP_TEA, BBItems.CUP_OF_JASMINE_TEA);
            entries.addAfter(BBItems.CUP_OF_JASMINE_TEA, BBItems.CUP_OF_COFFEE);
            entries.addAfter(BBItems.CUP_OF_COFFEE, BBItems.CUP_OF_DARK_COFFEE);
            entries.addAfter(BBItems.CUP_OF_DARK_COFFEE, BBItems.CUP_OF_ESPRESSO);
            entries.addAfter(BBItems.CUP_OF_ESPRESSO, BBItems.CUP_OF_MILK);
            entries.addAfter(BBItems.CUP_OF_MILK, BBItems.CUP_OF_CHOCOLATE_MILK);
            entries.addAfter(BBItems.CUP_OF_CHOCOLATE_MILK, BBItems.CUP_OF_HOT_COCOA);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.WHEAT, BBItems.TEA_LEAVES);
            entries.addAfter(BBItems.TEA_LEAVES, BBBlocks.AZALEA_FLOWER);
            entries.addAfter(Items.COCOA_BEANS, BBItems.COFFEE_BEANS);
            entries.addAfter(Items.GLASS_BOTTLE, BBItems.MUD_CUP);
        });
    }
}
