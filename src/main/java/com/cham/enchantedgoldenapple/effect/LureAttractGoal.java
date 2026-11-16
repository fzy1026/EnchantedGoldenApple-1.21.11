package com.cham.enchantedgoldenapple.effect;

import java.util.EnumSet;
import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;


public class LureAttractGoal extends Goal {

    private static final int SCAN_INTERVAL = 10;
    private final Mob mob;
    private final Holder<MobEffect> effect;
    private final double speedModifier;
    private final double stopDistance;

    private LivingEntity target;
    private int nextScanTick;

    public LureAttractGoal(Mob mob, Holder<MobEffect> effect, double speedModifier, double stopDistance) {
        this.mob = mob;
        this.effect = effect;
        this.speedModifier = speedModifier;
        this.stopDistance = stopDistance;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        if (this.mob.tickCount < this.nextScanTick) {
            return this.target != null && this.isValidTarget(this.target);
        }
        this.nextScanTick = this.mob.tickCount + SCAN_INTERVAL;
        this.target = this.findNearestHolder();
        return this.target != null;
    }

    @Override
    public boolean canContinueToUse() {
        return this.target != null && this.isValidTarget(this.target);
    }

    @Override
    public void start() {
        this.mob.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.target = null;
        this.mob.getNavigation().stop();
        // 停止后冷却一小段时间，否则目标在半径边缘时会反复起停、原地抖动
        this.nextScanTick = this.mob.tickCount + SCAN_INTERVAL;
    }

    @Override
    public void tick() {
        this.mob.getLookControl().setLookAt(this.target, this.mob.getMaxHeadYRot() + 20, this.mob.getMaxHeadXRot());
        if (this.mob.distanceToSqr(this.target) < this.stopDistance * this.stopDistance) {
            this.mob.getNavigation().stop();
        } else {
            this.mob.getNavigation().moveTo(this.target, this.speedModifier);
        }
    }

    private boolean isValidTarget(LivingEntity entity) {
        if (entity.isRemoved() || !entity.isAlive() || !entity.hasEffect(this.effect)) {
            return false;
        }
        double range = this.range();
        return this.mob.distanceToSqr(entity) <= range * range;
    }

    private double range() {
        return this.mob.getAttributeValue(Attributes.TEMPT_RANGE);
    }

    private LivingEntity findNearestHolder() {
        if (!(this.mob.level() instanceof ServerLevel level)) {
            return null;
        }
        double range = this.range();
        AABB box = this.mob.getBoundingBox().inflate(range);
        List<LivingEntity> candidates = level.getEntitiesOfClass(LivingEntity.class, box,
                e -> e != this.mob && !e.isSpectator() && e.isAlive() && e.hasEffect(this.effect));

        LivingEntity best = null;
        double bestDistance = Double.MAX_VALUE;
        for (LivingEntity candidate : candidates) {
            double distance = this.mob.distanceToSqr(candidate);
            if (distance < bestDistance) {
                bestDistance = distance;
                best = candidate;
            }
        }
        return best;
    }
}