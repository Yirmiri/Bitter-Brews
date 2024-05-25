package net.yirmiri;

import net.fabricmc.api.ModInitializer;

import net.yirmiri.register.BBBlocks;
import net.yirmiri.util.BBRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitterBrews implements ModInitializer {
	public static final String MODID = "bitter_brews";
    public static final Logger LOGGER = LoggerFactory.getLogger("bitter_brews");

	@Override
	public void onInitialize() {
		BBBlocks.registerBBBlocks();
		BBRegistries.registerRegistries();
	}
}