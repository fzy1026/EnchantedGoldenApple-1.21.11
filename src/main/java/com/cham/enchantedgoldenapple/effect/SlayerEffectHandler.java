package com.cham.enchantedgoldenapple.effect;

import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class SlayerEffectHandler {
    @SubscribeEvent
    public void onIncomingDamage(LivingIncomingDamageEvent event) {
        LivingEntity target = event.getEntity();
        DamageSource source = event.getSource();
        if (source.getEntity() instanceof LivingEntity attacker) {
            float damage = event.getAmount();
            boolean boost = false;
            for (MobEffectInstance instance : attacker.getActiveEffects()) {
                if (instance.is(ModMobEffects.UNDEAD_SLAYER)) {
                    if (target.getType().is(EntityTypeTags.UNDEAD)) {
                        boost = true;
                    }
                } else if (instance.is(ModMobEffects.ARTHROPODS_SLAYER)) {
                    if (target.getType().is(EntityTypeTags.ARTHROPOD)) {
                        boost = true;

                    }
                } else if (instance.is(ModMobEffects.MARINE_SLAYER)) {
                    if (target.getType().is(EntityTypeTags.AQUATIC)) {
                        boost = true;
                    }
                } else {

                }
                if (boost) {
                    float finalDamage = (float) (damage * (1 + 0.25 * (instance.getAmplifier()+1)));
                    event.setAmount(finalDamage);
                    break;
                }
            }
        }
    }
}
