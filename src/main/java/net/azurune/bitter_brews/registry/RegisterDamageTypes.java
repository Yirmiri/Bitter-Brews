package net.azurune.bitter_brews.registry;

import net.azurune.bitter_brews.BitterBrews;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class RegisterDamageTypes {
    public static final RegistryKey<DamageType> STOVE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(BitterBrews.MOD_ID, "stove"));
    public static final RegistryKey<DamageType> SOUL_PEPPER = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(BitterBrews.MOD_ID, "soul_pepper"));
    public static final RegistryKey<DamageType> COFFEE_BUSH = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(BitterBrews.MOD_ID, "coffee_bush"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}
