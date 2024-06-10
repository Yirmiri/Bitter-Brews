package net.azurune.bitter_brews.common.util;

import net.azurune.bitter_brews.common.block.SoulPepperCropBlock;
import net.azurune.bitter_brews.common.block.StoveBlock;
import net.azurune.tipsylib.core.register.TLStatusEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class BBProperties {
    public static class BlockP {
        //MISC
        public static final BlockBehaviour.Properties MUD_STOVE = BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).mapColor(MapColor.TERRACOTTA_RED).lightLevel((state) -> { return StoveBlock.burntOut(state) ? 6 : 15; });
        public static final BlockBehaviour.Properties MUD_COUNTER = BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS);
        public static final BlockBehaviour.Properties AZALEA_FLOWER = BlockBehaviour.Properties.copy(Blocks.GLOW_LICHEN).lightLevel((state) -> 0).sound(SoundType.WET_GRASS).mapColor(MapColor.TERRACOTTA_PINK);
        public static final BlockBehaviour.Properties PEPPER_CROP = BlockBehaviour.Properties.copy(Blocks.NETHER_WART).sound(SoundType.ROOTS).mapColor(MapColor.COLOR_RED);
        public static final BlockBehaviour.Properties SOUL_PEPPER_CROP = BlockBehaviour.Properties.copy(Blocks.NETHER_WART).sound(SoundType.ROOTS).mapColor(MapColor.COLOR_CYAN).lightLevel((state) -> { return SoulPepperCropBlock.mature(state) ? 0 : 7; });
        public static final BlockBehaviour.Properties COPPER_TEA_KETTLE = BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).sound(SoundType.LANTERN);
        public static final BlockBehaviour.Properties COFFEE_BUSH = BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.WET_GRASS).mapColor(MapColor.TERRACOTTA_GREEN);
    }

    public static class ItemP {
        public static final int INSTANT = 6; //0.3s
        public static final int BRIEF_DURATION = 300; //15s
        public static final int VERY_SHORT_DURATION = 600; //30s
        public static final int SHORT_DURATION = 1200; //1m
        public static final int AVERAGE_DURATION = 2400; //2m
        public static final int LONG_DURATION = 3600; //3m
        public static final int VERY_LONG_DURATION = 6000; //5m

        //MISC
        public static final Item.Properties GENERIC_ITEM = new Item.Properties();
        public static final Item.Properties DRIED_TEA_LEAVES = new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build());
        public static final Item.Properties MANGO = new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).build());
        public static final Item.Properties PEPPER = new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, BRIEF_DURATION, 0), 1.0F).alwaysEat().build());
        public static final Item.Properties SOUL_PEPPER = new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).effect(new MobEffectInstance(TLStatusEffects.TRAIL_BLAZING, BRIEF_DURATION, 0), 1.0F).alwaysEat().build());

        //DRINKS
        public static final Item.Properties WATER = new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().alwaysEat().build());
        public static final Item.Properties MILK = new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().alwaysEat().build());

        public static final Item.Properties CHOCOLATE_MILK = new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.CHRONOS, AVERAGE_DURATION, 0), 1.0F)
                .effect(new MobEffectInstance(TLStatusEffects.VULNERABILITY, AVERAGE_DURATION, 5), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties MELON_JUICE = new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, BRIEF_DURATION, 0), 1.0F) //TODO: Improve with water speed effect (When TipsyLib 1.21 releases)
                .alwaysEat().build());

        public static final Item.Properties SWEET_BERRY_JUICE = new Item.Properties().stacksTo(2).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 2), 1.0F) //TODO: Improve with an effect that grants additional hp when healed
                .effect(new MobEffectInstance(MobEffects.CONFUSION, VERY_SHORT_DURATION, 2), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties GLOW_BERRY_JUICE = new Item.Properties().stacksTo(4).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.PERCEPTION, SHORT_DURATION, 0), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties CHORUS_JUICE = new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.TRAVERSAL, INSTANT, 0), 1.0F)
                .effect(new MobEffectInstance(MobEffects.CONFUSION, BRIEF_DURATION, 0), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties GREEN_TEA = new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.RESTORATION, SHORT_DURATION, 0), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties AZALEA_TEA = new Item.Properties().stacksTo(2).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, SHORT_DURATION, 0), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties BLACK_TEA = new Item.Properties().stacksTo(2).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(MobEffects.SATURATION, INSTANT, 0), 1.0F) //TODO: Improve with an effect that stops hunger (when TipsyLib updates)
                .alwaysEat().build());

        public static final Item.Properties ICED_TEA = new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.HEARTBREAK, SHORT_DURATION, 9), 1.0F)
                .effect(new MobEffectInstance(TLStatusEffects.LESSER_STRENGTH, SHORT_DURATION, 9), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties HONEY_TEA = new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.DEVOUR, AVERAGE_DURATION, 1), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties MANGO_TEA = new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.STEEL_FEET, AVERAGE_DURATION, 0), 1.0F)
                .effect(new MobEffectInstance(TLStatusEffects.VULNERABILITY, AVERAGE_DURATION, 1), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties KELP_TEA = new Item.Properties().stacksTo(6).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.WATER_WALKING, LONG_DURATION, 0), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties JASMINE_TEA = new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.PRECISION, AVERAGE_DURATION, 0), 1.0F)
                .effect(new MobEffectInstance(TLStatusEffects.LESSER_WEAKNESS, AVERAGE_DURATION, 1), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties CRIMSON_TEA = new Item.Properties().stacksTo(2).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.BURNING_THORNS, LONG_DURATION, 0), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties WARPED_TEA = new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.DIVERSION, SHORT_DURATION, 0), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties SHROOMLIGHT_TEA = new Item.Properties().stacksTo(6).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.LAVA_WALKING, LONG_DURATION, 0), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties COFFEE = new Item.Properties().stacksTo(4).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.ADRENALINE, AVERAGE_DURATION, 0), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties DARK_COFFEE = new Item.Properties().stacksTo(2).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(MobEffects.DIG_SPEED, AVERAGE_DURATION, 2), 1.0F)
                .effect(new MobEffectInstance(MobEffects.HUNGER, AVERAGE_DURATION, 0), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties ESPRESSO = new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.CAFFEINATED, SHORT_DURATION, 0), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties HOT_COCOA = new Item.Properties().stacksTo(2).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.BERSERK, AVERAGE_DURATION, 0), 1.0F)
                .alwaysEat().build());

        public static final Item.Properties FUDGE_SUNDAE = new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                .effect(new MobEffectInstance(TLStatusEffects.CONFUSION, VERY_LONG_DURATION, 0), 1.0F)
                .effect(new MobEffectInstance(MobEffects.CONFUSION, VERY_LONG_DURATION, 0), 1.0F)
                .effect(new MobEffectInstance(TLStatusEffects.LESSER_STRENGTH, VERY_LONG_DURATION, 11), 1.0F)
                .effect(new MobEffectInstance(TLStatusEffects.HEARTBREAK, VERY_LONG_DURATION, 19), 1.0F)
                .effect(new MobEffectInstance(TLStatusEffects.SHATTERSPLEEN, VERY_LONG_DURATION, 0), 1.0F)
                .effect(new MobEffectInstance(TLStatusEffects.VULNERABILITY, VERY_LONG_DURATION, 19), 1.0F)
                .effect(new MobEffectInstance(TLStatusEffects.IMPURE, VERY_LONG_DURATION, 0), 1.0F)
                .effect(new MobEffectInstance(TLStatusEffects.CHRONOS, VERY_LONG_DURATION, 0), 1.0F)
                .alwaysEat().build());
    }
}
