package net.azurune.bitter_brews.datagen.server;

import net.azurune.bitter_brews.core.registry.BBBlocks;
import net.azurune.bitter_brews.core.registry.BBTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BBBlockTagGen extends BlockTagsProvider {
    public BBBlockTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        appendMineableWithPickaxes();
        appendNeedsStoneTool();
        appendHeatSources();
    }


    private void appendMineableWithPickaxes() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BBBlocks.MUD_STOVE.get())
                .add(BBBlocks.MUD_COUNTER.get())
                .add(BBBlocks.COPPER_TEA_KETTLE.get());
    }

    private void appendNeedsStoneTool() {
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BBBlocks.COPPER_TEA_KETTLE.get());
    }
    private void appendHeatSources() {
        tag(BBTags.BlockTags.HEAT_SOURCES)
                .add(Blocks.MAGMA_BLOCK)
                .add(Blocks.FIRE)
                .add(Blocks.SOUL_FIRE)
                .add(BBBlocks.MUD_STOVE.get())
                .add(BBBlocks.SOUL_PEPPER_CROP.get());
    }
}
