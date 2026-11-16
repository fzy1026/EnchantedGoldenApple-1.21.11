package com.cham.enchantedgoldenapple.effect;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class ResistanceEffectHandler {
    @SubscribeEvent
    public void onIncomingDamage(LivingIncomingDamageEvent event) {
        LivingEntity target = event.getEntity();
        DamageSource source = event.getSource();
        boolean resistent = false;
        if (target instanceof LivingEntity) {
            for(MobEffectInstance effect : target.getActiveEffects()) {
                if(effect.is(ModMobEffects.BLAST_RESISTANCE) && source.is(DamageTypeTags.IS_EXPLOSION))
                {
                    resistent = true;
                }
                else if(effect.is(ModMobEffects.PROJECTILE_RESISTANCE) && source.is(DamageTypeTags.IS_PROJECTILE))
                {
                    resistent = true;
                }
                else{

                }

                if(resistent)
                {
                    event.setAmount(0);
                }
            }
        }
    }
}
