package net.yirmiri.bitter_brews.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.yirmiri.bitter_brews.BitterBrews;

public class BBDamageTypes {

    public static final ResourceKey<DamageType> STOVE = register(new DamageType("stove", 0));
    public static final ResourceKey<DamageType> SOUL_PEPPER = register(new DamageType("soul_pepper", 0));
    public static final ResourceKey<DamageType> COFFEE_BUSH = register(new DamageType("coffee_bush", 0));

    public static ResourceKey<DamageType> register(DamageType damageType) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, BitterBrews.id(damageType.msgId()));
    }
}
