package com.cham.enchantedgoldenapple.datagen;

import com.cham.enchantedgoldenapple.EnchantedGoldenApple;
import com.cham.enchantedgoldenapple.effect.ModMobEffects;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModZhCnLangProvider extends LanguageProvider {
    public ModZhCnLangProvider(PackOutput packOutput) {
        super(packOutput, EnchantedGoldenApple.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(ModMobEffects.AQUA_AFINITEETH.get(),"水下速嚼") ;
    }
}
