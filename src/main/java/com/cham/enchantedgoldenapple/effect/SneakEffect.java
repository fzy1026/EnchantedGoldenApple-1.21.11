package com.cham.enchantedgoldenapple.effect;

import com.cham.enchantedgoldenapple.EnchantedGoldenApple;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class SneakEffect extends MobEffect {
    public SneakEffect() {
        super(MobEffectCategory.NEUTRAL,0xe4bbc7);
        addAttributeModifier(
                Attributes.SCALE,
                Identifier.fromNamespaceAndPath(EnchantedGoldenApple.MODID,"effect.sneak.scale"),
                -0.2,
                AttributeModifier.Operation.ADD_VALUE
        );
    }
}
