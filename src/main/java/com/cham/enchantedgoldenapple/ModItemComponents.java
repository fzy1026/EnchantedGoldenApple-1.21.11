package com.cham.enchantedgoldenapple;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantable;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

public class ModItemComponents {
    private ModItemComponents() {}

    public static void onModifyDefaultComponents(ModifyDefaultComponentsEvent event) {
        event.modify(Items.GOLDEN_APPLE,
                builder -> builder.set(DataComponents.ENCHANTABLE,new Enchantable(30)));
    }
}
