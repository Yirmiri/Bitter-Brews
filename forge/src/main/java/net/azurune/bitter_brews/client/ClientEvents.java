package net.azurune.bitter_brews.client;

import net.azurune.bitter_brews.BitterBrewsConstants;
import net.azurune.bitter_brews.core.registry.BBBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
@Mod.EventBusSubscriber(modid = BitterBrewsConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BBBlocks.PEPPER_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBlocks.SOUL_PEPPER_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBlocks.AZALEA_FLOWER.get(), RenderType.cutout());
        //ItemBlockRenderTypes.setRenderLayer(BBBlocks.COPPER_TEA_KETTLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BBBlocks.COFFEE_BUSH.get(), RenderType.cutout());
    }
}
