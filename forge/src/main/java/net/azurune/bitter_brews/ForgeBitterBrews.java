package net.azurune.bitter_brews;

import net.azurune.bitter_brews.datagen.client.BBEnUsLangGen;
import net.azurune.bitter_brews.datagen.client.BitterBrewsItemModelProvider;
import net.azurune.bitter_brews.datagen.server.BBBlockTagGen;
import net.azurune.bitter_brews.datagen.server.BBItemTagGen;
import net.azurune.bitter_brews.datagen.server.BBRecipeProvider;
import net.azurune.bitter_brews.platform.ForgeBitterBrewsRegistryHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
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
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        //Client
        generator.addProvider(event.includeClient(), new BBEnUsLangGen(packOutput, BitterBrewsConstants.MOD_ID, "en_us"));
        generator.addProvider(event.includeClient(), new BitterBrewsItemModelProvider(packOutput, BitterBrewsConstants.MOD_ID, fileHelper));

        //Server
        generator.addProvider(event.includeServer(), new BBRecipeProvider(packOutput));
        BBBlockTagGen blockTagProvider = new BBBlockTagGen(packOutput, lookupProvider, BitterBrewsConstants.MOD_ID, fileHelper);
        generator.addProvider(event.includeServer(), blockTagProvider);
        generator.addProvider(event.includeServer(), new BBItemTagGen(packOutput, lookupProvider, blockTagProvider.contentsGetter(), BitterBrewsConstants.MOD_ID, fileHelper));
    }
}