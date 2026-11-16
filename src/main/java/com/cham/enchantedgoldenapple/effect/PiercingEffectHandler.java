package com.cham.enchantedgoldenapple.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.Comparator;
import java.util.List;

public class PiercingEffectHandler {
    private static final double BASE_RANGE = 2.0;      // 1 级穿透距离（格）
    private static final double RANGE_PER_LEVEL = 1.5;
    private static final double BASE_DAMAGE = 3.0;     // 1 级穿透伤害
    private static final double DAMAGE_PER_LEVEL = 2.0;
    private static final double HALF_WIDTH = 1.0;      // 射线半宽
    private static final int MAX_TARGETS = 8;

    @SubscribeEvent
    public void onLivingDamagePost(LivingDamageEvent.Post event) {
        if (event.getNewDamage() <= 0.0F) {
            return;
        }

        DamageSource source = event.getSource();
        if (!source.isDirect()) {
            return;
        }
        if (!(source.getEntity() instanceof LivingEntity attacker)) {
            return;
        }

        LivingEntity target = event.getEntity();
        if (!(target.level() instanceof ServerLevel level)) {
            return;
        }

        MobEffectInstance instance = attacker.getEffect(ModMobEffects.PIERCING);
        if (instance == null) {
            return;
        }

        int effectLevel = instance.getAmplifier() + 1;
        double range = BASE_RANGE + RANGE_PER_LEVEL * (effectLevel - 1);
        float damage = (float) (BASE_DAMAGE + DAMAGE_PER_LEVEL * (effectLevel - 1));

        Vec3 origin = target.position().add(0.0, target.getBbHeight() * 0.5, 0.0);
        Vec3 dir = origin.subtract(attacker.getEyePosition());
        if (dir.lengthSqr() < 1.0E-6) {
            dir = attacker.getLookAngle();
        }
        if (dir.lengthSqr() < 1.0E-6) {
            return;
        }
        dir = dir.normalize();

        Vec3 end = origin.add(dir.scale(range));
        AABB searchBox = new AABB(origin, end).inflate(HALF_WIDTH + 1.0);

        List<LivingEntity> candidates = level.getEntitiesOfClass(
                LivingEntity.class,
                searchBox,
                e -> e != attacker && e != target && !e.isRemoved() && e.isAlive() && !e.isSpectator()
        );
        candidates.sort(Comparator.comparingDouble((LivingEntity e) -> e.distanceToSqr(origin)));

        int hit = 0;
        for (LivingEntity candidate : candidates) {
            if (hit >= MAX_TARGETS) {
                break;
            }
            Vec3 offset = candidate.position()
                    .add(0.0, candidate.getBbHeight() * 0.5, 0.0)
                    .subtract(origin);
            double along = offset.dot(dir);
            if (along <= 0.0 || along > range) {
                continue;
            }
            double lateralSqr = offset.lengthSqr() - along * along;
            if (lateralSqr > HALF_WIDTH * HALF_WIDTH) {
                continue;
            }

            DamageSource pierce = new DamageSource(
                    level.damageSources().magic().typeHolder(),
                    null,
                    attacker
            );
            candidate.hurtServer(level, pierce, damage);
            hit++;
        }
    }
}
