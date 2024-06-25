package net.azurune.bitter_brews.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.recipe.CopperKettleRecipe;

import java.util.function.Supplier;

public class BBRecipeSerializer {
    public static final Supplier<RecipeSerializer<CopperKettleRecipe>> TEA_KETTLE_RECIPE = register("brewing", CopperKettleRecipe.Serializer::new);

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> Supplier register(String string, Supplier<S> recipeSerializer) {
        return BitterBrews.register(BuiltInRegistries.RECIPE_SERIALIZER, string, recipeSerializer);
    }

    public static void registerRecipeSerializers() {
    }
}
