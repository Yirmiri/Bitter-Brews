package net.yirmiri.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.yirmiri.BitterBrews;

import java.util.concurrent.CompletableFuture;

public class BBItemTagGen extends FabricTagProvider.ItemTagProvider {
    public BBItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //getOrCreateTagBuilder(ItemTags.PLANKS)
                //.add(AUBlocks.GLOOM_PLANKS.asItem())
        //;
    }

    private static TagKey<Item> create(String name) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(BitterBrews.MODID, name));
    }
}
