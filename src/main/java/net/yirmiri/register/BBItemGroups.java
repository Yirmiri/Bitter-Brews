package net.yirmiri.register;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yirmiri.BitterBrews;

public class BBItemGroups {
    public static ItemGroup BITTER_BREWS = Registry.register(Registries.ITEM_GROUP, new Identifier(BitterBrews.MODID, "bitter_brews"),
            FabricItemGroup.builder().icon(() -> new ItemStack(BBBlocks.MUD_STOVE)).displayName(Text.translatable("itemgroup.bitter_brews")).entries((displayContext, entries) -> {
                entries.add(BBBlocks.MUD_STOVE);
            }).build());

    public static void registerAddToVanilla() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Blocks.SMOKER, BBBlocks.MUD_STOVE);
        });
    }
}
