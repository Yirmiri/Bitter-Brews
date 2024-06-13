package net.azurune.bitter_brews.datagen.server.loot;

import net.azurune.bitter_brews.BitterBrewsConstants;
import net.azurune.bitter_brews.core.registry.BBBlocks;
import net.azurune.bitter_brews.core.registry.BBItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class BBGlobalLootModifiersGen extends GlobalLootModifierProvider {
    public BBGlobalLootModifiersGen(PackOutput output) {
        super(output, BitterBrewsConstants.MOD_ID);
    }

    //MINECRAFT
    private static final ResourceLocation PIGLIN_BARTERING = new ResourceLocation("gameplay/piglin_bartering");
    private static final ResourceLocation AZALEA_LEAVES = new ResourceLocation("blocks/azalea_leaves");
    private static final ResourceLocation FLOWERING_AZALEA_LEAVES = new ResourceLocation("blocks/flowering_azalea_leaves");
    private static final ResourceLocation JUNGLE_LEAVES = new ResourceLocation("blocks/jungle_leaves");
    private static final ResourceLocation BASTION_TREASURE = new ResourceLocation("chests/bastion_treasure");
    private static final ResourceLocation BASTION_OTHER = new ResourceLocation("chests/bastion_other");

    @Override
    protected void start() {
        add("pepper_from_bartering", new AddLootModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(PIGLIN_BARTERING).build(), LootItemRandomChanceCondition.randomChance(0.15f).build()
        }, BBItems.PEPPER.get(), 2, 3));

        add("crimson_tea_from_bartering", new AddLootModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(PIGLIN_BARTERING).build(), LootItemRandomChanceCondition.randomChance(0.05f).build()
        }, BBItems.CUP_OF_CRIMSON_TEA.get(), 1, 1));

        add("tea_leaves_from_azalea_leaves", new AddLootModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(AZALEA_LEAVES).build(), LootItemRandomChanceCondition.randomChance(0.05f).build()
        }, BBItems.TEA_LEAVES.get(), 1, 1));

        add("tea_leaves_from_flowering_azalea_leaves", new AddLootModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(FLOWERING_AZALEA_LEAVES).build(), LootItemRandomChanceCondition.randomChance(0.05f).build()
        }, BBItems.TEA_LEAVES.get(), 1, 1));

        add("azalea_flower_from_azalea_leaves", new AddLootModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(FLOWERING_AZALEA_LEAVES).build(), LootItemRandomChanceCondition.randomChance(0.069f).build()
        }, BBBlocks.AZALEA_FLOWER.get().asItem(), 1, 1));

        add("mango_from_jungle_leaves", new AddLootModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(JUNGLE_LEAVES).build(), LootItemRandomChanceCondition.randomChance(0.2f).build()
        }, BBItems.MANGO.get(), 1, 1));

        add("pepper_seeds_from_bastion_other", new AddLootModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BASTION_OTHER).build(), LootItemRandomChanceCondition.randomChance(0.05f).build()
        }, BBItems.PEPPER_SEEDS.get(), 2, 4));

        add("soul_pepper_seeds_from_bastion_other", new AddLootModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BASTION_OTHER).build(), LootItemRandomChanceCondition.randomChance(0.02f).build()
        }, BBItems.SOUL_PEPPER_SEEDS.get(), 1, 2));

        add("soul_pepper_seeds_from_bastion_treasure", new AddLootModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BASTION_TREASURE).build(), LootItemRandomChanceCondition.randomChance(1.0f).build()
        }, BBItems.SOUL_PEPPER_SEEDS.get(), 2, 3));
    }
}
