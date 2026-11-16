package com.cham.enchantedgoldenapple.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class AblazeEffect extends MobEffect {
    public AblazeEffect() {
        super(MobEffectCategory.NEUTRAL,0xf99a34);
    }

    private static final int FIRE_TICKS = 20;
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % FIRE_TICKS == 0;
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        entity.igniteForTicks(FIRE_TICKS);
        return true;
    }
}
