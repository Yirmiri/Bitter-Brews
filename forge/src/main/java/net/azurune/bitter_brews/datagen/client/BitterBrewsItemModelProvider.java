package net.azurune.bitter_brews.datagen.client;

import net.azurune.bitter_brews.core.registry.BBItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BitterBrewsItemModelProvider extends ItemModelProvider {
    public BitterBrewsItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(BBItems.MUD_CUP.get() );
        basicItem(BBItems.CUP_OF_GREEN_TEA.get());
        basicItem(BBItems.CUP_OF_HONEY_TEA.get());
        basicItem(BBItems.CUP_OF_KELP_TEA.get());
        basicItem(BBItems.CUP_OF_MANGO_TEA.get());
        basicItem(BBItems.CUP_OF_FUDGE_SUNDAE.get());
        basicItem(BBItems.CUP_OF_AZALEA_TEA.get());
        basicItem(BBItems.CUP_OF_WATER.get());
        basicItem(BBItems.CUP_OF_BLACK_TEA.get());
        basicItem(BBItems.CUP_OF_CHOCOLATE_MILK.get());
        basicItem(BBItems.CUP_OF_MILK.get());
        basicItem(BBItems.CUP_OF_COFFEE.get());
        basicItem(BBItems.CUP_OF_DARK_COFFEE.get());
        basicItem(BBItems.CUP_OF_ESPRESSO.get());
        basicItem(BBItems.CUP_OF_HOT_COCOA.get());
        basicItem(BBItems.CUP_OF_ICED_TEA.get());
        basicItem(BBItems.CUP_OF_JASMINE_TEA.get());
        basicItem(BBItems.PEPPER.get());
        basicItem(BBItems.SOUL_PEPPER.get());
        basicItem(BBItems.TEA_LEAVES.get());
        basicItem(BBItems.DRIED_TEA_LEAVES.get());
        basicItem(BBItems.COFFEE_BEANS.get());
        basicItem(BBItems.MANGO.get());
        basicItem(BBItems.PEPPER_SEEDS.get());
        basicItem(BBItems.SOUL_PEPPER_SEEDS.get());
        basicItem(BBItems.CUP_OF_MELON_JUICE.get());
        basicItem(BBItems.CUP_OF_SWEET_BERRY_JUICE.get());
        basicItem(BBItems.CUP_OF_GLOW_BERRY_JUICE.get());
        basicItem(BBItems.CUP_OF_CRIMSON_TEA.get());
        basicItem(BBItems.CUP_OF_WARPED_TEA.get());
        basicItem(BBItems.CUP_OF_SHROOMLIGHT_TEA.get());
        basicItem(BBItems.CUP_OF_CHORUS_JUICE.get());
    }
}
