package com.cham.enchantedgoldenapple.effect;

import com.cham.enchantedgoldenapple.EnchantedGoldenApple;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class SoulSpeedEffectHandler {
    private static final Identifier SPEED_ID =
            Identifier.fromNamespaceAndPath(EnchantedGoldenApple.MODID, "soul_speed.speed");
    private static final Identifier EFFICIENCY_ID =
            Identifier.fromNamespaceAndPath(EnchantedGoldenApple.MODID, "soul_speed.efficiency");
    private static final float SPEED_BASE = 0.0405F;
    private static final float SPEED_PER_LEVEL = 0.0105F;

    @SubscribeEvent
    public void onEntityTick(EntityTickEvent.Pre event) {
        if (event.getEntity() instanceof LivingEntity entity) {
            if (!entity.level().isClientSide()) {
                MobEffectInstance instance = entity.getEffect(ModMobEffects.SOUL_SPEED);
                if (instance != null && entity.onGround() && entity.level().getBlockState(entity.getBlockPosBelowThatAffectsMyMovement()).is(BlockTags.SOUL_SPEED_BLOCKS)) {
                    float speedAmount =  SPEED_BASE + SPEED_PER_LEVEL * instance.getAmplifier();
                    applyModifier(entity, Attributes.MOVEMENT_SPEED, SPEED_ID, speedAmount, AttributeModifier.Operation.ADD_VALUE);
                    float efficiencyAmount = 1.0F;
                    applyModifier(entity, Attributes.MOVEMENT_EFFICIENCY, EFFICIENCY_ID, efficiencyAmount, AttributeModifier.Operation.ADD_VALUE);

                }
            }
        }
    }

    private static void applyModifier(LivingEntity entity, Holder<Attribute> attribute,
                                      Identifier id, float amount, AttributeModifier.Operation operation) {
        AttributeInstance attr = entity.getAttribute(attribute);
        if (attr == null) {
            return;
        }
        AttributeModifier existing = attr.getModifier(id);
        if (amount == 0.0F) {
            if (existing != null) {
                attr.removeModifier(id);
            }
            return;
        }

        if (existing == null || existing.amount() != (double) amount || existing.operation() != operation) {
            attr.removeModifier(id);
            attr.addPermanentModifier(new AttributeModifier(id, amount, operation));
        }
    }

}
