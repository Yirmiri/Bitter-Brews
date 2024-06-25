package net.azurune.bitter_brews.compat.jei;

import mezz.jei.api.IModPlugin;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;

@MethodsReturnNonnullByDefault
public class BitterBrewsJEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(BitterBrewsConstants.MOD_ID, "jei_plugin");
    }

    /*
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new TeaKettleRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<TeaKettleRecipe> brewingRecipes = recipeManager.getAllRecipesFor(BBRecipeTypes.TEA_KETTLE_RECIPE_TYPE.get());
        registration.addRecipes(TeaKettleRecipeCategory.BREWING, brewingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(TeaKettleScreen.class, 85, 37, 10, 11, TeaKettleRecipeCategory.BREWING);
    }

     */
}
