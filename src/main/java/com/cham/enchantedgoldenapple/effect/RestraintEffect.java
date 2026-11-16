package com.cham.enchantedgoldenapple.effect;

import com.cham.enchantedgoldenapple.EnchantedGoldenApple;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class RestraintEffect extends MobEffect {
    public RestraintEffect() {
        super(MobEffectCategory.HARMFUL,0xFFFFFF);
        addAttributeModifier(
                Attributes.MOVEMENT_SPEED,
                Identifier.fromNamespaceAndPath(EnchantedGoldenApple.MODID, "effect.restraint.movement_speed"),
                -1,
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );
        addAttributeModifier(
                Attributes.ATTACK_SPEED,
                Identifier.fromNamespaceAndPath(EnchantedGoldenApple.MODID,"effect.restraint.attack_speed"),
                -0.5,
                AttributeModifier.Operation.ADD_VALUE
        );
    }

}
