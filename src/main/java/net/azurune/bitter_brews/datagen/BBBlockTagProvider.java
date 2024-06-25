package net.azurune.bitter_brews.datagen;

import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.registry.RegisterBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class BBBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public static final TagKey<Block> HEAT_SOURCES = create("heat_sources");

    public BBBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(RegisterBlocks.MUD_STOVE)
                .add(RegisterBlocks.MUD_COUNTER)
                .add(RegisterBlocks.COPPER_KETTLE)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(RegisterBlocks.COPPER_KETTLE)
        ;

        getOrCreateTagBuilder(HEAT_SOURCES)
                .add(Blocks.MAGMA_BLOCK)
                .add(Blocks.FIRE)
                .add(Blocks.SOUL_FIRE)
                .add(RegisterBlocks.MUD_STOVE)
                .add(RegisterBlocks.SOUL_PEPPER_CROP)
        ;
    }

    private static TagKey<Block> create(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(BitterBrews.MOD_ID, id));
    }
}
