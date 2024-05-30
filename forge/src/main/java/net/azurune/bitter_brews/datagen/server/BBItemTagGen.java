package net.azurune.bitter_brews.datagen.server;

import net.azurune.bitter_brews.core.registry.BBItems;
import net.azurune.bitter_brews.core.registry.BBTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BBItemTagGen extends ItemTagsProvider {

    public BBItemTagGen(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        appendBrews();
    }

    private void appendBrews() {
        tag(BBTags.ItemTags.BREWS)
                .add(BBItems.CUP_OF_AZALEA_TEA.get())
                .add(BBItems.CUP_OF_GREEN_TEA.get())
                .add(BBItems.CUP_OF_HONEY_TEA.get())
                .add(BBItems.CUP_OF_KELP_TEA.get())
                .add(BBItems.CUP_OF_MANGO_TEA.get())
                .add(BBItems.CUP_OF_FUDGE_SUNDAE.get())
                .add(BBItems.CUP_OF_BLACK_TEA.get())
                .add(BBItems.CUP_OF_COFFEE.get())
                .add(BBItems.CUP_OF_DARK_COFFEE.get())
                .add(BBItems.CUP_OF_ESPRESSO.get())
                .add(BBItems.CUP_OF_HOT_COCOA.get())
                .add(BBItems.CUP_OF_CHOCOLATE_MILK.get())
                .add(BBItems.CUP_OF_MILK.get())
                .add(BBItems.CUP_OF_ICED_TEA.get())
                .add(BBItems.CUP_OF_JASMINE_TEA.get())
        ;
    }
}
