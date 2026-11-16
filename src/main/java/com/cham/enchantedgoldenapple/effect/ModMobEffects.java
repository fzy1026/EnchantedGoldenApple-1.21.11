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
    public static final DeferredHolder<MobEffect,UndeadSlayerEffect> UNDEAD_SLAYER =
            EFFECTS.register("undead_slayer", UndeadSlayerEffect::new);
    public static final DeferredHolder<MobEffect,ArthropodsSlayerEffect> ARTHROPODS_SLAYER =
            EFFECTS.register("arthropods_slayer", ArthropodsSlayerEffect::new);
    public static final DeferredHolder<MobEffect,MarineSlayerEffect> MARINE_SLAYER =
            EFFECTS.register("marine_slayer", MarineSlayerEffect::new);
    public static final DeferredHolder<MobEffect,BlastResistanceEffect> BLAST_RESISTANCE =
            EFFECTS.register("blast_resistance",BlastResistanceEffect::new);
    public static final DeferredHolder<MobEffect,ProjectileResistanceEffect> PROJECTILE_RESISTANCE =
            EFFECTS.register("projectile_resistance",ProjectileResistanceEffect::new);
    public static final DeferredHolder<MobEffect,LureEffect> LURE =
            EFFECTS.register("lure",LureEffect::new);
    public static final DeferredHolder<MobEffect,SunderingEffect> SUNDERING =
            EFFECTS.register("sundering",SunderingEffect::new);
    public static final DeferredHolder<MobEffect,AblazeEffect> ABLAZE =
            EFFECTS.register("ablaze",AblazeEffect::new);
    public static final DeferredHolder<MobEffect,ChillEffect> CHILL =
            EFFECTS.register("chill",ChillEffect::new);
    public static final DeferredHolder<MobEffect,FrostTouchEffect> FROST_TOUCH =
            EFFECTS.register("frost_touch",FrostTouchEffect::new);
    public static final DeferredHolder<MobEffect,KillingAreaEffect> KILLING_AREA =
            EFFECTS.register("killing_area",KillingAreaEffect::new);
    public static final DeferredHolder<MobEffect,RestraintEffect> RESTRAINT =
            EFFECTS.register("restraint",RestraintEffect::new);
    public static final DeferredHolder<MobEffect,HeavinessEffect> HEAVINESS =
            EFFECTS.register("heaviness",HeavinessEffect::new);
    public static final DeferredHolder<MobEffect,SoulSpeedEffect> SOUL_SPEED =
            EFFECTS.register("soul_speed",SoulSpeedEffect::new);
    public static final DeferredHolder<MobEffect,ElbowStrikeEffect> ELBOW_STRIKE =
            EFFECTS.register("elbow_strike",ElbowStrikeEffect::new);
    public static final DeferredHolder<MobEffect,AttractEffect> ATTRACT =
            EFFECTS.register("attract",AttractEffect::new);
    public static final DeferredHolder<MobEffect,ComboEffect> COMBO =
            EFFECTS.register("combo",ComboEffect::new);
    public static final DeferredHolder<MobEffect,PiercingEffect> PIERCING =
            EFFECTS.register("piercing",PiercingEffect::new);
    public static final DeferredHolder<MobEffect,CondemnedEffect> CONDEMNED =
            EFFECTS.register("condemned",CondemnedEffect::new);
    public static final DeferredHolder<MobEffect,SneakEffect> SNEAK =
            EFFECTS.register("sneak",SneakEffect::new);
}
