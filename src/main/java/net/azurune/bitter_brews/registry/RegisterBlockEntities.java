package net.azurune.bitter_brews.registry;

import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.block.block_entity.CopperKettleBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterBlockEntities {

    public static final BlockEntityType<CopperKettleBlockEntity> COPPER_KETTLE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(BitterBrews.MOD_ID, "copper_tea_kettle_block_entity"), FabricBlockEntityTypeBuilder.create(CopperKettleBlockEntity::new, RegisterBlocks.COPPER_KETTLE).build());

    public static void registerBlockEntities() {
    }
}
