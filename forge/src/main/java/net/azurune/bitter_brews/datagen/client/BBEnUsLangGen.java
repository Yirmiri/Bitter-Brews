package net.azurune.bitter_brews.datagen.client;

import net.azurune.bitter_brews.core.registry.BBBlocks;
import net.azurune.bitter_brews.core.registry.BBItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class BBEnUsLangGen extends LanguageProvider {
    public BBEnUsLangGen(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        //BLOCKS
        add(BBBlocks.MUD_STOVE.get(), "Mud Stove");
        add(BBBlocks.MUD_COUNTER.get(), "Mud Counter");
        add(BBBlocks.AZALEA_FLOWER.get(), "Azalea Flower");
        add(BBBlocks.COFFEE_BUSH.get(), "Coffee Bush");
        add(BBBlocks.COPPER_TEA_KETTLE.get(), "Tea Kettle");

        //ITEMS
        add(BBItems.MUD_CUP.get(), "Mud Cup");
        add(BBItems.CUP_OF_WATER.get(), "Cup of Water");
        add(BBItems.CUP_OF_GREEN_TEA.get(), "Cup of Green Tea");
        add(BBItems.CUP_OF_HONEY_TEA.get(), "Cup of Honey Tea");
        add(BBItems.CUP_OF_KELP_TEA.get(), "Cup of Kelp Tea");
        add(BBItems.CUP_OF_MANGO_TEA.get(), "Cup of Mango Tea");
        add(BBItems.CUP_OF_FUDGE_SUNDAE.get(), "Cup of Fudge Sundae");
        add(BBItems.CUP_OF_AZALEA_TEA.get(), "Cup of Azalea Tea");
        add(BBItems.CUP_OF_BLACK_TEA.get(), "Cup of Black Tea");
        add(BBItems.CUP_OF_HOT_COCOA.get(), "Cup of Hot Cocoa");
        add(BBItems.CUP_OF_CHOCOLATE_MILK.get(), "Cup of Chocolate Milk");
        add(BBItems.CUP_OF_MILK.get(), "Cup of Milk");
        add(BBItems.CUP_OF_ESPRESSO.get(), "Cup of Espresso");
        add(BBItems.CUP_OF_COFFEE.get(), "Cup of Coffee");
        add(BBItems.CUP_OF_DARK_COFFEE.get(), "Cup of Dark Coffee");
        add(BBItems.CUP_OF_ICED_TEA.get(), "Cup of Iced Tea");
        add(BBItems.CUP_OF_JASMINE_TEA.get(), "Cup of Jasmine Tea");
        add(BBItems.TEA_LEAVES.get(), "Tea Leaves");
        add(BBItems.DRIED_TEA_LEAVES.get(), "Dried Tea Leaves");
        add(BBItems.COFFEE_BEANS.get(), "Coffee Beans");
        add(BBItems.PEPPER.get(), "Pepper");
        add(BBItems.SOUL_PEPPER.get(), "Soul Pepper");
        add(BBItems.MANGO.get(), "Mango");
        add(BBItems.PEPPER_SEEDS.get(), "Pepper Seeds");
        add(BBItems.SOUL_PEPPER_SEEDS.get(), "Soul Pepper Seeds");
        add(BBItems.CUP_OF_MELON_JUICE.get(), "Cup of Melon Juice");
        add(BBItems.CUP_OF_SWEET_BERRY_JUICE.get(), "Cup of Sweet Berry Juice");
        add(BBItems.CUP_OF_GLOW_BERRY_JUICE.get(), "Cup of Glow Berry Juice");
        add(BBItems.CUP_OF_CRIMSON_TEA.get(), "Cup of Weeping Tea");
        add(BBItems.CUP_OF_WARPED_TEA.get(), "Cup of Twisting Tea");
        add(BBItems.CUP_OF_SHROOMLIGHT_TEA.get(), "Cup of Shroomlight Tea");
        add(BBItems.CUP_OF_CHORUS_JUICE.get(), "Cup of Chorus Juice");
        add(BBItems.CUP_OF_LIGHTNING.get(), "Cup of Lightning");

        //TOOLTIPS
        add("bitter_brews.tooltip.soul_pepper", "You might wanna bring a cup of milk.");
        add("bitter_brews.tooltip.cup_of_green_tea", "A sweet earthly brew that soothes you.");
        add("bitter_brews.tooltip.cup_of_azalea_tea", "A sweet blooming brew that soothes you");
        add("bitter_brews.tooltip.cup_of_honey_tea", "Honey the tea is ready!");
        add("bitter_brews.tooltip.cup_of_kelp_tea", "I chose coral fans instead of normal coral for the recipe on purpose.");
        add("bitter_brews.tooltip.cup_of_mango_tea", "A mango a day keeps the doctor away.");
        add("bitter_brews.tooltip.cup_of_fudge_sundae", "This isn't fudge sundae, is it?");
        add("bitter_brews.tooltip.cup_of_black_tea", "Black tea makes great rocket fuel.");
        add("bitter_brews.tooltip.cup_of_hot_cocoa", "Not to be confused with chocolate milk.");
        add("bitter_brews.tooltip.cup_of_chocolate_milk", "Not to be confused with hot cocoa.");
        add("bitter_brews.tooltip.cup_of_espresso", "Fit for a §6Queen!");
        add("bitter_brews.tooltip.cup_of_coffee", "Hello darkness my old friend.");
        add("bitter_brews.tooltip.cup_of_dark_coffee", "You might need a backup cup.");
        add("bitter_brews.tooltip.cup_of_iced_tea", "Tastes like perfection.");
        add("bitter_brews.tooltip.cup_of_jasmine_tea", "A calming brew that could put you to sleep.");
        add("bitter_brews.tooltip.cup_of_melon_juice", "A bitter brew that is great for a hot summer day.");
        add("bitter_brews.tooltip.cup_of_sweet_berry_juice", "At least you won't accidentally place this one.");
        add("bitter_brews.tooltip.cup_of_glow_berry_juice", "Glow and behold!");
        add("bitter_brews.tooltip.cup_of_crimson_tea", "A common refreshment enjoyed among piglin.");
        add("bitter_brews.tooltip.cup_of_warped_tea", "It reeks a horrible smell into the air.");
        add("bitter_brews.tooltip.cup_of_shroomlight_tea", "A mixture of the Nether's delight!");
        add("bitter_brews.tooltip.cup_of_chorus_juice", "It smells of a familiar place...");
        add("bitter_brews.tooltip.cup_of_lightning", "Zeus told me to drink this 🤤🤤🤤");

        //ADVANCEMENTS
        add("advancements.husbandry.obtain_brew.title", "Bitter Brew");
        add("advancements.husbandry.obtain_brew.description", "Brew any bitter brew.");
        add("advancements.husbandry.place_kettle.title", "Spill The Tea");
        add("advancements.husbandry.place_kettle.description", "Place down a copper tea kettle and begin brewing!");
        add("advancements.nether.pepper.title", "Turning Up The Heat");
        add("advancements.nether.pepper.description", "Barter with a piglin for a pepper.");
        add("advancements.nether.soul_pepper.title", "Soul Pepper Challenge");
        add("advancements.nether.soul_pepper.description", "Venture into a bastion and grow a soul pepper- just be sure to have a cup of milk...");

        //STATS
        add("stat.minecraft.interact_with_kettle", "Interactions with Tea Kettle");

        //ITEM GROUPS
        add("itemgroup.bitter_brews", "Bitter Brews");

        //DAMAGE
        add("death.attack.bitter_brews.stove", "%1$s learnt it wasn't a good idea to play on the stove top");
        add("death.attack.bitter_brews.stove.player", "%1$s was cooked into a delicacy by %2$s");
        add("death.attack.bitter_brews.soul_pepper", "%1$s failed the soul pepper challenge");
        add("death.attack.bitter_brews.soul_pepper.player", "%1$s failed the soul pepper challenge to %2$s");
        add("death.attack.bitter_brews.coffee_bush", "%1$s was tangled and pricked to death by coffee bush");
        add("death.attack.bitter_brews.coffee_bush.player", "%1$s was forced into a prickly death to a coffee bush by %2$s");

        //JEI
        add("block.bitter_brews.tea_kettle", "Tea Kettle");
    }
}
