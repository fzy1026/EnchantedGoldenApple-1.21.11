package com.cham.enchantedgoldenapple;

import com.cham.enchantedgoldenapple.datagen.ModZhCnLangProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.repository.Pack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class ModDataGenerator {
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(ModZhCnLangProvider::new);
    }
}
