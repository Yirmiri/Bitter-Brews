package net.azurune.bitter_brews.core.registry;

import net.azurune.bitter_brews.common.effect.CaffeinatedEffect;
import net.azurune.tipsylib.common.effect.NoSpecialEffect;
import net.azurune.tipsylib.core.platform.Services;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.function.Supplier;

public class BBStatusEffects {

    //BENEFICIAL
    public static final MobEffect CAFFEINATED = new CaffeinatedEffect(MobEffectCategory.BENEFICIAL, 0x492f25);

    //HARMFUL
    public static final MobEffect CAFFEINE_CRASH = new NoSpecialEffect(MobEffectCategory.HARMFUL, 0x313d99);

    public static void loadEffects() {
        //BENEFICIAL
        registerEffect("caffeinated", () -> CAFFEINATED
                .addAttributeModifier(Attributes.ATTACK_DAMAGE, "0a921b76-10d3-4038-8a2d-7e53ad32ef3d", 1.0, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.MOVEMENT_SPEED, "3ecec3d4-8bad-4f10-b870-83228e444672", 0.03, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.ARMOR, "bb33d1c3-68b1-4413-958e-3a6b32e991be", 2.0, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.MAX_HEALTH, "659863ac-6cc0-4f4e-92c4-96fc04df37bf", 2.0, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.JUMP_STRENGTH, "c428b22a-8db3-4778-9dba-27fae9f9b6a4", 1.0, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.LUCK, "5213feef-1d5f-407a-a708-629b79d12bf3", 1.0, AttributeModifier.Operation.ADDITION));

        //HARMFUL
        registerEffect("caffeine_crash", () -> CAFFEINE_CRASH
                .addAttributeModifier(Attributes.ATTACK_DAMAGE, "0a921b76-10d3-4038-8a2d-7e53ad32ef3d", -1.0, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.MOVEMENT_SPEED, "3ecec3d4-8bad-4f10-b870-83228e444672", -0.03, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.ARMOR, "bb33d1c3-68b1-4413-958e-3a6b32e991be", -2.0, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.MAX_HEALTH, "659863ac-6cc0-4f4e-92c4-96fc04df37bf", -2.0, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.JUMP_STRENGTH, "c428b22a-8db3-4778-9dba-27fae9f9b6a4", -1.0, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.LUCK, "5213feef-1d5f-407a-a708-629b79d12bf3", -1.0, AttributeModifier.Operation.ADDITION));
    }

    private static <T extends MobEffect> Supplier<T> registerEffect(String name, Supplier<T> supplier) {
        return Services.REGISTRY.registerEffect(name, supplier);
    }
}