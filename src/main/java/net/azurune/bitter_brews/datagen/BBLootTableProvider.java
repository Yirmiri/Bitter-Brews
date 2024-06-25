package net.azurune.bitter_brews.datagen;

import net.azurune.bitter_brews.registry.RegisterBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BBLootTableProvider extends FabricBlockLootTableProvider {
    public BBLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    public void generate() {
        addDrop(RegisterBlocks.MUD_STOVE);
        addDrop(RegisterBlocks.MUD_COUNTER);
        addDrop(RegisterBlocks.COPPER_KETTLE);
        addDrop(RegisterBlocks.COFFEE_BUSH);
    }
}
