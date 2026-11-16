package com.cham.enchantedgoldenapple.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class FrostTouchEffectHandler {
    static final int DURATION_TICKS_PER_LEVEL = 60;
    @SubscribeEvent
    public void onLivingDamagePost(LivingDamageEvent.Post event) {
        LivingEntity target = event.getEntity();
        DamageSource source = event.getSource();
        if(event.getNewDamage() <= 0.0F)
            return;
        if(source.getEntity() instanceof LivingEntity attacker)
        {
            MobEffectInstance instance = attacker.getEffect(ModMobEffects.FROST_TOUCH);
            if(instance != null)
            {
                int level = instance.getAmplifier() + 1;
                MobEffectInstance targetChill = target.getEffect(ModMobEffects.CHILL);
                int chillLevel = targetChill == null ? 0 : (targetChill.getAmplifier() + 1);

                MobEffectInstance chillInstance = new MobEffectInstance(
                        ModMobEffects.CHILL,
                        level*DURATION_TICKS_PER_LEVEL,
                        chillLevel+(level-1)
                );
                target.addEffect(chillInstance);
            }
        }
    }
}
