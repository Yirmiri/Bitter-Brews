package net.azurune.bitter_brews.registry;

import net.minecraft.screen.ScreenHandlerType;
import net.azurune.bitter_brews.screen.CopperKettleScreenHandler;

import java.util.function.Supplier;

public class RegisterScreenHandlers {


    public static final Supplier<ScreenHandlerType<CopperKettleScreenHandler>> TEA_KETTLE_SCREEN_HANDLER = //NO FUCKING CLUE, THEY CHANGED IT TO FACTORIES

            ScreenHandlerRegistry.register(Identifier.of(BitterBrews.MOD_ID, "tea_kettle_screen_handler"), CopperKettleScreenHandler::new));

    public static void registerMenuTypes() {
        TEA_KETTLE_SCREEN_HANDLER
    }

}
