package com.cham.enchantedgoldenapple.effect;

import com.cham.enchantedgoldenapple.EnchantedGoldenApple;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ComboEffect extends MobEffect {
    public ComboEffect() {
        super(MobEffectCategory.BENEFICIAL,0x4c9987);
        addAttributeModifier(
                Attributes.ATTACK_SPEED,
                Identifier.fromNamespaceAndPath(EnchantedGoldenApple.MODID,"effect.combo.attack_speed"),
                0.2,
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );
    }
}
