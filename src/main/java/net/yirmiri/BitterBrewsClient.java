package net.yirmiri;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.yirmiri.register.BBBlocks;

public class BitterBrewsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //CUTOUT
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.PEPPER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.SOUL_PEPPER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BBBlocks.AZALEA_FLOWER, RenderLayer.getCutout());
    }
}
