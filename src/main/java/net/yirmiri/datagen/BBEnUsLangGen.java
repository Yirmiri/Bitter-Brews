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

        //ITEMS
        builder.add(BBItems.MUD_CUP, "Mud Cup");
        builder.add(BBItems.CUP_OF_WATER, "Cup of Water");
        builder.add(BBItems.CUP_OF_GREEN_TEA, "Cup of Green Tea");
        builder.add(BBItems.CUP_OF_HONEY_TEA, "Cup of Honey Tea");
        builder.add(BBItems.CUP_OF_KELP_TEA, "Cup of Kelp Tea");
        builder.add(BBItems.CUP_OF_MANGO_TEA, "Cup of Mango Tea");
        builder.add(BBItems.CUP_OF_FUDGE_SUNDAE, "Cup of Fudge Sundae");
        builder.add(BBItems.CUP_OF_AZALEA_TEA, "Cup of Azalea Tea");

        //TOOLTIPS
        builder.add("bitter_brews.tooltip.cup_of_green_tea", "A sweet earthly brew that soothes you.");
        builder.add("bitter_brews.tooltip.cup_of_azalea_tea", "A sweet blooming brew that soothes you");
        builder.add("bitter_brews.tooltip.cup_of_honey_tea", "Honey the tea is ready!");
        builder.add("bitter_brews.tooltip.cup_of_kelp_tea", "I chose coral fans instead of normal coral for the recipe on purpose.");
        builder.add("bitter_brews.tooltip.cup_of_mango_tea", "A mango a day keeps the doctor away.");
        builder.add("bitter_brews.tooltip.cup_of_fudge_sundae", "This isn't fudge sundae, is it?");

        //ITEM GROUPS
        builder.add("itemgroup.bitter_brews", "Bitter Brews");

        //DAMAGE
        builder.add("death.attack.bitter_brews.stove", "%1$s was cooked sunny side up");
        builder.add("death.attack.bitter_brews.stove.player", "%2$s watched %1$s be cooked sunny side up");
    }
}