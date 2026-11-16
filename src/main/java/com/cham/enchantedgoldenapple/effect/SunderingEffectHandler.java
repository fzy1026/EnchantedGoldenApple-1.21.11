package com.cham.enchantedgoldenapple.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.event.entity.living.ArmorHurtEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class SunderingEffectHandler {
    private static final float ARMOR_IGNORE_PER_LEVEL = 0.2F;
    private static final float DURABILITY_MULTIPLIER_PER_LEVEL = 1.0F;
    @SubscribeEvent
    public void onIncomingDamage(LivingIncomingDamageEvent event) {
        DamageSource source = event.getSource();
        if(source.getEntity() instanceof LivingEntity attacker) {
            MobEffectInstance instance = attacker.getEffect(ModMobEffects.SUNDERING);
            if(instance != null) {
                int level = instance.getAmplifier() + 1;
                float durabilityMultiplier = Math.min(1.0F,ARMOR_IGNORE_PER_LEVEL * level);
                event.addReductionModifier(DamageContainer.Reduction.ARMOR,((damageContainer, v) -> v*(1.0F-durabilityMultiplier)));
            }
        }
    }

    @SubscribeEvent
    public void onArmorHurt(ArmorHurtEvent event) {
        DamageSource source = event.getDamageSource();
        if(source.getEntity() instanceof LivingEntity attacker) {
            MobEffectInstance instance = attacker.getEffect(ModMobEffects.SUNDERING);
            if (instance != null) {
                int level = instance.getAmplifier() + 1;
                for(EquipmentSlot slot : EquipmentSlot.values()) {
                    float current = event.getNewDamage(slot);
                    if(current > 0.0F) {
                        event.setNewDamage(slot,current*(1+DURABILITY_MULTIPLIER_PER_LEVEL*level));
                    }
                }
            }
        }
    }
}
