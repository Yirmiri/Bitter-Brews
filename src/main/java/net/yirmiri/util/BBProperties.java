package net.yirmiri.util;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.yirmiri.block.StoveBlock;

public class BBProperties {
    public class BlockP {
        //MISC
        public static final Block.Settings MUD_STOVE = FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).mapColor(MapColor.DARK_RED).luminance((state) -> { return StoveBlock.burntOut(state) ? 6 : 15; });
    }

    public class ItemP {
        //MISC
        //public static final Item.Settings GLOOM_SIGN = new FabricItemSettings().maxCount(16);
    }
}
