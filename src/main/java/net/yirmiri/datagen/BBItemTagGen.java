package net.yirmiri.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.yirmiri.BitterBrews;
import net.yirmiri.register.BBItems;

import java.util.concurrent.CompletableFuture;

public class BBItemTagGen extends FabricTagProvider.ItemTagProvider {
    public static final TagKey<Item> BREWS = create("brews");

    public BBItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BREWS)
                .add(BBItems.CUP_OF_AZALEA_TEA)
                .add(BBItems.CUP_OF_GREEN_TEA)
                .add(BBItems.CUP_OF_HONEY_TEA)
                .add(BBItems.CUP_OF_KELP_TEA)
                .add(BBItems.CUP_OF_MANGO_TEA)
                .add(BBItems.CUP_OF_FUDGE_SUNDAE)
                .add(BBItems.CUP_OF_BLACK_TEA)
                .add(BBItems.CUP_OF_COFFEE)
                .add(BBItems.CUP_OF_DARK_COFFEE)
                .add(BBItems.CUP_OF_ESPRESSO)
                .add(BBItems.CUP_OF_HOT_COCOA)
                .add(BBItems.CUP_OF_CHOCOLATE_MILK)
                .add(BBItems.CUP_OF_MILK)
                .add(BBItems.CUP_OF_ICED_TEA)
                .add(BBItems.CUP_OF_JASMINE_TEA)
        ;
    }

    private static TagKey<Item> create(String name) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(BitterBrews.MODID, name));
    }
}
