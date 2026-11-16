package com.cham.enchantedgoldenapple.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class AttractEffectHandler {
    private static final double BASE_RANGE = 6.0;
    private static final double RANGE_PER_LEVEL = 3.0;
    private static final double BASE_PULL = 0.15;
    private static final double PULL_PER_LEVEL = 0.05;

    @SubscribeEvent
    public void onEntityTick(EntityTickEvent.Pre event) {
        if (event.getEntity() instanceof LivingEntity entity) {
            if(!entity.level().isClientSide()) {
                MobEffectInstance effect = entity.getEffect(ModMobEffects.ATTRACT);
                if (effect != null) {
                    ServerLevel level = (ServerLevel) entity.level();
                    double range = BASE_RANGE + RANGE_PER_LEVEL * effect.getAmplifier();
                    double pull = BASE_PULL + PULL_PER_LEVEL * effect.getAmplifier();
                    Vec3 origin = entity.position().add(0.0, entity.getEyeHeight() * 0.5, 0.0);
                    for (LivingEntity target : level.getEntitiesOfClass(
                            LivingEntity.class,
                            entity.getBoundingBox().inflate(range),
                            LivingEntity::isAlive)) {
                        Vec3 delta = origin.subtract(target.position());
                        double dist = delta.length();
                        if (target != entity) {
                            target.addDeltaMovement(delta.scale(1.0 / dist).scale(pull));
                        }
                    }
                    for (ItemEntity item : level.getEntitiesOfClass(
                            ItemEntity.class,
                            entity.getBoundingBox().inflate(range),
                            ItemEntity::isAlive)) {
                        Vec3 delta = origin.subtract(item.position());
                        double dist = delta.length();
                        if (dist < 1.5)
                            continue;
                        item.addDeltaMovement(delta.scale(1.0 / dist).scale(pull));
                    }
                }
            }
        }
    }
}
