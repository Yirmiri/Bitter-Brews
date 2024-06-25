package net.azurune.bitter_brews.datagen;

import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.registry.RegisterBlocks;
import net.azurune.bitter_brews.registry.RegisterItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class BBRecipeProvider extends FabricRecipeProvider {
    public BBRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RegisterItems.PEPPER_SEEDS, 2)
                .input(RegisterItems.PEPPER)
                .criterion(hasItem(RegisterItems.PEPPER), conditionsFromItem(RegisterItems.PEPPER))
                .offerTo(exporter, Identifier.of(BitterBrews.MOD_ID, getRecipeName(RegisterItems.PEPPER)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RegisterItems.SOUL_PEPPER_SEEDS, 2)
                .input(RegisterItems.SOUL_PEPPER)
                .criterion(hasItem(RegisterItems.SOUL_PEPPER), conditionsFromItem(RegisterItems.SOUL_PEPPER))
                .offerTo(exporter, Identifier.of(BitterBrews.MOD_ID, getRecipeName(RegisterItems.SOUL_PEPPER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.MUD_STOVE, 1)
                .input('#', Blocks.MUD_BRICKS).input('@', Blocks.MAGMA_BLOCK).input('$', Items.IRON_INGOT)
                .pattern("$@$")
                .pattern("# #")
                .pattern("$$$")
                .criterion(hasItem(Blocks.MUD_BRICKS), conditionsFromItem(Blocks.MUD_BRICKS))
                .offerTo(exporter, Identifier.of(BitterBrews.MOD_ID, getRecipeName(RegisterBlocks.MUD_STOVE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterBlocks.MUD_COUNTER, 4)
                .input('#', Blocks.MUD_BRICKS).input('$', Items.IRON_INGOT)
                .pattern("$$$")
                .pattern("# #")
                .pattern("$$$")
                .criterion(hasItem(Blocks.MUD_BRICKS), conditionsFromItem(Blocks.MUD_BRICKS))
                .offerTo(exporter, Identifier.of(BitterBrews.MOD_ID, getRecipeName(RegisterBlocks.MUD_COUNTER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, RegisterItems.MUD_CUP, 4)
                .input('#', Blocks.PACKED_MUD)
                .pattern("# #")
                .pattern(" # ")
                .criterion(hasItem(Blocks.PACKED_MUD), conditionsFromItem(Blocks.PACKED_MUD))
                .offerTo(exporter, Identifier.of(BitterBrews.MOD_ID, getRecipeName(RegisterItems.MUD_CUP)));
    }
}
