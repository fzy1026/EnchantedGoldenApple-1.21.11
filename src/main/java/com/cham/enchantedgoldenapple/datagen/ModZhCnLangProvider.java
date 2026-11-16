package com.cham.enchantedgoldenapple.datagen;

import com.cham.enchantedgoldenapple.EnchantedGoldenApple;
import com.cham.enchantedgoldenapple.effect.ModMobEffects;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModZhCnLangProvider extends LanguageProvider {
    public ModZhCnLangProvider(PackOutput packOutput) {
        super(packOutput, EnchantedGoldenApple.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(ModMobEffects.AQUA_AFINITEETH.get(),"水下速嚼") ;
        add(ModMobEffects.ARTHROPODS_SLAYER.get(),"节肢杀手");
        add(ModMobEffects.MARINE_SLAYER.get(),"海鲜杀手");
        add(ModMobEffects.UNDEAD_SLAYER.get(),"亡灵杀手");
        add(ModMobEffects.BLAST_RESISTANCE.get(),"爆炸免疫");
        add(ModMobEffects.PROJECTILE_RESISTANCE.get(),"弹射物免疫");
        add(ModMobEffects.LURE.get(),"诱引");
        add(ModMobEffects.SUNDERING.get(),"碎甲");
        add(ModMobEffects.ABLAZE.get(),"浴火");
        add(ModMobEffects.CHILL.get(),"寒意");
        add(ModMobEffects.FROST_TOUCH.get(),"霜寒附加");
        add(ModMobEffects.KILLING_AREA.get(),"杀戮光环");
        add(ModMobEffects.RESTRAINT.get(),"束缚");
        add(ModMobEffects.HEAVINESS.get(),"沉重");
        add(ModMobEffects.SOUL_SPEED.get(),"灵魂疾行");
        add(ModMobEffects.ELBOW_STRIKE.get(),"肘击");
        add(ModMobEffects.ATTRACT.get(),"吸引");
        add(ModMobEffects.COMBO.get(),"连击");
        add(ModMobEffects.PIERCING.get(),"贯穿");
        add(ModMobEffects.CONDEMNED.get(),"天谴");
        add(ModMobEffects.SNEAK.get(),"潜行");
    }
}
