package net.yirmiri.bitter_brews.core.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.yirmiri.bitter_brews.BitterBrews;
import net.yirmiri.bitter_brews.common.recipe.TeaKettleRecipe;

import java.util.function.Supplier;

public class BBRecipeTypes<T extends Recipe<?>> {

    public static final Supplier<RecipeType<TeaKettleRecipe>> TEA_KETTLE_RECIPE_TYPE = register("brewing");

    private static <T extends Recipe<?>> Supplier<RecipeType<T>> register(String name) {
        Supplier<RecipeType<T>> recipeType = () -> (RecipeType<T>) TeaKettleRecipe.Type.INSTANCE;
        return BitterBrews.register(BuiltInRegistries.RECIPE_TYPE, name, recipeType);
    }

    public static void loadRecipeTypes() {
    }
}