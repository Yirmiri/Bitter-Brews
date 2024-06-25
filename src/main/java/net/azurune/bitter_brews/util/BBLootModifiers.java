package net.azurune.bitter_brews.util;

import net.azurune.bitter_brews.registry.RegisterBlocks;
import net.azurune.bitter_brews.registry.RegisterDrinkItems;
import net.azurune.bitter_brews.registry.RegisterItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class BBLootModifiers {
    //MINECRAFT
    private static final Identifier PIGLIN_BARTERING = Identifier.ofVanilla("gameplay/piglin_bartering");
    private static final Identifier AZALEA_LEAVES = Identifier.ofVanilla("blocks/azalea_leaves");
    private static final Identifier FLOWERING_AZALEA_LEAVES = Identifier.ofVanilla("blocks/flowering_azalea_leaves");
    private static final Identifier JUNGLE_LEAVES = Identifier.ofVanilla("blocks/jungle_leaves");
    private static final Identifier BASTION_TREASURE = Identifier.ofVanilla("chests/bastion_treasure");
    private static final Identifier BASTION_OTHER = Identifier.ofVanilla("chests/bastion_other");

    public static void modifyLoot() {
        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (PIGLIN_BARTERING.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.15F)).with(ItemEntry.builder(RegisterItems.PEPPER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 3)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (PIGLIN_BARTERING.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.05F)).with(ItemEntry.builder(RegisterDrinkItems.CUP_OF_CRIMSON_TEA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (AZALEA_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.05F)).with(ItemEntry.builder(RegisterItems.TEA_LEAVES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (FLOWERING_AZALEA_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.05F)).with(ItemEntry.builder(RegisterItems.TEA_LEAVES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (FLOWERING_AZALEA_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.05F)).with(ItemEntry.builder(RegisterBlocks.AZALEA_FLOWER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (JUNGLE_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.025F)).with(ItemEntry.builder(RegisterItems.MANGO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (BASTION_OTHER.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.1F)).with(ItemEntry.builder(RegisterItems.SOUL_PEPPER_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 6)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (BASTION_OTHER.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.5F)).with(ItemEntry.builder(RegisterItems.PEPPER_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (BASTION_TREASURE.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(1.0F)).with(ItemEntry.builder(RegisterItems.SOUL_PEPPER_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 4)).build());
                builder.pool(poolBuilder.build());
            }
        });
    }
}
