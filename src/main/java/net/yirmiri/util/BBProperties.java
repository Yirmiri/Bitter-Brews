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
import net.yirmiri.block.StoveBlock;
import net.yirmiri.register.TLStatusEffects;

public class BBProperties {
    public static class BlockP {
        //MISC
        public static final Block.Settings MUD_STOVE = FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).mapColor(MapColor.DARK_RED).luminance((state) -> { return StoveBlock.burntOut(state) ? 6 : 15; });
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

        //DRINKS
        public static final Item.Settings WATER = new FabricItemSettings().maxCount(16);

        public static final Item.Settings GREEN_TEA = new FabricItemSettings().maxCount(4).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F).statusEffect
                (new StatusEffectInstance(StatusEffects.REGENERATION, BRIEF_DURATION, 0), 1.0F).alwaysEdible().build());

        public static final Item.Settings AZALEA_TEA = new FabricItemSettings().maxCount(4).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F).statusEffect
                (new StatusEffectInstance(StatusEffects.HEALTH_BOOST, SHORT_DURATION, 0), 1.0F).alwaysEdible().build());

        public static final Item.Settings HONEY_TEA = new FabricItemSettings().maxCount(4).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F).statusEffect
                (new StatusEffectInstance(TLStatusEffects.BACKLASH, AVERAGE_DURATION, 0), 1.0F).alwaysEdible().build());

        public static final Item.Settings KELP_TEA = new FabricItemSettings().maxCount(4).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F).statusEffect
                (new StatusEffectInstance(TLStatusEffects.WATER_WALKING, VERY_LONG_DURATION, 0), 1.0F).alwaysEdible().build());

        public static final Item.Settings MANGO_TEA = new FabricItemSettings().maxCount(4).food(new FoodComponent.Builder().hunger(0).saturationModifier(0.0F).statusEffect
                (new StatusEffectInstance(TLStatusEffects.STEEL_FEET, LONG_DURATION, 0), 1.0F).alwaysEdible().build());
    }
}
