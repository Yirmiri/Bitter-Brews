package net.azurune.bitter_brews.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.azurune.bitter_brews.registry.BBRecipeSerializer;
import net.azurune.bitter_brews.registry.BBRecipeTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * I KILLED A MAN
 * I WILL KILL AGAIN
 * IT BURNS WHEN I PEE
 *
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣶⣶⠶⣶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣾⡟⠋⠉⠀⠶⣦⠌⠙⠿⣦⡀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⡿⠋⠃⡀⣀⣤⣤⡤⠶⠷⣤⣽⣷⡄⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⠁⠀⢸⡟⠋⠉⠀⠀⠀⠀⠀⠈⠉⢧⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⢸⣷⣄⣀⠀⠀⠀⠀⠀⠀⠀⣸⠃⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣷⡀⠀⠀⠉⠛⠛⠿⠿⠿⢿⣿⣿⣿⡟⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⠿⢶⣴⣶⣤⣀⣀⣀⣀⣀⣘⣿⡿⠁⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣿⣿⣿⣏⠙⠛⠛⠛⠉⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⡿⠛⠁⠀⢠⣄⣍⢻⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣸⣿⣄⣀⣀⠀⠈⣿⣿⠀⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⢛⡛⠉⠉⠛⣿⣿⠀⢿⡇⠀⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⠃⠄⠁⠀⠀⠀⣿⣿⠀⢸⣧⠀⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⠃⠀⠀⠀⠀⠀⠀⣿⣿⠀⣽⣿⠀⣿⡟⠋⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⡟⢰⠂⠀⠀⠀⠀⢰⣿⡇⠀⠊⣿⡆⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⠁⠀⠀⠀⠀⠀⠀⣸⣿⠃⠀⢸⣿⡇⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡟⠙⠀⠀⠄⠀⠀⢠⣿⡟⠀⠀⣸⣿⣷⠈⣿⠀⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣶⣦⣤⣤⣤⣠⣼⣿⠃⠀⠀⣿⡏⣿⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⢀⣴⡟⠉⠉⠛⠛⠿⠿⠿⠟⠁⠀⠀⠀⢻⡇⢸⣆⢿⡆⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⣠⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣧⠈⣿⡿⣷⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⢀⣼⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣦⣽⣿⣿⣄⡀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⢀⣾⡏⠀⠀⠀⠀⠀⠀⣠⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠉⠋⠛⠶⣦⣀⠀⠀
 * ⠀⠀⠠⢸⣿⢰⡇⠀⠀⠀⠀⣴⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣦⠀⠀⠘⢃⣆⣈⢻⣷⠀
 * ⠀⠀⠀⢸⣿⠘⠃⡄⠀⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⢟⣀⣠⣴⣾⠟⠏⣺⣿⡇
 * ⠀⠀⠀⠈⢿⣧⣀⡀⠀⠀⣸⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⣿⡿⠿⠛⠉⠉⢀⣤⣿⡿⠀
 * ⠀⢀⣠⣤⡴⠿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⣄⣠⣤⣴⣿⣿⠟⠉⠀⠀⠀⢀⣠⣶⣿⠿⠋⠀⠀
 * ⢰⣿⠛⣷⠦⠀⠀⣩⣿⠿⠛⠉⠉⠙⠛⠿⠿⠿⠛⠛⠉⠁⠀⢀⣀⣴⣶⡿⠟⠋⠁⠀⠀⠀⠀
 * ⠘⢿⣿⣦⣤⣄⣸⣿⣷⣄⡀⠀⠀⠀⠀⠀⠂⠀⠀⣀⣤⣴⣶⠿⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠉⠙⠻⠿⠿⠿⠟⠿⣿⣷⣶⣶⣶⣶⣾⡿⠿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
 *
 * ПИЗДЕЦ НАХУЙ БЛЯТЬ Я ЕБАЛ КАКАЯ ЖЕ ЗАЛУПА ПОЖАЛУЙСТА УБЕЙТЕ МЕНЯ НАХУЙ⠀
 */

public class CopperKettleRecipe implements Recipe<RecipeInput> {

    private final Identifier id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public CopperKettleRecipe(Identifier id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public RecipeType<?> getType() {
        return BBRecipeTypes.TEA_KETTLE_RECIPE_TYPE.get();
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        return true;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BBRecipeSerializer.TEA_KETTLE_RECIPE.get();
    }

    @Override
    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean matches(RecipeInput recipeInput, World world) {
            if (world.isClient) { //???
                return false;
            }

            return recipeItems.stream().allMatch(ingredient -> {
                for (int i = 0; i < recipeInput.size(); i++) {
                    if (ingredient.test(recipeInput.getItem(i))) {
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
    public NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    public static class Type implements RecipeType<CopperKettleRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "brewing";
    }

    public class Serializer implements RecipeSerializer<CopperKettleRecipe> {
        public final Serializer INSTANCE = new Serializer();
        public static final String ID = "brewing";

        //TODO
        @Override
        public MapCodec<CopperKettleRecipe> codec() {
            return null;
        }
        //TODO
        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CopperKettleRecipe> streamCodec() {
            return null;
        }

        //doesnt exist
        @Override
        public @NotNull CopperKettleRecipe fromJson(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

            for (int j = 0; j < inputs.size(); j++) {
                inputs.set(j, Ingredient.fromJson(ingredients.get(j)));
            }
            return new CopperKettleRecipe(id, output, inputs);
        }

        //doesnt exist
        @Override
        public @Nullable CopperKettleRecipe fromNetwork(Identifier id, FriendlyByteBuf buf) {
            int i = buf.readInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(i, Ingredient.EMPTY);

            inputs.replaceAll(ignored -> Ingredient.fromNetwork(buf));

            ItemStack output = buf.readItem();
            return new CopperKettleRecipe(id, output, inputs);
        }

        //doesnt exist
        @Override
        public void toNetwork(PacketByteBuf buf, CopperKettleRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buf);
            }

            buf.writeItem(recipe.getResultItem(null));
        }
    }
}
