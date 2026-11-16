package com.cham.enchantedgoldenapple.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class KillingAreaEffect extends MobEffect {
    private static final int INTERVAL_TICKS = 20;
    private static final double RADIUS = 5.0f;
    private static final float DAMAGE_PER_LEVEL = 4.0f;

    public KillingAreaEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x7a01b2);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % INTERVAL_TICKS == 0;
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        double radius = RADIUS * RADIUS;
        List<LivingEntity> targets = level.getEntitiesOfClass(
                LivingEntity.class,
                entity.getBoundingBox().inflate(RADIUS),
                target -> target != entity
                        && target.isAlive()
                        && (!target.isSpectator())
                        && target.distanceToSqr(entity) <= radius
        );
        for(LivingEntity target : targets) {
            target.hurtServer(level,level.damageSources().mobAttack(entity),DAMAGE_PER_LEVEL*(amplifier+1));
        }
        return true;
    }
}
