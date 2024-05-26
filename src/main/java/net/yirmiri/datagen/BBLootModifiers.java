package net.yirmiri.datagen;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.yirmiri.register.BBBlocks;
import net.yirmiri.register.BBItems;

public class BBLootModifiers {

    //MINECRAFT
    private static final Identifier PIGLIN_BARTERING = new Identifier("gameplay/piglin_bartering");
    private static final Identifier AZALEA_LEAVES = new Identifier("blocks/azalea_leaves");
    private static final Identifier FLOWERING_AZALEA_LEAVES = new Identifier("blocks/flowering_azalea_leaves");
    private static final Identifier JUNGLE_LEAVES = new Identifier("blocks/jungle_leaves");
    private static final Identifier BASTION_TREASURE = new Identifier("chests/bastion_treasure");
    private static final Identifier BASTION_OTHER = new Identifier("chests/bastion_other");

    public static void modifyLoot() {
        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (PIGLIN_BARTERING.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.3F)).with(ItemEntry.builder(BBItems.PEPPER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 4)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (AZALEA_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.2F)).with(ItemEntry.builder(BBItems.TEA_LEAVES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (FLOWERING_AZALEA_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.1F)).with(ItemEntry.builder(BBItems.TEA_LEAVES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (FLOWERING_AZALEA_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.1F)).with(ItemEntry.builder(BBBlocks.AZALEA_FLOWER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (JUNGLE_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.2F)).with(ItemEntry.builder(BBItems.MANGO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (BASTION_OTHER.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.2F)).with(ItemEntry.builder(BBItems.SOUL_PEPPER_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (BASTION_OTHER.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(0.3F)).with(ItemEntry.builder(BBItems.PEPPER_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 6)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (BASTION_TREASURE.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder().conditionally(RandomChanceLootCondition.builder(1.0F)).with(ItemEntry.builder(BBItems.SOUL_PEPPER_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 4)).build());
                builder.pool(poolBuilder.build());
            }
        });
    }
}