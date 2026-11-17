package com.cham.enchantedgoldenapple;

import com.cham.enchantedgoldenapple.effect.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(EnchantedGoldenApple.MODID)
public class EnchantedGoldenApple {
    public static final String MODID = "enchantedgoldenapple";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EnchantedGoldenApple(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(ModItemComponents::onModifyDefaultComponents);
        ModMobEffects.register(modEventBus);
        NeoForge.EVENT_BUS.register(new SlayerEffectHandler());
        NeoForge.EVENT_BUS.register(new ResistanceEffectHandler());
        NeoForge.EVENT_BUS.register(new LureEffectHandler());
        NeoForge.EVENT_BUS.register(new SunderingEffectHandler());
        NeoForge.EVENT_BUS.register(new AblazeEffectHandler());
        NeoForge.EVENT_BUS.register(new FrostTouchEffectHandler());
        NeoForge.EVENT_BUS.register(new SoulSpeedEffectHandler());
        NeoForge.EVENT_BUS.register(new AttractEffectHandler());
        NeoForge.EVENT_BUS.register(new PiercingEffectHandler());
        modEventBus.addListener(GatherDataEvent.Client.class, ModDataGenerator::gatherData);
        NeoForge.EVENT_BUS.register(this);
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
    public void onGoldenAppleEaten(LivingEntityUseItemEvent.Finish event) {
        ItemStack stack = event.getItem();
        if(!stack.is(Items.GOLDEN_APPLE)) {
            return;
        }

        LivingEntity entity = event.getEntity();
        if((entity.level().isClientSide()))
            return;
        ItemEnchantments enchantments = stack.getAllEnchantments(entity.registryAccess().lookupOrThrow(Registries.ENCHANTMENT));
        GoldenAppleEffectTable.applyTo(entity, enchantments);

    }
}
