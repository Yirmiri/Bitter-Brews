package net.azurune.bitter_brews;

import net.azurune.bitter_brews.core.registry.BBBlocks;
import net.azurune.bitter_brews.core.registry.BBItems;
import net.azurune.bitter_brews.datagen.client.BBEnUsLangGen;
import net.azurune.bitter_brews.datagen.client.BitterBrewsItemModelProvider;
import net.azurune.bitter_brews.datagen.server.BBBlockTagGen;
import net.azurune.bitter_brews.datagen.server.BBItemTagGen;
import net.azurune.bitter_brews.datagen.server.BBRecipeProvider;
import net.azurune.bitter_brews.platform.ForgeBitterBrewsRegistryHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.concurrent.CompletableFuture;

@Mod(BitterBrewsConstants.MOD_ID)
public class ForgeBitterBrews {
    
    public ForgeBitterBrews() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BitterBrews.init();

        ForgeBitterBrewsRegistryHelper.BLOCKS.register(modEventBus);
        ForgeBitterBrewsRegistryHelper.ITEMS.register(modEventBus);

        modEventBus.addListener(this::gatherData);
        modEventBus.addListener(this::buildCreativeTabs);
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        //Client Datagen
        generator.addProvider(event.includeClient(), new BBEnUsLangGen(packOutput, BitterBrewsConstants.MOD_ID, "en_us"));
        generator.addProvider(event.includeClient(), new BitterBrewsItemModelProvider(packOutput, BitterBrewsConstants.MOD_ID, fileHelper));

        //Server Datagen
        generator.addProvider(event.includeServer(), new BBRecipeProvider(packOutput));
        BBBlockTagGen blockTagProvider = new BBBlockTagGen(packOutput, lookupProvider, BitterBrewsConstants.MOD_ID, fileHelper);
        generator.addProvider(event.includeServer(), blockTagProvider);
        generator.addProvider(event.includeServer(), new BBItemTagGen(packOutput, lookupProvider, blockTagProvider.contentsGetter(), BitterBrewsConstants.MOD_ID, fileHelper));
    }

    public void buildCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            addAfter(event, Items.NETHER_WART, BBItems.PEPPER_SEEDS.get());
            addAfter(event, BBItems.PEPPER_SEEDS.get(), BBItems.SOUL_PEPPER_SEEDS.get());
            addAfter(event, Blocks.FLOWERING_AZALEA, BBBlocks.COFFEE_BUSH.get());
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            addAfter(event, Blocks.SMOKER, BBBlocks.MUD_STOVE.get());
            addAfter(event, BBBlocks.MUD_STOVE.get(), BBBlocks.MUD_COUNTER.get());
            addAfter(event, BBBlocks.MUD_COUNTER.get(), BBBlocks.COPPER_TEA_KETTLE.get());
        }
        
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            addAfter(event, Items.ENCHANTED_GOLDEN_APPLE, BBItems.MANGO.get());
            addAfter(event, Items.BEETROOT, BBItems.PEPPER.get());
            addAfter(event, BBItems.PEPPER.get(), BBItems.SOUL_PEPPER.get());
            addAfter(event, Items.DRIED_KELP, BBItems.DRIED_TEA_LEAVES.get());
            addAfter(event, Items.SPIDER_EYE, BBItems.CUP_OF_WATER.get());
            addAfter(event, BBItems.CUP_OF_WATER.get(), BBItems.CUP_OF_GREEN_TEA.get());
            addAfter(event, BBItems.CUP_OF_GREEN_TEA.get(), BBItems.CUP_OF_AZALEA_TEA.get());
            addAfter(event, BBItems.CUP_OF_AZALEA_TEA.get(), BBItems.CUP_OF_BLACK_TEA.get());
            addAfter(event, BBItems.CUP_OF_BLACK_TEA.get(), BBItems.CUP_OF_ICED_TEA.get());
            addAfter(event, BBItems.CUP_OF_ICED_TEA.get(), BBItems.CUP_OF_HONEY_TEA.get());
            addAfter(event, BBItems.CUP_OF_HONEY_TEA.get(), BBItems.CUP_OF_MANGO_TEA.get());
            addAfter(event, BBItems.CUP_OF_MANGO_TEA.get(), BBItems.CUP_OF_KELP_TEA.get());
            addAfter(event, BBItems.CUP_OF_KELP_TEA.get(), BBItems.CUP_OF_JASMINE_TEA.get());
            addAfter(event, BBItems.CUP_OF_JASMINE_TEA.get(), BBItems.CUP_OF_COFFEE.get());
            addAfter(event, BBItems.CUP_OF_COFFEE.get(), BBItems.CUP_OF_DARK_COFFEE.get());
            addAfter(event, BBItems.CUP_OF_DARK_COFFEE.get(), BBItems.CUP_OF_ESPRESSO.get());
            addAfter(event, BBItems.CUP_OF_ESPRESSO.get(), BBItems.CUP_OF_MILK.get());
            addAfter(event, BBItems.CUP_OF_MILK.get(), BBItems.CUP_OF_CHOCOLATE_MILK.get());
            addAfter(event, BBItems.CUP_OF_CHOCOLATE_MILK.get(), BBItems.CUP_OF_HOT_COCOA.get());
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            addAfter(event, Items.KELP, BBItems.TEA_LEAVES.get());
            addAfter(event, BBItems.TEA_LEAVES.get(), BBBlocks.AZALEA_FLOWER.get());
            addAfter(event, Items.COCOA_BEANS, BBItems.COFFEE_BEANS.get());
            addAfter(event, Items.GLASS_BOTTLE, BBItems.MUD_CUP.get());
        }
    }

    private void addAfter(BuildCreativeModeTabContentsEvent event, Item beforeItem, Item item) {
        event.getEntries().putAfter(beforeItem.getDefaultInstance(), item.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
    
    private void addAfter(BuildCreativeModeTabContentsEvent event, Block beforeItem, Item item) {
        event.getEntries().putAfter(beforeItem.asItem().getDefaultInstance(), item.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
    
    private void addAfter(BuildCreativeModeTabContentsEvent event, Item beforeItem, Block item) {
        event.getEntries().putAfter(beforeItem.getDefaultInstance(), item.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
    
    private void addAfter(BuildCreativeModeTabContentsEvent event, Block beforeItem, Block item) {
        event.getEntries().putAfter(beforeItem.asItem().getDefaultInstance(), item.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}