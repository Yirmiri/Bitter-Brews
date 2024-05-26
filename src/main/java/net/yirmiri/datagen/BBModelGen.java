package net.yirmiri.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.yirmiri.register.BBItems;

public class BBModelGen extends FabricModelProvider {
    public BBModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(BBItems.MUD_CUP, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_GREEN_TEA, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_HONEY_TEA, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_KELP_TEA, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_MANGO_TEA, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_FUDGE_SUNDAE, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_AZALEA_TEA, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_WATER, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_BLACK_TEA, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_CHOCOLATE_MILK, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_MILK, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_COFFEE, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_DARK_COFFEE, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_ESPRESSO, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_HOT_COCOA, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_ICED_TEA, Models.GENERATED);
        itemModelGenerator.register(BBItems.CUP_OF_JASMINE_TEA, Models.GENERATED);
    }
}