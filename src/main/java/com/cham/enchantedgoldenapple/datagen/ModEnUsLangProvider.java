package com.cham.enchantedgoldenapple.datagen;

import com.cham.enchantedgoldenapple.EnchantedGoldenApple;
import com.cham.enchantedgoldenapple.effect.ModMobEffects;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnUsLangProvider extends LanguageProvider {
    public ModEnUsLangProvider(PackOutput packOutput) {
        super(packOutput, EnchantedGoldenApple.MODID, "en_us");
    }
    @Override
    protected void addTranslations() {
        add(ModMobEffects.AQUA_AFINITEETH.get(),"Aqua Afiniteeth");
    }
}
