package net.yirmiri.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class BBEnUsLangGen extends FabricLanguageProvider {
    public BBEnUsLangGen(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        //ITEM GROUPS
        builder.add("itemgroup.bitter_brews", "Bitter Brews");
    }
}
