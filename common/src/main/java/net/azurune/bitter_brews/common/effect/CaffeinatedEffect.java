package net.azurune.bitter_brews.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class CaffeinatedEffect extends MobEffect {
    public CaffeinatedEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity living, int amplifier) {
//        if (living.hasEffect(BBStatusEffects.CAFFEINE_CRASH)) {
//            living.removeEffect(BBStatusEffects.CAFFEINE_CRASH);
//        }
    }
//TODO: Caffeine crash upon effect ending
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}