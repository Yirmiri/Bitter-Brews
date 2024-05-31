package net.azurune.bitter_brews.common.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.BitterBrewsConstants;
import net.azurune.bitter_brews.core.registry.BBRecipeSerializer;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TeaKettleRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> ingredient;
    private final ItemStack output;
    private final ResourceLocation id;
    public static final int INGREDIENTS = 5;

    public TeaKettleRecipe(NonNullList<Ingredient> ingredient, ItemStack output, ResourceLocation id) {
        this.ingredient = ingredient;
        this.output = output;
        this.id = id;
    }

    public static class Type implements RecipeType<TeaKettleRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "brewing";
    }


    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide()) {
            return false;
        }
        return ingredient.get(0).test(simpleContainer.getItem(0)) && ingredient.get(0).test(simpleContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer simpleContainer, RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }
    @Override @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return ingredient;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return BBRecipeSerializer.TEA_KETTLE_RECIPE.get();
    }

    @Override
    public RecipeType<?> getType() {
        return BBRecipeSerializer.TEA_KETTLE_RECIPE_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<TeaKettleRecipe> {
        @Override
        public TeaKettleRecipe fromJson(ResourceLocation id, JsonObject json) {
            final NonNullList<Ingredient> ingredients = readIngredients(GsonHelper.getAsJsonArray(json, "ingredients"));

            if (ingredients.isEmpty()) {
                throw new JsonParseException("No ingredients for this recipe");

            } else if (ingredients.size() > TeaKettleRecipe.INGREDIENTS) {
                throw new JsonParseException("The max amount of ingredients allowed in this recipe is " + TeaKettleRecipe.INGREDIENTS);

            } else {
                final ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
                return new TeaKettleRecipe(ingredients, output, id);
            }
        }

        private static NonNullList<Ingredient> readIngredients(JsonArray ingredientArray) {
            NonNullList<Ingredient> nonnulllist = NonNullList.create();

            for (int i = 0; i < ingredientArray.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(ingredientArray.get(i));
                if (!ingredient.isEmpty()) {
                    nonnulllist.add(ingredient);
                }
            }

            return nonnulllist;
        }

        @Override
        public @Nullable TeaKettleRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf byteBuf) {
            int i = byteBuf.readInt();
            NonNullList<Ingredient> ingredients = NonNullList.withSize(i, Ingredient.EMPTY);

            for (int j = 0; j < ingredients.size(); j++) {
                ingredients.set(j, Ingredient.fromNetwork(byteBuf));
            }

            ItemStack output = byteBuf.readItem();
            return new TeaKettleRecipe(ingredients, output, id);
        }

        @Override
        public void toNetwork(FriendlyByteBuf byteBuf, TeaKettleRecipe recipe) {
            byteBuf.writeInt(recipe.ingredient.size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(byteBuf);
            }

            byteBuf.writeItem(recipe.getResultItem(RegistryAccess.EMPTY));
        }
    }
}
