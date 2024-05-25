package net.yirmiri;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.yirmiri.datagen.*;

public class BitterBrewsDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(BBEnUsLangGen::new);
        pack.addProvider(BBBlockTagGen::new);
        pack.addProvider(BBItemTagGen::new);
        pack.addProvider(BBLootTableGen::new);
        pack.addProvider(BBModelGen::new);
        pack.addProvider(BBRecipeGen::new);
    }
}
