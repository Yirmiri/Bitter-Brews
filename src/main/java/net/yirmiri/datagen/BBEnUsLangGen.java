package net.yirmiri.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.yirmiri.register.BBBlocks;

public class BBEnUsLangGen extends FabricLanguageProvider {
    public BBEnUsLangGen(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        //BLOCKS
        builder.add(BBBlocks.MUD_STOVE, "Mud Stove");

        //ITEM GROUPS
        builder.add("itemgroup.bitter_brews", "Bitter Brews");

        //DAMAGE
        builder.add("death.attack.bitter_brews.stove", "%1$s was cooked sunny side up");
        builder.add("death.attack.bitter_brews.stove.player", "%2$s watched %1$s be cooked sunny side up");
    }
}