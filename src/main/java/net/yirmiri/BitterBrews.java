package net.yirmiri;

import net.fabricmc.api.ModInitializer;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.yirmiri.register.BBBlocks;
import net.yirmiri.register.BBItemGroups;
import net.yirmiri.register.BBItems;
import net.yirmiri.util.BBRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitterBrews implements ModInitializer {
	public static final String MODID = "bitter_brews";
    public static final Logger LOGGER = LoggerFactory.getLogger("bitter_brews");

	public static MutableText id(String key, Object... args) {
		return Text.translatable(MODID + "." + key, args);
	}

	@Override
	public void onInitialize() {
		BBBlocks.registerBBBlocks();
		BBRegistries.registerRegistries();
		BBItemGroups.registerAddToVanilla();
		BBItems.registerBBItems();
	}
}