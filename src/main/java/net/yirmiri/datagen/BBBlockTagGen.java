package net.yirmiri.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.yirmiri.BitterBrews;
import net.yirmiri.register.BBBlocks;

import java.util.concurrent.CompletableFuture;

public class BBBlockTagGen extends FabricTagProvider.BlockTagProvider {
    public static final TagKey<Block> HEAT_SOURCES = create("heat_sources");

    public BBBlockTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(BBBlocks.MUD_STOVE)
        ;

        getOrCreateTagBuilder(HEAT_SOURCES)
                .add(Blocks.MAGMA_BLOCK)
                .add(Blocks.FIRE)
                .add(Blocks.SOUL_FIRE)
                .add(BBBlocks.MUD_STOVE)
        ;
    }

    private static TagKey<Block> create(String name) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(BitterBrews.MODID, name));
    }
}
