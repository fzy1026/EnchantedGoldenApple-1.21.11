package com.cham.enchantedgoldenapple.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class AblazeEffectHandler {
    private static final int TARGET_FIRE_TICKS_PER_LEVEL = 80;

    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent.Post event) {
        if(event.getNewDamage() <= 0.0F)
            return;
        DamageSource source = event.getSource();
        if(source.getEntity() instanceof LivingEntity attacker)
        {
            MobEffectInstance instance = attacker.getEffect(ModMobEffects.ABLAZE);
            if(instance != null)
            {
                int level = instance.getAmplifier() + 1;
                event.getEntity().igniteForTicks(level*TARGET_FIRE_TICKS_PER_LEVEL);
            }
        }
    }
}
