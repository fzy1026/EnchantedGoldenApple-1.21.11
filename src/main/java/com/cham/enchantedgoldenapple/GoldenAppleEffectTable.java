package com.cham.enchantedgoldenapple;

import java.util.Map;

import com.cham.enchantedgoldenapple.effect.ModMobEffects;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;

public final class GoldenAppleEffectTable {

    private static final Map<ResourceKey<Enchantment>, Holder<MobEffect>> EFFECTS = Map.ofEntries(
            Map.entry(Enchantments.AQUA_AFFINITY, ModMobEffects.AQUA_AFINITEETH),
            Map.entry(Enchantments.BANE_OF_ARTHROPODS,ModMobEffects.ARTHROPODS_SLAYER),
            Map.entry(Enchantments.BINDING_CURSE,ModMobEffects.RESTRAINT),
            Map.entry(Enchantments.BLAST_PROTECTION,ModMobEffects.BLAST_RESISTANCE),
            Map.entry(Enchantments.BREACH,ModMobEffects.SUNDERING),
            Map.entry(Enchantments.CHANNELING,ModMobEffects.CONDEMNED),
            Map.entry(Enchantments.DEPTH_STRIDER, MobEffects.DOLPHINS_GRACE),
            Map.entry(Enchantments.DENSITY, ModMobEffects.HEAVINESS),
            Map.entry(Enchantments.EFFICIENCY, MobEffects.HASTE),
            Map.entry(Enchantments.FEATHER_FALLING, MobEffects.SLOW_FALLING),
            Map.entry(Enchantments.FIRE_ASPECT, ModMobEffects.ABLAZE),
            Map.entry(Enchantments.FIRE_PROTECTION, MobEffects.FIRE_RESISTANCE),
            Map.entry(Enchantments.FLAME,ModMobEffects.ABLAZE),
            Map.entry(Enchantments.FORTUNE, MobEffects.LUCK),
            Map.entry(Enchantments.FROST_WALKER,ModMobEffects.FROST_TOUCH),
            Map.entry(Enchantments.IMPALING,ModMobEffects.MARINE_SLAYER),
            Map.entry(Enchantments.INFINITY,MobEffects.SATURATION),
            Map.entry(Enchantments.KNOCKBACK,ModMobEffects.ELBOW_STRIKE),
            Map.entry(Enchantments.LOOTING,MobEffects.HERO_OF_THE_VILLAGE),
            Map.entry(Enchantments.LOYALTY,ModMobEffects.ATTRACT),
            Map.entry(Enchantments.LUCK_OF_THE_SEA, MobEffects.CONDUIT_POWER),
            Map.entry(Enchantments.LUNGE, MobEffects.SPEED),
            Map.entry(Enchantments.LURE, ModMobEffects.LURE),
            Map.entry(Enchantments.MENDING, MobEffects.REGENERATION),
            Map.entry(Enchantments.MULTISHOT, MobEffects.WEAKNESS),
            Map.entry(Enchantments.PIERCING,ModMobEffects.PIERCING),
            Map.entry(Enchantments.POWER, MobEffects.HEALTH_BOOST),
            Map.entry(Enchantments.PROJECTILE_PROTECTION, ModMobEffects.PROJECTILE_RESISTANCE),
            Map.entry(Enchantments.PROTECTION, MobEffects.RESISTANCE),
            Map.entry(Enchantments.PUNCH,ModMobEffects.ELBOW_STRIKE),
            Map.entry(Enchantments.QUICK_CHARGE,ModMobEffects.COMBO),
            Map.entry(Enchantments.RESPIRATION, MobEffects.WATER_BREATHING),
            Map.entry(Enchantments.RIPTIDE, MobEffects.DOLPHINS_GRACE),
            Map.entry(Enchantments.SHARPNESS, MobEffects.STRENGTH),
            Map.entry(Enchantments.SILK_TOUCH,MobEffects.MINING_FATIGUE),
            Map.entry(Enchantments.SMITE, ModMobEffects.UNDEAD_SLAYER),
            Map.entry(Enchantments.SOUL_SPEED,ModMobEffects.SOUL_SPEED),
            Map.entry(Enchantments.SWEEPING_EDGE,ModMobEffects.KILLING_AREA),
            Map.entry(Enchantments.SWIFT_SNEAK, ModMobEffects.SNEAK),
            Map.entry(Enchantments.THORNS,MobEffects.INSTANT_DAMAGE),
            Map.entry(Enchantments.UNBREAKING, MobEffects.RESISTANCE),
            Map.entry(Enchantments.VANISHING_CURSE, MobEffects.INVISIBILITY),
            Map.entry(Enchantments.WIND_BURST, MobEffects.JUMP_BOOST)
    );

    private GoldenAppleEffectTable() {}

    private static int amplifierFor(int enchantmentLevel) {
        return Mth.floor(enchantmentLevel / 2.0F);
    }

    private static int durationTicksFor(int enchantmentLevel) {
        return enchantmentLevel * 10 * 20;
    }

    public static void applyTo(LivingEntity entity, ItemEnchantments enchantments) {
        for (Entry<Holder<Enchantment>> entry : enchantments.entrySet()) {
            ResourceKey<Enchantment> key = entry.getKey().unwrapKey().orElse(null);
            if (key == null) {
                continue;
            }
            Holder<MobEffect> effect = EFFECTS.get(key);
            if (effect == null) {
                continue;
            }

            int enchantmentLevel = entry.getIntValue();
            entity.addEffect(new MobEffectInstance(
                    effect, durationTicksFor(enchantmentLevel), amplifierFor(enchantmentLevel)));
        }
    }
}