package net.azurune.bitter_brews;

import net.azurune.bitter_brews.common.screen.CopperKettleScreen;
import net.azurune.bitter_brews.core.registry.BBBlocks;
import net.azurune.bitter_brews.core.registry.BBMenuTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;

public class ClientFabricBitterBrews implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //CUTOUT
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.PEPPER_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.SOUL_PEPPER_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.AZALEA_FLOWER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.COPPER_KETTLE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.COFFEE_BUSH.get(), RenderType.cutout());

        MenuScreens.register(BBMenuTypes.TEA_KETTLE_MENU.get(), CopperKettleScreen::new);
    }
}
