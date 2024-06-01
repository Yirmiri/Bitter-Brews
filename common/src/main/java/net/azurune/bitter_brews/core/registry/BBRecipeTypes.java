package net.azurune.bitter_brews.core.registry;

import net.azurune.bitter_brews.common.recipe.TeaKettleRecipe;
import net.azurune.bitter_brews.core.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public class BBRecipeTypes<T extends Recipe<?>> {

    public static final Supplier<RecipeType<TeaKettleRecipe>> TEA_KETTLE_RECIPE_TYPE = register("brewing");

    private static <T extends Recipe<?>> Supplier<RecipeType<T>> register(String name) {
        Supplier<RecipeType<T>> recipeType = () -> (RecipeType<T>) TeaKettleRecipe.Type.INSTANCE;
        return Services.REGISTRY_HELPER.register(BuiltInRegistries.RECIPE_TYPE, name, recipeType);
    }

    public static void loadRecipeTypes() {
    }
}