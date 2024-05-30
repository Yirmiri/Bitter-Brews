package net.azurune.bitter_brews.platform;

import net.azurune.bitter_brews.BitterBrewsConstants;
import net.azurune.bitter_brews.core.platform.services.BitterBrewsRegistryHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ForgeBitterBrewsRegistryHelper implements BitterBrewsRegistryHelper {

    private static final RegistryMap registryMap = new RegistryMap();

    public static final DeferredRegister<MenuType<?>> MENU = DeferredRegister.create(ForgeRegistries.MENU_TYPES, BitterBrewsConstants.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BitterBrewsConstants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BitterBrewsConstants.MOD_ID);


    @Override
    public <T> Supplier<T> register(Registry<? super T> registry, String name, Supplier<T> entry) {
        return registryMap.register(registry, name, entry);
    }


    @Override
    public <T extends Block> Supplier<T> registerBlockWithItem(String id, Supplier<T> blockSupplier) {
        var block = BLOCKS.register(id, blockSupplier);
        ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> blockSupplier) {
        return BLOCKS.register(id, blockSupplier);
    }



    private static class RegistryMap {

        private final Map<ResourceLocation, DeferredRegister<?>> registries = new HashMap<>();

        @SuppressWarnings({"unchecked", "rawtypes"})
        private <T> RegistryObject<T> register(Registry<? super T> registry, String name, Supplier<T> entry) {
            DeferredRegister<T> reg = (DeferredRegister<T>)registries.computeIfAbsent(registry.key().location(), (key) -> {
                ForgeRegistry forgeReg = RegistryManager.ACTIVE.getRegistry(key);

                if(forgeReg == null)
                    return null;

                DeferredRegister<T> defReg = DeferredRegister.create(forgeReg, BitterBrewsConstants.MOD_ID);
                defReg.register(FMLJavaModLoadingContext.get().getModEventBus());

                return defReg;
            });

            return reg != null ? reg.register(name, entry) : null;
        }

    }
}
