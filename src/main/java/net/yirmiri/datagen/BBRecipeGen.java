package net.yirmiri.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.yirmiri.register.BBBlocks;
import net.yirmiri.register.BBItems;

import java.util.function.Consumer;

public class BBRecipeGen extends FabricRecipeProvider {
    public BBRecipeGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        //ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AUBlocks.GLOOM_PLANKS, 4)
                //.input(AUBlocks.STRIPPED_GLOOM_WOOD)
                //.criterion(hasItem(AUBlocks.STRIPPED_GLOOM_WOOD), conditionsFromItem(AUBlocks.STRIPPED_GLOOM_WOOD))
                //.offerTo(exporter, new Identifier(getRecipeName(AUBlocks.GLOOM_PLANKS) + "_from_stripped_wood"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BBBlocks.MUD_STOVE, 1)
                .input('#', Blocks.MUD_BRICKS).input('@', Blocks.MAGMA_BLOCK).input('$', Items.IRON_INGOT)
                .pattern("$@$")
                .pattern("# #")
                .pattern("$$$")
                .criterion(hasItem(Blocks.MUD_BRICKS), conditionsFromItem(Blocks.MUD_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(BBBlocks.MUD_STOVE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BBBlocks.MUD_COUNTER, 4)
                .input('#', Blocks.MUD_BRICKS).input('$', Items.IRON_INGOT)
                .pattern("$$$")
                .pattern("# #")
                .pattern("$$$")
                .criterion(hasItem(Blocks.MUD_BRICKS), conditionsFromItem(Blocks.MUD_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(BBBlocks.MUD_COUNTER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BBItems.MUD_CUP, 4)
                .input('#', Blocks.PACKED_MUD)
                .pattern("# #")
                .pattern(" # ")
                .criterion(hasItem(Blocks.PACKED_MUD), conditionsFromItem(Blocks.PACKED_MUD))
                .offerTo(exporter, new Identifier(getRecipeName(BBItems.MUD_CUP)));
    }
}
