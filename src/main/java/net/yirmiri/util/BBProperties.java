package net.yirmiri.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.yirmiri.block.SoulPepperCropBlock;
import net.yirmiri.block.StoveBlock;
import net.yirmiri.register.TLStatusEffects;

public class BBProperties {
    public static class BlockP {
        //MISC
        public static final Block.Settings MUD_STOVE = FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).mapColor(MapColor.DARK_RED).luminance((state) -> { return StoveBlock.burntOut(state) ? 6 : 15; });
        public static final Block.Settings MUD_COUNTER = FabricBlockSettings.copyOf(Blocks.MUD_BRICKS);
        public static final Block.Settings AZALEA_FLOWER = FabricBlockSettings.copyOf(Blocks.GLOW_LICHEN).luminance(0).sounds(BlockSoundGroup.WET_GRASS).mapColor(MapColor.DULL_PINK);
        public static final Block.Settings PEPPER_CROP = FabricBlockSettings.copyOf(Blocks.NETHER_WART).sounds(BlockSoundGroup.ROOTS).mapColor(MapColor.RED);
        public static final Block.Settings SOUL_PEPPER_CROP = FabricBlockSettings.copyOf(PEPPER_CROP).mapColor(MapColor.CYAN).luminance((state) -> { return SoulPepperCropBlock.mature(state) ? 0 : 7; });
        public static final Block.Settings COPPER_TEA_KETTLE = FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.LANTERN);
        public static final Block.Settings COFFEE_BUSH = FabricBlockSettings.copyOf(Blocks.WHEAT).sounds(BlockSoundGroup.WET_GRASS).mapColor(MapColor.DARK_GREEN);
    }

    public static class ItemP {
        public static final int BRIEF_DURATION = 300; //15s
        public static final int VERY_SHORT_DURATION = 600; //30s
        public static final int SHORT_DURATION = 1200; //1m
        public static final int AVERAGE_DURATION = 2400; //2m
        public static final int LONG_DURATION = 3600; //3m
        public static final int VERY_LONG_DURATION = 6000; //5m

        //MISC
        public static final Item.Settings GENERIC_ITEM = new FabricItemSettings();
        public static final Item.Settings DRIED_TEA_LEAVES = new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1F).build());
        public static final Item.Settings MANGO = new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4F).build());
        public static final Item.Settings PEPPER = new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).build());
        public static final Item.Settings SOUL_PEPPER = new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(TLStatusEffects.TRAIL_BLAZING, BRIEF_DURATION, 0), 1.0F).alwaysEdible().build());

        //DRINKS
        public static final Item.Settings MILK = new FabricItemSettings().maxCount(4);

        public static final Item.Settings GREEN_TEA = new FabricItemSettings().maxCount(4).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, BRIEF_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings AZALEA_TEA = new FabricItemSettings().maxCount(4).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, SHORT_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings HONEY_TEA = new FabricItemSettings().maxCount(2).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.BACKLASH, AVERAGE_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings KELP_TEA = new FabricItemSettings().maxCount(6).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.WATER_WALKING, VERY_LONG_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings MANGO_TEA = new FabricItemSettings().maxCount(2).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.STEEL_FEET, LONG_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings BLACK_TEA = new FabricItemSettings().maxCount(4).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.LAVA_WALKING, VERY_LONG_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings CHOCOLATE_MILK = new FabricItemSettings().maxCount(1).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.CHRONOS, LONG_DURATION, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.VULNERABILITY, LONG_DURATION, 3), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings HOT_COCOA = new FabricItemSettings().maxCount(4).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.BURNING_THORNS, AVERAGE_DURATION, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.IMPURE, AVERAGE_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings COFFEE = new FabricItemSettings().maxCount(2).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, AVERAGE_DURATION, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.LESSER_WEAKNESS, AVERAGE_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings DARK_COFFEE = new FabricItemSettings().maxCount(2).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, AVERAGE_DURATION, 2), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.LESSER_WEAKNESS, AVERAGE_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings ESPRESSO = new FabricItemSettings().maxCount(1).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.BERSERK, LONG_DURATION, 2), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.SHATTERSPLEEN, LONG_DURATION, 1), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings ICED_TEA = new FabricItemSettings().maxCount(1).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.HEARTBREAK, LONG_DURATION, 9), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.LESSER_STRENGTH, LONG_DURATION, 7), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings JASMINE_TEA = new FabricItemSettings().maxCount(1).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.CONFUSION, AVERAGE_DURATION, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.INACCURATE, AVERAGE_DURATION, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.DIVERSION, AVERAGE_DURATION, 0), 1.0F)
                .alwaysEdible().build());
    }
}
