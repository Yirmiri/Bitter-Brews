package net.azurune.bitter_brews;

import net.azurune.bitter_brews.core.registry.BBBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class ClientFabricBitterBrews implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //CUTOUT
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.PEPPER_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.SOUL_PEPPER_CROP.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.AZALEA_FLOWER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.COPPER_TEA_KETTLE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.COFFEE_BUSH.get(), RenderType.cutout());
    }
}
