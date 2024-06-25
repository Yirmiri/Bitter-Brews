package net.azurune.bitter_brews.datagen;

import net.azurune.bitter_brews.registry.RegisterBlocks;
import net.azurune.bitter_brews.registry.RegisterDrinkItems;
import net.azurune.bitter_brews.registry.RegisterItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BBLangProvider extends FabricLanguageProvider {
    public BBLangProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(dataGenerator, "en_us", future);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder builder) {
        //BLOCKS
        builder.add(RegisterBlocks.MUD_STOVE, "Mud Stove");
        builder.add(RegisterBlocks.MUD_COUNTER, "Mud Counter");
        builder.add(RegisterBlocks.AZALEA_FLOWER, "Azalea Flower");
        builder.add(RegisterBlocks.COFFEE_BUSH, "Coffee Bush");
        builder.add(RegisterBlocks.COPPER_KETTLE, "Copper Kettle");

        //DRINKS
        builder.add(RegisterItems.MUD_CUP, "Mud Cup");
        builder.add(RegisterDrinkItems.CUP_OF_WATER, "Cup of Water");
        builder.add(RegisterDrinkItems.CUP_OF_GREEN_TEA, "Cup of Green Tea");
        builder.add(RegisterDrinkItems.CUP_OF_HONEY_TEA, "Cup of Honey Tea");
        builder.add(RegisterDrinkItems.CUP_OF_KELP_TEA, "Cup of Kelp Tea");
        builder.add(RegisterDrinkItems.CUP_OF_MANGO_TEA, "Cup of Mango Tea");
        builder.add(RegisterDrinkItems.CUP_OF_FUDGE_SUNDAE, "Cup of Fudge Sundae");
        builder.add(RegisterDrinkItems.CUP_OF_AZALEA_TEA, "Cup of Azalea Tea");
        builder.add(RegisterDrinkItems.CUP_OF_BLACK_TEA, "Cup of Black Tea");
        builder.add(RegisterDrinkItems.CUP_OF_HOT_COCOA, "Cup of Hot Cocoa");
        builder.add(RegisterDrinkItems.CUP_OF_CHOCOLATE_MILK, "Cup of Chocolate Milk");
        builder.add(RegisterDrinkItems.CUP_OF_MILK, "Cup of Milk");
        builder.add(RegisterDrinkItems.CUP_OF_ESPRESSO, "Cup of Espresso");
        builder.add(RegisterDrinkItems.CUP_OF_COFFEE, "Cup of Coffee");
        builder.add(RegisterDrinkItems.CUP_OF_DARK_COFFEE, "Cup of Dark Coffee");
        builder.add(RegisterDrinkItems.CUP_OF_ICED_TEA, "Cup of Iced Tea");
        builder.add(RegisterDrinkItems.CUP_OF_JASMINE_TEA, "Cup of Jasmine Tea");
        builder.add(RegisterDrinkItems.CUP_OF_MELON_JUICE, "Cup of Melon Juice");
        builder.add(RegisterDrinkItems.CUP_OF_SWEET_BERRY_JUICE, "Cup of Sweet Berry Juice");
        builder.add(RegisterDrinkItems.CUP_OF_GLOW_BERRY_JUICE, "Cup of Glow Berry Juice");
        builder.add(RegisterDrinkItems.CUP_OF_CRIMSON_TEA, "Cup of Weeping Tea");
        builder.add(RegisterDrinkItems.CUP_OF_WARPED_TEA, "Cup of Twisting Tea");
        builder.add(RegisterDrinkItems.CUP_OF_SHROOMLIGHT_TEA, "Cup of Shroomlight Tea");
        builder.add(RegisterDrinkItems.CUP_OF_CHORUS_JUICE, "Cup of Chorus Juice");
        builder.add(RegisterDrinkItems.CUP_OF_LIGHTNING, "Cup of Lightning");

        //ITEMS
        builder.add(RegisterItems.TEA_LEAVES, "Tea Leaves");
        builder.add(RegisterItems.DRIED_TEA_LEAVES, "Dried Tea Leaves");
        builder.add(RegisterItems.COFFEE_BEANS, "Coffee Beans");
        builder.add(RegisterItems.PEPPER, "Pepper");
        builder.add(RegisterItems.SOUL_PEPPER, "Soul Pepper");
        builder.add(RegisterItems.MANGO, "Mango");
        builder.add(RegisterItems.PEPPER_SEEDS, "Pepper Seeds");
        builder.add(RegisterItems.SOUL_PEPPER_SEEDS, "Soul Pepper Seeds");

        //TOOLTIPS
        builder.add("bitter_brews.tooltip.soul_pepper", "You might wanna bring a cup of milk.");
        builder.add("bitter_brews.tooltip.cup_of_green_tea", "A sweet earthly brew that soothes you.");
        builder.add("bitter_brews.tooltip.cup_of_azalea_tea", "A sweet blooming brew that soothes you");
        builder.add("bitter_brews.tooltip.cup_of_honey_tea", "Honey the tea is ready!");
        builder.add("bitter_brews.tooltip.cup_of_kelp_tea", "I chose coral fans instead of normal coral for the recipe on purpose.");
        builder.add("bitter_brews.tooltip.cup_of_mango_tea", "A mango a day keeps the doctor away.");
        builder.add("bitter_brews.tooltip.cup_of_fudge_sundae", "This isn't fudge sundae, is it?");
        builder.add("bitter_brews.tooltip.cup_of_black_tea", "Black tea makes great rocket fuel.");
        builder.add("bitter_brews.tooltip.cup_of_hot_cocoa", "Not to be confused with chocolate milk.");
        builder.add("bitter_brews.tooltip.cup_of_chocolate_milk", "Not to be confused with hot cocoa.");
        builder.add("bitter_brews.tooltip.cup_of_espresso", "Fit for a §6Queen!");
        builder.add("bitter_brews.tooltip.cup_of_coffee", "Hello darkness my old friend.");
        builder.add("bitter_brews.tooltip.cup_of_dark_coffee", "You might need a backup cup.");
        builder.add("bitter_brews.tooltip.cup_of_iced_tea", "Tastes like perfection.");
        builder.add("bitter_brews.tooltip.cup_of_jasmine_tea", "A calming brew that could put you to sleep.");
        builder.add("bitter_brews.tooltip.cup_of_melon_juice", "A bitter brew that is great for a hot summer day.");
        builder.add("bitter_brews.tooltip.cup_of_sweet_berry_juice", "At least you won't accidentally place this one.");
        builder.add("bitter_brews.tooltip.cup_of_glow_berry_juice", "Glow and behold!");
        builder.add("bitter_brews.tooltip.cup_of_crimson_tea", "A common refreshment enjoyed among piglin.");
        builder.add("bitter_brews.tooltip.cup_of_warped_tea", "It reeks a horrible smell into the air.");
        builder.add("bitter_brews.tooltip.cup_of_shroomlight_tea", "A mixture of the Nether's delight!");
        builder.add("bitter_brews.tooltip.cup_of_chorus_juice", "It smells of a familiar place...");
        builder.add("bitter_brews.tooltip.cup_of_lightning", "Zeus told me to drink this 🤤🤤🤤");

        //HUSBANDRY ADVANCEMENTS
        builder.add("advancements.husbandry.place_stove.title", "Turning Up The Heat");
        builder.add("advancements.husbandry.place_stove.description", "Place down a stove which can be used to heat a tea kettle.");
        builder.add("advancements.husbandry.place_kettle.title", "Spill The Tea");
        builder.add("advancements.husbandry.place_kettle.description", "Place down a tea kettle and begin brewing!");
        builder.add("advancements.husbandry.obtain_brew.title", "A Bitter Brew");
        builder.add("advancements.husbandry.obtain_brew.description", "Brew any bitter brew.");
        builder.add("advancements.husbandry.consume_all_brews.title", "Taste The Rainbow");
        builder.add("advancements.husbandry.consume_all_brews.description", "Consume all of the brews in Bitter Brews.");

        //NETHER ADVANCEMENTS
        builder.add("advancements.nether.nether_tea_kettle.title", "Unusual Cooking Strategies");
        builder.add("advancements.nether.nether_tea_kettle.description", "Use the Nether as a heating source for a tea kettle.");
        builder.add("advancements.nether.pepper.title", "Getting Spicy");
        builder.add("advancements.nether.pepper.description", "Barter with a piglin for a pepper.");
        builder.add("advancements.nether.soul_pepper.title", "Soul Pepper Challenge");
        builder.add("advancements.nether.soul_pepper.description", "Consume the flaming hot delight of the Nether- just be sure to have a cup of milk.");
        builder.add("advancements.nether.drink_lighting.title", "Death at 20,000 Volts");
        builder.add("advancements.nether.drink_lighting.description", "It probably wasn't so good of an idea to drink a cup of lightning huh?.");

        //ITEM GROUPS
        builder.add("itemgroup.ingredients", "Bitter Ingredients");
        builder.add("itemgroup.drinks", "Bitter Brews");

        //DAMAGE
        builder.add("death.attack.bitter_brews.stove", "%1$s learnt it wasn't a good idea to play on the stove top");
        builder.add("death.attack.bitter_brews.stove.player", "%1$s was cooked into a delicacy by %2$s");
        builder.add("death.attack.bitter_brews.soul_pepper", "%1$s failed the soul pepper challenge");
        builder.add("death.attack.bitter_brews.soul_pepper.player", "%1$s failed the soul pepper challenge to %2$s");
        builder.add("death.attack.bitter_brews.coffee_bush", "%1$s was tangled and pricked to death by coffee bush");
        builder.add("death.attack.bitter_brews.coffee_bush.player", "%1$s was forced into a prickly death to a coffee bush by %2$s");
    }
}
