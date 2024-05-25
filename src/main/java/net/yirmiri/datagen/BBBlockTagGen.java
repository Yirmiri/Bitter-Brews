package net.yirmiri.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.yirmiri.BitterBrews;

import java.util.concurrent.CompletableFuture;

public class BBBlockTagGen extends FabricTagProvider.BlockTagProvider {
    public BBBlockTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                //.add(AUBlocks.GLOOM_LOG)
        //;
    }

    private static TagKey<Block> create(String name) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(BitterBrews.MODID, name));
    }
}
