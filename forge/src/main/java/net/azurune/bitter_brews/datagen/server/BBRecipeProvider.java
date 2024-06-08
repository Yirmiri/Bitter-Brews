package net.azurune.bitter_brews.datagen.server;

import net.azurune.bitter_brews.core.registry.BBBlocks;
import net.azurune.bitter_brews.core.registry.BBItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class BBRecipeProvider extends RecipeProvider {
    public BBRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BBItems.PEPPER_SEEDS.get(), 2)
                .requires(BBItems.PEPPER.get())
                .unlockedBy(getItemName(BBItems.PEPPER.get()), has(BBItems.PEPPER.get()))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BBItems.SOUL_PEPPER_SEEDS.get(), 2)
                .requires(BBItems.SOUL_PEPPER.get())
                .unlockedBy(getItemName(BBItems.SOUL_PEPPER.get()), has(BBItems.SOUL_PEPPER.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BBBlocks.MUD_STOVE.get(), 1)
                .define('#', Blocks.MUD_BRICKS).define('@', Blocks.MAGMA_BLOCK).define('$', Items.IRON_INGOT)
                .pattern("$@$")
                .pattern("# #")
                .pattern("$$$")
                .unlockedBy(getItemName(Blocks.MUD_BRICKS), has(Blocks.MUD_BRICKS))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BBBlocks.MUD_COUNTER.get(), 4)
                .define('#', Blocks.MUD_BRICKS).define('$', Items.IRON_INGOT)
                .pattern("$$$")
                .pattern("# #")
                .pattern("$$$")
                .unlockedBy(getItemName(Blocks.MUD_BRICKS), has(Blocks.MUD_BRICKS))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BBItems.MUD_CUP.get(), 4)
                .define('#', Blocks.PACKED_MUD)
                .pattern("# #")
                .pattern(" # ")
                .unlockedBy(getItemName(Blocks.PACKED_MUD), has(Blocks.PACKED_MUD))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BBItems.CUP_OF_MILK.get(), 1)
                .requires(BBItems.MUD_CUP.get()).requires(Items.MILK_BUCKET)
                .unlockedBy(getItemName(BBItems.MUD_CUP.get()), has(BBItems.MUD_CUP.get()))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BBItems.CUP_OF_WATER.get(), 1)
                .requires(BBItems.MUD_CUP.get()).requires(Items.WATER_BUCKET)
                .unlockedBy(getItemName(BBItems.MUD_CUP.get()), has(BBItems.MUD_CUP.get()))
                .save(exporter);
    }
}
