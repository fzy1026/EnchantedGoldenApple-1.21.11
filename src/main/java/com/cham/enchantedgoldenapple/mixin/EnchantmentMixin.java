package com.cham.enchantedgoldenapple.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Enchantment.class)
public class EnchantmentMixin {
    @Inject(method = "isSupportedItem",at = @At("HEAD"),cancellable = true)
    private void enchantedGoldenApple$goldenAppleAcceptAnyEnchantments(
            ItemStack stack,
            CallbackInfoReturnable<Boolean> cir
    ){
        if(stack.is(Items.GOLDEN_APPLE)){
            cir.setReturnValue(true);
        }
    }
}
