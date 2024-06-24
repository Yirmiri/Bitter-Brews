package net.yirmiri.bitter_brews.core.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.yirmiri.bitter_brews.BitterBrews;
import net.yirmiri.bitter_brews.common.recipe.TeaKettleRecipe;

import java.util.function.Supplier;

public class BBRecipeSerializer {

    public static final Supplier<RecipeSerializer<TeaKettleRecipe>> TEA_KETTLE_RECIPE = register("brewing", TeaKettleRecipe.Serializer::new);

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> Supplier register(String string, Supplier<S> recipeSerializer) {
        return BitterBrews.register(BuiltInRegistries.RECIPE_SERIALIZER, string, recipeSerializer);
    }

    public static void loadRecipeSerializers() {
    }
}
