package net.yirmiri.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.yirmiri.register.BBBlocks;

public class BBLootTableGen extends FabricBlockLootTableProvider {
    public BBLootTableGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        addDrop(BBBlocks.MUD_STOVE);
        addDrop(BBBlocks.MUD_COUNTER);
    }
}
