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

    public BBItemTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> future1, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, future, future1, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
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
                .add(BBItems.CUP_OF_ICED_TEA.get())
                .add(BBItems.CUP_OF_JASMINE_TEA.get())
                .add(BBItems.CUP_OF_MELON_JUICE.get())
                .add(BBItems.CUP_OF_SWEET_BERRY_JUICE.get())
                .add(BBItems.CUP_OF_GLOW_BERRY_JUICE.get())
                .add(BBItems.CUP_OF_CRIMSON_TEA.get())
                .add(BBItems.CUP_OF_WARPED_TEA.get())
                .add(BBItems.CUP_OF_SHROOMLIGHT_TEA.get())
                .add(BBItems.CUP_OF_CHORUS_JUICE.get())
                .add(BBItems.CUP_OF_LIGHTNING.get());
    }
}
