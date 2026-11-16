package com.cham.enchantedgoldenapple.effect;

import com.cham.enchantedgoldenapple.EnchantedGoldenApple;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ElbowStrikeEffect extends MobEffect {
    public ElbowStrikeEffect() {
        super(MobEffectCategory.HARMFUL,0xe56501);
        addAttributeModifier(
                Attributes.ATTACK_KNOCKBACK,
                Identifier.fromNamespaceAndPath(EnchantedGoldenApple.MODID,"effect.elbow_strike.attack_knockback"),
                0.5,
                AttributeModifier.Operation.ADD_VALUE
        );
    }
}
