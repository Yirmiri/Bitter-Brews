package net.azurune.bitter_brews.util;

import net.azurune.tipsylib.core.register.TLStatusEffects;
import net.azurune.tipsylib.registry.TLStatusEffects;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.azurune.bitter_brews.block.SoulPepperCropBlock;
import net.azurune.bitter_brews.block.StoveBlock;

public class BBProperties {
    public static class BlockP {
        //MISC
        public static final Block.Settings MUD_STOVE = Block.Settings.copy(Blocks.MUD_BRICKS).mapColor(MapColor.TERRACOTTA_RED).luminance((state) -> { return StoveBlock.burntOut(state) ? 6 : 15; });
        public static final Block.Settings MUD_COUNTER =  Block.Settings.copy(Blocks.MUD_BRICKS);
        public static final Block.Settings AZALEA_FLOWER =  Block.Settings.copy(Blocks.GLOW_LICHEN).luminance((state) -> 0).sounds(BlockSoundGroup.WET_GRASS).mapColor(MapColor.TERRACOTTA_PINK);
        public static final Block.Settings PEPPER_CROP =  Block.Settings.copy(Blocks.NETHER_WART).sounds(BlockSoundGroup.ROOTS).mapColor(MapColor.RED);
        public static final Block.Settings SOUL_PEPPER_CROP =  Block.Settings.copy(Blocks.NETHER_WART).sounds(BlockSoundGroup.ROOTS).mapColor(MapColor.CYAN).luminance((state) -> { return SoulPepperCropBlock.mature(state) ? 0 : 7; });
        public static final Block.Settings COPPER_KETTLE =  Block.Settings.copy(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.LANTERN);
        public static final Block.Settings COFFEE_BUSH =  Block.Settings.copy(Blocks.WHEAT).sounds(BlockSoundGroup.WET_GRASS).mapColor(MapColor.TERRACOTTA_GREEN);
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
        public static final Item.Settings GENERIC_ITEM = new Item.Settings();
        public static final Item.Settings DRIED_TEA_LEAVES = new Item.Settings().food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.1F).build());
        public static final Item.Settings MANGO = new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.4F).build());
        public static final Item.Settings PEPPER = new Item.Settings().food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, BRIEF_DURATION, 0), 1.0F).alwaysEdible().build());
        public static final Item.Settings SOUL_PEPPER = new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(TLStatusEffects.TRAIL_BLAZING, BRIEF_DURATION, 0), 1.0F).alwaysEdible().build());

        //DRINKS
        public static final Item.Settings WATER = new Item.Settings().maxCount(16).food(new FoodComponent.Builder().alwaysEdible().build());
        public static final Item.Settings MILK = new Item.Settings().maxCount(16).food(new FoodComponent.Builder().alwaysEdible().build());
        public static final Item.Settings ZEUS = new Item.Settings().maxCount(1).food(new FoodComponent.Builder().alwaysEdible().build());

        public static final Item.Settings CHOCOLATE_MILK = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.CHRONOS, AVERAGE_DURATION, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.VULNERABILITY, AVERAGE_DURATION, 5), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings MELON_JUICE = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, BRIEF_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings SWEET_BERRY_JUICE = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, BRIEF_DURATION, 2), 1.0F)
                .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, VERY_SHORT_DURATION, 2), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings GLOW_BERRY_JUICE = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.PERCEPTION, SHORT_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings CHORUS_JUICE = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.TRAVERSAL, INSTANT, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, BRIEF_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings GREEN_TEA = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.RESTORATION, VERY_SHORT_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings AZALEA_TEA = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, SHORT_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings BLACK_TEA = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, INSTANT, 0), 1.0F) //TODO: Improve with an effect that stops hunger (when TipsyLib updates)
                .alwaysEdible().build());

        public static final Item.Settings ICED_TEA = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.HEARTBREAK, SHORT_DURATION, 9), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.LESSER_STRENGTH, SHORT_DURATION, 9), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings HONEY_TEA = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.DEVOUR, AVERAGE_DURATION, 1), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings MANGO_TEA = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.STEEL_FEET, AVERAGE_DURATION, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.VULNERABILITY, AVERAGE_DURATION, 1), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings KELP_TEA = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.WATER_WALKING, LONG_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings JASMINE_TEA = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.PRECISION, AVERAGE_DURATION, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.LESSER_WEAKNESS, AVERAGE_DURATION, 1), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings CRIMSON_TEA = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.BURNING_THORNS, LONG_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings WARPED_TEA = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.DIVERSION, SHORT_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings SHROOMLIGHT_TEA = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.LAVA_WALKING, LONG_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings COFFEE = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.ADRENALINE, AVERAGE_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings DARK_COFFEE = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, AVERAGE_DURATION, 2), 1.0F)
                .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, AVERAGE_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings ESPRESSO = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.TRAIL_BLAZING, AVERAGE_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings HOT_COCOA = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.BERSERK, AVERAGE_DURATION, 0), 1.0F)
                .alwaysEdible().build());

        public static final Item.Settings FUDGE_SUNDAE = new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                .statusEffect(new StatusEffectInstance(TLStatusEffects.CONFUSION, VERY_LONG_DURATION, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, VERY_LONG_DURATION, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.LESSER_STRENGTH, VERY_LONG_DURATION, 11), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.HEARTBREAK, VERY_LONG_DURATION, 19), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.SHATTERSPLEEN, VERY_LONG_DURATION, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.VULNERABILITY, VERY_LONG_DURATION, 19), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.IMPURITY, VERY_LONG_DURATION, 0), 1.0F)
                .statusEffect(new StatusEffectInstance(TLStatusEffects.CHRONOS, VERY_LONG_DURATION, 0), 1.0F)
                .alwaysEdible().build());
    }
}
