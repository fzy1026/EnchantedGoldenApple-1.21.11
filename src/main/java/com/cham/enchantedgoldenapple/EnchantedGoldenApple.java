package com.cham.enchantedgoldenapple;

import com.cham.enchantedgoldenapple.effect.ModMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import org.slf4j.Logger;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static net.minecraft.util.Mth.ceil;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(EnchantedGoldenApple.MODID)
public class EnchantedGoldenApple {
    public static final String MODID = "enchantedgoldenapple";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EnchantedGoldenApple(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(ModItemComponents::onModifyDefaultComponents);
        ModMobEffects.register(modEventBus);
        modEventBus.addListener(GatherDataEvent.Client.class,ModDataGenerator::gatherData);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void AquaAfiniteethWork(LivingEntityUseItemEvent.Start event) {
        ItemStack stack = event.getItem();
        if(stack.has(DataComponents.FOOD)) {
            LivingEntity entity = event.getEntity();
            if(entity.isUnderWater())
            {
                MobEffectInstance effect = entity.getEffect(ModMobEffects.AQUA_AFINITEETH);
                if(effect != null)
                {
                    int time = event.getDuration();
                    int level = effect.getAmplifier()+1;
                    event.setDuration(Math.max(0, time/(level+1)));
                }
            }
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @SubscribeEvent
    public void onGoldenAppleEaten(LivingEntityUseItemEvent event) {
        ItemStack stack = event.getItem();
        if(!stack.is(Items.GOLDEN_APPLE)) {
            return;
        }

        LivingEntity entity = event.getEntity();
        if(!(entity.level() instanceof ServerLevel))
            return;
        ItemEnchantments enchantments = stack.getAllEnchantments(entity.registryAccess().lookupOrThrow(Registries.ENCHANTMENT));
        for(Entry<Holder<Enchantment>> entry:enchantments.entrySet()) {
            Holder<Enchantment> enchantment = entry.getKey();
            int level = entry.getIntValue();
            int effectLevel = ceil((float) level /2);
            int effectTime = level*10;
            if (enchantment.is(Enchantments.PROTECTION)) {
                entity.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, effectTime, effectLevel));
            } else if (enchantment.is(Enchantments.FIRE_PROTECTION)) {
                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, effectTime, effectLevel));
            } else if (enchantment.is(Enchantments.FEATHER_FALLING)) {
                entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, effectTime, effectLevel));
            } else if (enchantment.is(Enchantments.BLAST_PROTECTION)) {
            } else if (enchantment.is(Enchantments.PROJECTILE_PROTECTION)) {
            } else if (enchantment.is(Enchantments.RESPIRATION)) {
                entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, effectTime, effectLevel));
            } else if (enchantment.is(Enchantments.AQUA_AFFINITY)) {
                entity.addEffect(new MobEffectInstance(ModMobEffects.AQUA_AFINITEETH, effectTime, effectLevel));
            } else if (enchantment.is(Enchantments.THORNS)) {
            } else if (enchantment.is(Enchantments.DEPTH_STRIDER)) {
            } else if (enchantment.is(Enchantments.FROST_WALKER)) {
            } else if (enchantment.is(Enchantments.BINDING_CURSE)) {
            } else if (enchantment.is(Enchantments.SOUL_SPEED)) {
            } else if (enchantment.is(Enchantments.SWIFT_SNEAK)) {
            } else if (enchantment.is(Enchantments.SHARPNESS)) {
            } else if (enchantment.is(Enchantments.SMITE)) {
            } else if (enchantment.is(Enchantments.BANE_OF_ARTHROPODS)) {
            } else if (enchantment.is(Enchantments.KNOCKBACK)) {
            } else if (enchantment.is(Enchantments.FIRE_ASPECT)) {
            } else if (enchantment.is(Enchantments.LOOTING)) {
            } else if (enchantment.is(Enchantments.SWEEPING_EDGE)) {
            } else if (enchantment.is(Enchantments.EFFICIENCY)) {
            } else if (enchantment.is(Enchantments.SILK_TOUCH)) {
            } else if (enchantment.is(Enchantments.UNBREAKING)) {
            } else if (enchantment.is(Enchantments.FORTUNE)) {
            } else if (enchantment.is(Enchantments.POWER)) {
            } else if (enchantment.is(Enchantments.PUNCH)) {
            } else if (enchantment.is(Enchantments.FLAME)) {
            } else if (enchantment.is(Enchantments.INFINITY)) {
            } else if (enchantment.is(Enchantments.LUCK_OF_THE_SEA)) {
            } else if (enchantment.is(Enchantments.LURE)) {
            } else if (enchantment.is(Enchantments.LOYALTY)) {
            } else if (enchantment.is(Enchantments.IMPALING)) {
            } else if (enchantment.is(Enchantments.RIPTIDE)) {
            } else if (enchantment.is(Enchantments.CHANNELING)) {
            } else if (enchantment.is(Enchantments.MULTISHOT)) {
            } else if (enchantment.is(Enchantments.QUICK_CHARGE)) {
            } else if (enchantment.is(Enchantments.PIERCING)) {
            } else if (enchantment.is(Enchantments.DENSITY)) {
            } else if (enchantment.is(Enchantments.BREACH)) {
            } else if (enchantment.is(Enchantments.WIND_BURST)) {
            } else if (enchantment.is(Enchantments.LUNGE)) {
            } else if (enchantment.is(Enchantments.MENDING)) {
            } else if (enchantment.is(Enchantments.VANISHING_CURSE)) {
            } else {
                // TODO(占位): 非原版魔咒（其它模组注册的），要区分就用 enchantment.unwrapKey()
            }
        }

    }
}
