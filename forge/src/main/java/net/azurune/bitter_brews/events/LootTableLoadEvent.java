package net.azurune.bitter_brews.events;

import net.azurune.bitter_brews.BitterBrewsConstants;
import net.azurune.bitter_brews.core.registry.BBBlocks;
import net.azurune.bitter_brews.core.registry.BBItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BitterBrewsConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LootTableLoadEvent extends net.minecraftforge.event.LootTableLoadEvent {
    public LootTableLoadEvent(ResourceLocation name, LootTable table) {
        super(name, table);
    }

    //MINECRAFT
    private static final ResourceLocation PIGLIN_BARTERING = new ResourceLocation("gameplay/piglin_bartering");
    private static final ResourceLocation AZALEA_LEAVES = new ResourceLocation("blocks/azalea_leaves");
    private static final ResourceLocation FLOWERING_AZALEA_LEAVES = new ResourceLocation("blocks/flowering_azalea_leaves");
    private static final ResourceLocation JUNGLE_LEAVES = new ResourceLocation("blocks/jungle_leaves");
    private static final ResourceLocation BASTION_TREASURE = new ResourceLocation("chests/bastion_treasure");
    private static final ResourceLocation BASTION_OTHER = new ResourceLocation("chests/bastion_other");

    @SubscribeEvent
    public void lootLoad(LootTableLoadEvent evt) {
        if (evt.getName().equals(PIGLIN_BARTERING)) {
            //PEPPER
            evt.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.15F)).add(LootItem.lootTableItem(BBItems.PEPPER.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))).build());
        }

        if (evt.getName().equals(PIGLIN_BARTERING)) {
            //CRIMSON TEA
            evt.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.05F)).add(LootItem.lootTableItem(BBItems.CUP_OF_CRIMSON_TEA.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))).build());
        }

        if (evt.getName().equals(AZALEA_LEAVES)) {
            //TEA LEAVES
            evt.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.05F)).add(LootItem.lootTableItem(BBItems.TEA_LEAVES.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))).build());
        }

        if (evt.getName().equals(FLOWERING_AZALEA_LEAVES)) {
            //TEA LEAVES
            evt.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.025F)).add(LootItem.lootTableItem(BBItems.TEA_LEAVES.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))).build());
        }

        if (evt.getName().equals(FLOWERING_AZALEA_LEAVES)) {
            //AZALEA FLOWER
            evt.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.025F)).add(LootItem.lootTableItem(BBBlocks.AZALEA_FLOWER.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))).build());
        }

        if (evt.getName().equals(JUNGLE_LEAVES)) {
            //MANGO
            evt.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.025F)).add(LootItem.lootTableItem(BBItems.MANGO.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))).build());
        }

        if (evt.getName().equals(BASTION_OTHER)) {
            //PEPPER SEEDS
            evt.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.1F)).add(LootItem.lootTableItem(BBItems.PEPPER_SEEDS.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6))).build());

            //SOUL PEPPER SEEDS
            evt.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.05F)).add(LootItem.lootTableItem(BBItems.SOUL_PEPPER_SEEDS.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).build());
        }

        if (evt.getName().equals(BASTION_TREASURE)) {
            //SOUL PEPPER SEEDS
            evt.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(1.0F)).add(LootItem.lootTableItem(BBItems.SOUL_PEPPER_SEEDS.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))).build());
        }
    }
}
