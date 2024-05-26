package net.yirmiri.register;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.yirmiri.BitterBrews;

public class BBDamageTypes {
    public static final RegistryKey<DamageType> STOVE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(BitterBrews.MODID, "stove"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}