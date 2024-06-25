package net.azurune.bitter_brews.registry;

import net.azurune.bitter_brews.BitterBrews;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RegisterItemGroups {
    private static final ItemGroup INGREDIENTS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(RegisterItems.TEA_LEAVES))
            .displayName(Text.translatable("itemGroup.bitter_brews.ingredients"))
            .entries((ctx, entries) -> {
                RegisterBlocks.getBlockHashMap.forEach((id, pair) -> {
                    if (pair.getLeft() != null) entries.add(new ItemStack(pair.getLeft()));
                });

                RegisterItems.getItemHashMap.forEach((id, item) -> {
                    entries.add(new ItemStack(item));
                });
            }).build();

    private static final ItemGroup DRINKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(RegisterDrinkItems.CUP_OF_COFFEE))
            .displayName(Text.translatable("itemGroup.bitter_brews.drinks"))
            .entries((ctx, entries) -> {
                RegisterDrinkItems.getDrinkHashMap().forEach((id, item) -> {
                    if(item != RegisterDrinkItems.CUP_OF_FUDGE_SUNDAE || item != RegisterDrinkItems.CUP_OF_LIGHTNING) entries.add(new ItemStack(item));
                });
            }).build();

    public static void registerCustomTabs() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(BitterBrews.MOD_ID, "ingredients"), INGREDIENTS);
        Registry.register(Registries.ITEM_GROUP, Identifier.of(BitterBrews.MOD_ID, "drinks"), DRINKS);
    }
}
