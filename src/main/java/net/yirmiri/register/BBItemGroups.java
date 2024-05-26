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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Blocks.SMOKER, BBBlocks.MUD_STOVE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.MILK_BUCKET, BBItems.CUP_OF_WATER);
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
            entries.addAfter(Items.GLASS_BOTTLE, BBItems.MUD_CUP);
        });
    }
}
