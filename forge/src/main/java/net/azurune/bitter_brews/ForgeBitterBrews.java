package net.azurune.bitter_brews;

import net.minecraftforge.fml.common.Mod;

@Mod(BitterBrewsConstants.MOD_ID)
public class ForgeBitterBrews {
    
    public ForgeBitterBrews() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        BitterBrewsConstants.LOG.info("Hello Forge world!");
        BitterBrews.init();
        
    }
}