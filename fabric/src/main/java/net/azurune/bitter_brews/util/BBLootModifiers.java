package net.azurune.bitter_brews.util;

import net.azurune.bitter_brews.core.registry.BBBlocks;
import net.azurune.bitter_brews.core.registry.BBItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class BBLootModifiers {

    //MINECRAFT
    private static final ResourceLocation PIGLIN_BARTERING = new ResourceLocation("gameplay/piglin_bartering");
    private static final ResourceLocation AZALEA_LEAVES = new ResourceLocation("blocks/azalea_leaves");
    private static final ResourceLocation FLOWERING_AZALEA_LEAVES = new ResourceLocation("blocks/flowering_azalea_leaves");
    private static final ResourceLocation JUNGLE_LEAVES = new ResourceLocation("blocks/jungle_leaves");
    private static final ResourceLocation BASTION_TREASURE = new ResourceLocation("chests/bastion_treasure");
    private static final ResourceLocation BASTION_OTHER = new ResourceLocation("chests/bastion_other");

    public static void modifyLoot() {
        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (PIGLIN_BARTERING.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(BBItems.PEPPER.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (AZALEA_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(BBItems.TEA_LEAVES.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (FLOWERING_AZALEA_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.1F)).add(LootItem.lootTableItem(BBItems.TEA_LEAVES.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (FLOWERING_AZALEA_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.1F)).add(LootItem.lootTableItem(BBBlocks.AZALEA_FLOWER.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (JUNGLE_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(BBItems.MANGO.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (BASTION_OTHER.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(BBItems.SOUL_PEPPER_SEEDS.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (BASTION_OTHER.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(BBItems.PEPPER_SEEDS.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (BASTION_TREASURE.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(1.0F)).add(LootItem.lootTableItem(BBItems.SOUL_PEPPER_SEEDS.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)).build());
                builder.pool(poolBuilder.build());
            }
        });
    }
}
