package net.yirmiri.bitter_brews.common.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.yirmiri.bitter_brews.core.registry.BBRecipeSerializer;
import net.yirmiri.bitter_brews.core.registry.BBRecipeTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TeaKettleRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public TeaKettleRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer inventory, Level world) {
        if (world.isClientSide()) {
            return false;
        }
        return recipeItems.stream().allMatch(ingredient -> {
            for (int i = 0; i < inventory.getContainerSize(); i++) {
                if (ingredient.test(inventory.getItem(i))) {
                    return true;
                }
            }
            return false;
        });
    }

    public boolean containsItem(ItemStack stack) {
        for (Ingredient ingredient : recipeItems) {
            if (ingredient.test(stack)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ItemStack assemble(SimpleContainer inventory, RegistryAccess registryManager) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryManager) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BBRecipeSerializer.TEA_KETTLE_RECIPE.get();
    }

    @Override
    public RecipeType<?> getType() {
        return BBRecipeTypes.TEA_KETTLE_RECIPE_TYPE.get();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    public static class Type implements RecipeType<TeaKettleRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "brewing";
    }

    public static class Serializer implements RecipeSerializer<TeaKettleRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "brewing";

        @Override
        public @NotNull TeaKettleRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

            for (int j = 0; j < inputs.size(); j++) {
                inputs.set(j, Ingredient.fromJson(ingredients.get(j)));
            }
            return new TeaKettleRecipe(id, output, inputs);
        }

        @Override
        public @Nullable TeaKettleRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            int i = buf.readInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(i, Ingredient.EMPTY);

            inputs.replaceAll(ignored -> Ingredient.fromNetwork(buf));

            ItemStack output = buf.readItem();
            return new TeaKettleRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, TeaKettleRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buf);
            }
            buf.writeItem(recipe.getResultItem(null));
        }
    }
}
