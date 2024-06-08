package net.azurune.bitter_brews.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.azurune.bitter_brews.BitterBrewsConstants;
import net.azurune.bitter_brews.common.recipe.TeaKettleRecipe;
import net.azurune.bitter_brews.common.screen.TeaKettleScreen;
import net.azurune.bitter_brews.core.compat.jei.TeaKettleRecipeCategory;
import net.azurune.bitter_brews.core.registry.BBRecipeTypes;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@JeiPlugin
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BitterBrewsJEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(BitterBrewsConstants.MOD_ID, "jei_plugin");
    }

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
        //registration.addRecipeClickArea(TeaKettleScreen.class, 85, 37, 10, 11, TeaKettleRecipeCategory.BREWING);
    }
}
