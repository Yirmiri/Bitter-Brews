package net.yirmiri.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yirmiri.BitterBrews;
import net.yirmiri.block.StoveBlock;
import net.yirmiri.util.BBProperties;

public class BBBlocks {
    //MISC
    public static final Block MUD_STOVE = register("mud_stove", new StoveBlock(BBProperties.BlockP.MUD_STOVE, 1, 2));

    private static Block register(String name, Block block) {
        registerItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BitterBrews.MODID, name), block);
    }

    private static Block registerWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(BitterBrews.MODID, name), block);
    }

    private static Item registerItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BitterBrews.MODID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerBBBlocks() {
    }
}
