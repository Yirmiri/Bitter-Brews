package net.yirmiri.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.yirmiri.register.BBBlocks;
import net.yirmiri.register.BBItems;

public class BBEnUsLangGen extends FabricLanguageProvider {
    public BBEnUsLangGen(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        //BLOCKS
        builder.add(BBBlocks.MUD_STOVE, "Mud Stove");
        builder.add(BBBlocks.MUD_COUNTER, "Mud Counter");
        builder.add(BBBlocks.AZALEA_FLOWER, "Azalea Flower");

        //ITEMS
        builder.add(BBItems.MUD_CUP, "Mud Cup");
        builder.add(BBItems.CUP_OF_WATER, "Cup of Water");
        builder.add(BBItems.CUP_OF_GREEN_TEA, "Cup of Green Tea");
        builder.add(BBItems.CUP_OF_HONEY_TEA, "Cup of Honey Tea");
        builder.add(BBItems.CUP_OF_KELP_TEA, "Cup of Kelp Tea");
        builder.add(BBItems.CUP_OF_MANGO_TEA, "Cup of Mango Tea");
        builder.add(BBItems.CUP_OF_FUDGE_SUNDAE, "Cup of Fudge Sundae");
        builder.add(BBItems.CUP_OF_AZALEA_TEA, "Cup of Azalea Tea");
        builder.add(BBItems.CUP_OF_BLACK_TEA, "Cup of Black Tea");
        builder.add(BBItems.CUP_OF_HOT_COCOA, "Cup of Hot Cocoa");
        builder.add(BBItems.CUP_OF_CHOCOLATE_MILK, "Cup of Chocolate Milk");
        builder.add(BBItems.CUP_OF_MILK, "Cup of Milk");
        builder.add(BBItems.CUP_OF_ESPRESSO, "Cup of Espresso");
        builder.add(BBItems.CUP_OF_COFFEE, "Cup of Coffee");
        builder.add(BBItems.CUP_OF_DARK_COFFEE, "Cup of Dark Coffee");
        builder.add(BBItems.CUP_OF_ICED_TEA, "Cup of Iced Tea");
        builder.add(BBItems.CUP_OF_JASMINE_TEA, "Cup of Jasmine Tea");
        builder.add(BBItems.TEA_LEAVES, "Tea Leaves");
        builder.add(BBItems.DRIED_TEA_LEAVES, "Dried Tea Leaves");
        builder.add(BBItems.COFFEE_BEANS, "Coffee Beans");
        builder.add(BBItems.PEPPER, "Pepper");
        builder.add(BBItems.SOUL_PEPPER, "Soul Pepper");
        builder.add(BBItems.MANGO, "Mango");
        builder.add(BBItems.PEPPER_SEEDS, "Pepper Seeds");
        builder.add(BBItems.SOUL_PEPPER_SEEDS, "Soul Pepper Seeds");

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

        //ITEM GROUPS
        builder.add("itemgroup.bitter_brews", "Bitter Brews");

        //DAMAGE
        builder.add("death.attack.bitter_brews.stove", "%1$s learnt it wasn't a good idea to play on the stove top");
        builder.add("death.attack.bitter_brews.stove.player", "%1$s was cooked into a delicacy by %2$s");
        builder.add("death.attack.bitter_brews.soul_pepper", "%1$s failed the soul pepper challenge");
        builder.add("death.attack.bitter_brews.soul_pepper.player", "%1$s failed the soul pepper challenge to %2$s");
    }
}