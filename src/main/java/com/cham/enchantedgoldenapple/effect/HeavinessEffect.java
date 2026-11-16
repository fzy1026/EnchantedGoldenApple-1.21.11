package com.cham.enchantedgoldenapple.effect;

import com.cham.enchantedgoldenapple.EnchantedGoldenApple;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class HeavinessEffect extends MobEffect {
    public HeavinessEffect() {
        super(MobEffectCategory.NEUTRAL,0x737373);
        addAttributeModifier(
                Attributes.MOVEMENT_SPEED,
                Identifier.fromNamespaceAndPath(EnchantedGoldenApple.MODID, "effect.heaviness.movement_speed"),
                -0.5,
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );
        addAttributeModifier(
                Attributes.GRAVITY,
                Identifier.fromNamespaceAndPath(EnchantedGoldenApple.MODID, "effect.heaviness.gravity"),
                1,
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );
        addAttributeModifier(
                Attributes.EXPLOSION_KNOCKBACK_RESISTANCE,
                Identifier.fromNamespaceAndPath(EnchantedGoldenApple.MODID, "effect.heaviness.explosion_knockback_resistance"),
                1,
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );
        addAttributeModifier(
                Attributes.KNOCKBACK_RESISTANCE,
                Identifier.fromNamespaceAndPath(EnchantedGoldenApple.MODID, "effect.heaviness.knockback_resistance"),
                1,
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );
    }
}
