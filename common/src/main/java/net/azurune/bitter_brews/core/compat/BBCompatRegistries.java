package net.azurune.bitter_brews.core.compat;

import net.azurune.bitter_brews.BitterBrews;
import net.azurune.bitter_brews.core.compat.arts_and_crafts.ACItems;

public class BBCompatRegistries {
    public static final boolean artsAndCrafts;

    public static void initCompat() {
        if (artsAndCrafts) ACItems.loadACItems();
    }

    static {
        artsAndCrafts = BitterBrews.isModLoaded("arts_and_crafts");
    }
}
