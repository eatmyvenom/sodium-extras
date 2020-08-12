package io.github.eatmyvenom.sodiumExtras.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.eatmyvenom.sodiumExtras.SodiumExtra;
import net.minecraft.world.biome.Biome;

@Mixin(Biome.class)
public class BiomeMixin {
    @Inject(method = "getSkyColor", at = @At("HEAD"), cancellable = true)
    private void differentSkyColor(CallbackInfoReturnable<Integer> cir)
    {
        if(!SodiumExtra.getSettings().options.skycolors) {
            cir.setReturnValue(7907327);
        }
    }
}