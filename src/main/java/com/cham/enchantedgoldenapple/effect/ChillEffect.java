package com.cham.enchantedgoldenapple.effect;

import com.cham.enchantedgoldenapple.EnchantedGoldenApple;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ChillEffect extends MobEffect {
    private static final int MAX_CHILL = 4;
    private static final float DAMAGE = 6;

    public ChillEffect() {
        super(MobEffectCategory.HARMFUL, 0x3efcfe);
        addAttributeModifier(
                Attributes.MOVEMENT_SPEED,
                Identifier.fromNamespaceAndPath(EnchantedGoldenApple.MODID, "effect.chill.movement_speed"),
                -0.25,
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return amplifier + 1 >= MAX_CHILL;
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        entity.hurtServer(level, level.damageSources().magic(), DAMAGE);
        return false;
    }
}
