package net.yirmiri.bitter_brews.core.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.yirmiri.bitter_brews.BitterBrewsConstants;
import net.yirmiri.bitter_brews.common.recipe.TeaKettleRecipe;
import net.yirmiri.bitter_brews.core.registry.BBBlocks;

import java.util.Arrays;

@MethodsReturnNonnullByDefault
public class TeaKettleRecipeCategory implements IRecipeCategory<TeaKettleRecipe> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(BitterBrewsConstants.MOD_ID, "textures/gui/tea_kettle_jei.png");
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(BitterBrewsConstants.MOD_ID, "brewing");
    public static final RecipeType<TeaKettleRecipe> BREWING = new RecipeType<>(UID, TeaKettleRecipe.class);
    private final IDrawable icon;
    private final IDrawable background;

    public TeaKettleRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 172, 105);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BBBlocks.COPPER_TEA_KETTLE.get()));
    }
    /**
     * @return the type of recipe that this category handles.
     * @since 9.5.0
     */
    @Override
    public RecipeType<TeaKettleRecipe> getRecipeType() {
        return BREWING;
    }

    /**
     * Returns a text component representing the name of this recipe type.
     * Drawn at the top of the recipe GUI pages for this category.
     *
     * @since 7.6.4
     */
    @Override
    public Component getTitle() {
        return  Component.translatable("block.bitter_brews.tea_kettle");
    }

    /**
     * Returns the drawable background for a single recipe in this category.
     */
    @Override
    public IDrawable getBackground() {
        return this.background;
    }


    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    /**
     * Sets all the recipe's ingredients by filling out an instance of {@link IRecipeLayoutBuilder}.
     * This is used by JEI for lookups, to figure out what ingredients are inputs and outputs for a recipe.
     *
     * @param builder
     * @param recipe
     * @param focuses
     * @since 9.4.0
     */
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TeaKettleRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 27, 81).addItemStacks(Arrays.asList(recipe.getIngredients().get(0).getItems()));
        builder.addSlot(RecipeIngredientRole.INPUT, 17, 39).addItemStacks(Arrays.asList(recipe.getIngredients().get(1).getItems()));
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 39).addItemStacks(Arrays.asList(recipe.getIngredients().get(2).getItems()));
        builder.addSlot(RecipeIngredientRole.INPUT, 17, 59).addItemStacks(Arrays.asList(recipe.getIngredients().get(3).getItems()));
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 59).addItemStacks(Arrays.asList(recipe.getIngredients().get(4).getItems()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 99, 59).addItemStack(recipe.getResultItem(null));
    }
}
