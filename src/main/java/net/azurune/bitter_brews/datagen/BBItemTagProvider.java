package net.azurune.bitter_brews.datagen;

import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.registry.RegisterDrinkItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class BBItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public static final TagKey<Item> BREWS = create("brews");

    public BBItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BREWS)
                .add(RegisterDrinkItems.CUP_OF_AZALEA_TEA)
                .add(RegisterDrinkItems.CUP_OF_GREEN_TEA)
                .add(RegisterDrinkItems.CUP_OF_HONEY_TEA)
                .add(RegisterDrinkItems.CUP_OF_KELP_TEA)
                .add(RegisterDrinkItems.CUP_OF_MANGO_TEA)
                .add(RegisterDrinkItems.CUP_OF_FUDGE_SUNDAE)
                .add(RegisterDrinkItems.CUP_OF_BLACK_TEA)
                .add(RegisterDrinkItems.CUP_OF_COFFEE)
                .add(RegisterDrinkItems.CUP_OF_DARK_COFFEE)
                .add(RegisterDrinkItems.CUP_OF_ESPRESSO)
                .add(RegisterDrinkItems.CUP_OF_HOT_COCOA)
                .add(RegisterDrinkItems.CUP_OF_CHOCOLATE_MILK)
                .add(RegisterDrinkItems.CUP_OF_MILK)
                .add(RegisterDrinkItems.CUP_OF_ICED_TEA)
                .add(RegisterDrinkItems.CUP_OF_JASMINE_TEA)
                .add(RegisterDrinkItems.CUP_OF_MELON_JUICE)
                .add(RegisterDrinkItems.CUP_OF_SWEET_BERRY_JUICE)
                .add(RegisterDrinkItems.CUP_OF_GLOW_BERRY_JUICE)
                .add(RegisterDrinkItems.CUP_OF_CRIMSON_TEA)
                .add(RegisterDrinkItems.CUP_OF_WARPED_TEA)
                .add(RegisterDrinkItems.CUP_OF_SHROOMLIGHT_TEA)
                .add(RegisterDrinkItems.CUP_OF_CHORUS_JUICE)
                .add(RegisterDrinkItems.CUP_OF_LIGHTNING)
        ;
    }

    private static TagKey<Item> create(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(BitterBrews.MOD_ID, id));
    }
}
