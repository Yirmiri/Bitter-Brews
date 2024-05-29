package net.azurune.bitter_brews;

import net.azurune.bitter_brews.platform.ForgeBitterBrewsRegistryHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BitterBrewsConstants.MOD_ID)
public class ForgeBitterBrews {
    
    public ForgeBitterBrews() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BitterBrews.init();

        ForgeBitterBrewsRegistryHelper.BLOCKS.register(modEventBus);
        ForgeBitterBrewsRegistryHelper.ITEMS.register(modEventBus);
    }
}