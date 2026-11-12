package com.cham.enchantedgoldenapple.mixin;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.List;
import java.util.stream.Stream;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(method = "getAvailableEnchantmentResults",at = @At("HEAD"),cancellable = true)
    private static void enchantedGoldenApple$goldenAppleTableCandidates(
            int level,
            ItemStack stack,
            Stream<Holder<Enchantment>> possibleEnchantments,
            CallbackInfoReturnable<List<EnchantmentInstance>> cir
            )
    {
        if(stack.is(Items.GOLDEN_APPLE)){
            cir.setReturnValue(EnchantmentHelper.getAvailableEnchantmentResults(level,new ItemStack(Items.BOOK),possibleEnchantments));
        }
    }
}
