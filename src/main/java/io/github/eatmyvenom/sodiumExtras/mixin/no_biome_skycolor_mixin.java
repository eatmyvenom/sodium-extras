package io.github.eatmyvenom.sodiumExtras.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.biome.Biome;

@Mixin(Biome.class)
public class no_biome_skycolor_mixin {
    @Inject(method = "getSkyColor", at = @At("HEAD"), cancellable = true)
    private void differentSkyColor(CallbackInfoReturnable<Integer> cir)
    {
        cir.setReturnValue(7907327);
    }
}