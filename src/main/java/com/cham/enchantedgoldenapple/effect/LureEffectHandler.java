package com.cham.enchantedgoldenapple.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.animal.Animal;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

public class LureEffectHandler {
    private static final int PRIORITY = 4;
    private static final double SPEED_MODIFIER = 1.0;
    private static final double STOP_DISTANCE = 2.5;

    @SubscribeEvent
    public void onEntityJoinLevel(EntityJoinLevelEvent event) {

        if (!(event.getLevel() instanceof ServerLevel)) {
            return;
        }
        if (!(event.getEntity() instanceof Animal animal)) {
            return;
        }

        for (WrappedGoal wrapped : animal.goalSelector.getAvailableGoals()) {
            if (wrapped.getGoal() instanceof LureAttractGoal) {
                return;
            }
        }
        animal.goalSelector.addGoal(PRIORITY,
                new LureAttractGoal(animal, ModMobEffects.LURE, SPEED_MODIFIER, STOP_DISTANCE));
    }
}
