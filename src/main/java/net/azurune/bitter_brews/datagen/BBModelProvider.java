package net.azurune.bitter_brews.datagen;

import net.azurune.bitter_brews.registry.RegisterDrinkItems;
import net.azurune.bitter_brews.registry.RegisterItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class BBModelProvider extends FabricModelProvider {
    public BBModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(RegisterItems.MUD_CUP, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_GREEN_TEA, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_HONEY_TEA, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_KELP_TEA, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_MANGO_TEA, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_FUDGE_SUNDAE, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_AZALEA_TEA, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_WATER, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_BLACK_TEA, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_CHOCOLATE_MILK, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_MILK, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_COFFEE, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_DARK_COFFEE, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_ESPRESSO, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_HOT_COCOA, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_ICED_TEA, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_JASMINE_TEA, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.PEPPER, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.SOUL_PEPPER, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.TEA_LEAVES, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.DRIED_TEA_LEAVES, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.COFFEE_BEANS, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.MANGO, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.PEPPER_SEEDS, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.SOUL_PEPPER_SEEDS, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_MELON_JUICE, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_SWEET_BERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_GLOW_BERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_CRIMSON_TEA, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_WARPED_TEA, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_SHROOMLIGHT_TEA, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_CHORUS_JUICE, Models.GENERATED);
        itemModelGenerator.register(RegisterDrinkItems.CUP_OF_LIGHTNING, Models.GENERATED);
    }
}
