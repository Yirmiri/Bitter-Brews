package net.azurune.bitter_brews;

import net.azurune.bitter_brews.screen.CopperKettleScreen;
import net.azurune.bitter_brews.registry.RegisterBlocks;
import net.azurune.bitter_brews.registry.RegisterScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BitterBrewsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //CUTOUT
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.PEPPER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.SOUL_PEPPER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.AZALEA_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.COPPER_KETTLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.COFFEE_BUSH, RenderLayer.getCutout());

        //MENU
        MenuScreens.register(RegisterScreenHandlers.TEA_KETTLE_SCREEN_HANDLER, CopperKettleScreen::new);
    }
}
