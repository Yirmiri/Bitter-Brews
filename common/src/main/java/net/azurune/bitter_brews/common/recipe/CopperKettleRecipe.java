package net.azurune.bitter_brews.common.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.azurune.bitter_brews.core.registry.BBRecipeSerializer;
import net.azurune.bitter_brews.core.registry.BBRecipeTypes;
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

import java.util.concurrent.atomic.AtomicInteger;

public class CopperKettleRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public CopperKettleRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer inventory, Level world) {
        AtomicInteger counter = new AtomicInteger();
        return recipeItems.stream().allMatch(ingredient ->
                ingredient.test(inventory.getItem(counter.getAndIncrement())));
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
        return BBRecipeSerializer.COPPER_KETTLE_RECIPE.get();
    }

    @Override
    public RecipeType<?> getType() {
        return BBRecipeTypes.COPPER_KETTLE_RECIPE_TYPE.get();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    public static class Type implements RecipeType<CopperKettleRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "brewing";
    }

    public static class Serializer implements RecipeSerializer<CopperKettleRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "brewing";

        @Override
        public @NotNull CopperKettleRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

            for (int j = 0; j < inputs.size(); j++) {
                inputs.set(j, Ingredient.fromJson(ingredients.get(j)));
            }
            return new CopperKettleRecipe(id, output, inputs);
        }

        @Override
        public @Nullable CopperKettleRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            int i = buf.readInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(i, Ingredient.EMPTY);

            inputs.replaceAll(ignored -> Ingredient.fromNetwork(buf));

            ItemStack output = buf.readItem();
            return new CopperKettleRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CopperKettleRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buf);
            }
            buf.writeItem(recipe.getResultItem(null));
        }
    }
}
