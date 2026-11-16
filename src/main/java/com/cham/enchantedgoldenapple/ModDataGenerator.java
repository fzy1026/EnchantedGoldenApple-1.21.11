package com.cham.enchantedgoldenapple;

import com.cham.enchantedgoldenapple.datagen.ModEnUsLangProvider;
import com.cham.enchantedgoldenapple.datagen.ModZhCnLangProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class ModDataGenerator {
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(ModZhCnLangProvider::new);
        event.createProvider(ModEnUsLangProvider::new);
    }
}
