package net.yirmiri.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

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

        //ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AUBlocks.GLOOM_STAIRS, 4)
                //.input('#', AUBlocks.GLOOM_PLANKS)
                //.pattern("#  ")
                //.pattern("## ")
                //.pattern("###")
                //.criterion(hasItem(AUBlocks.GLOOM_PLANKS), conditionsFromItem(AUBlocks.GLOOM_PLANKS))
                //.offerTo(exporter, new Identifier(getRecipeName(AUBlocks.GLOOM_STAIRS)));
    }
}
