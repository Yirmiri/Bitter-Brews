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
            //PEPPER
            if (PIGLIN_BARTERING.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.15F)).add(LootItem.lootTableItem(BBItems.PEPPER.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            //CRIMSON TEA
            if (PIGLIN_BARTERING.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.05F)).add(LootItem.lootTableItem(BBItems.CUP_OF_CRIMSON_TEA.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            //TEA LEAVES
            if (AZALEA_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.05F)).add(LootItem.lootTableItem(BBItems.TEA_LEAVES.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            //TEA LEAVES
            if (FLOWERING_AZALEA_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.05F)).add(LootItem.lootTableItem(BBItems.TEA_LEAVES.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            //AZALEA FLOWER
            if (FLOWERING_AZALEA_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.069F)).add(LootItem.lootTableItem(BBBlocks.AZALEA_FLOWER.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            //MANGO
            if (JUNGLE_LEAVES.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.02F)).add(LootItem.lootTableItem(BBItems.MANGO.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            //PEPPER SEEDS
            if (BASTION_OTHER.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.05F)).add(LootItem.lootTableItem(BBItems.PEPPER_SEEDS.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)).build());
                builder.pool(poolBuilder.build());
            }

            //SOUL PEPPER SEEDS
            if (BASTION_OTHER.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.02F)).add(LootItem.lootTableItem(BBItems.SOUL_PEPPER_SEEDS.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)).build());
                builder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            //SOUL PEPPER SEEDS
            if (BASTION_TREASURE.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(1.0F)).add(LootItem.lootTableItem(BBItems.SOUL_PEPPER_SEEDS.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3)).build());
                builder.pool(poolBuilder.build());
            }
        });
    }
}
