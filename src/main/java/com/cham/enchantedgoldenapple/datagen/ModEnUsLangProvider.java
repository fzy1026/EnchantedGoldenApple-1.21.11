package com.cham.enchantedgoldenapple.datagen;

import com.cham.enchantedgoldenapple.EnchantedGoldenApple;
import com.cham.enchantedgoldenapple.effect.ModMobEffects;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnUsLangProvider extends LanguageProvider {
    public ModEnUsLangProvider(PackOutput packOutput) {
        super(packOutput, EnchantedGoldenApple.MODID, "en_us");
    }
    @Override
    protected void addTranslations() {
        add(ModMobEffects.AQUA_AFINITEETH.get(),"Aqua Afiniteeth");
        add(ModMobEffects.ARTHROPODS_SLAYER.get(),"Arthropods Slayer");
        add(ModMobEffects.MARINE_SLAYER.get(),"Marine Slayer");
        add(ModMobEffects.UNDEAD_SLAYER.get(),"Undead Slayer");
        add(ModMobEffects.BLAST_RESISTANCE.get(),"Blast Resistance");
        add(ModMobEffects.PROJECTILE_RESISTANCE.get(),"Projectile Resistance");
        add(ModMobEffects.LURE.get(),"Lure");
        add(ModMobEffects.SUNDERING.get(),"Sundering");
        add(ModMobEffects.ABLAZE.get(),"Ablaze");
        add(ModMobEffects.CHILL.get(),"Chill");
        add(ModMobEffects.FROST_TOUCH.get(),"Frost touch");
        add(ModMobEffects.KILLING_AREA.get(),"Killing Area");
        add(ModMobEffects.RESTRAINT.get(),"Restraint");
        add(ModMobEffects.HEAVINESS.get(),"Heaviness");
        add(ModMobEffects.SOUL_SPEED.get(),"Soul Speed");
        add(ModMobEffects.ELBOW_STRIKE.get(),"Elbow Strike");
        add(ModMobEffects.ATTRACT.get(),"Attract");
        add(ModMobEffects.COMBO.get(),"Combo");
        add(ModMobEffects.PIERCING.get(),"Piercing");
        add(ModMobEffects.CONDEMNED.get(),"Condemned");
        add(ModMobEffects.SNEAK.get(),"Sneak");
    }
}
