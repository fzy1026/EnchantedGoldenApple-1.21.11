package com.cham.enchantedgoldenapple.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;

public class CondemnedEffect extends MobEffect {
    public CondemnedEffect() {
        super(MobEffectCategory.HARMFUL,0xA0DEFF);
    }
    private static final int BASE_GAP = 20;

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % BASE_GAP == 0;
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(level, EntitySpawnReason.EVENT);
        if (lightningBolt != null) {
            lightningBolt.snapTo(entity.getX(), entity.getY(), entity.getZ());
            level.addFreshEntity(lightningBolt);
        }
        return true;
    }
}
