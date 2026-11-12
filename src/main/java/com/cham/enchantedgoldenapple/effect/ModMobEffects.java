package com.cham.enchantedgoldenapple.effect;

import com.cham.enchantedgoldenapple.EnchantedGoldenApple;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMobEffects {
    public static final DeferredRegister<MobEffect>EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, EnchantedGoldenApple.MODID);
    public static void register(IEventBus eventBus) {EFFECTS.register(eventBus);}

    public static final DeferredHolder<MobEffect,AquaAfiniteethEffect> AQUA_AFINITEETH =
            EFFECTS.register("aqua_afiniteeth", AquaAfiniteethEffect::new);
}
