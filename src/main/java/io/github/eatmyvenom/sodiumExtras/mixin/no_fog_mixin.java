package io.github.eatmyvenom.sodiumExtras.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;

@Mixin(BackgroundRenderer.class)
public class no_fog_mixin {
    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private static void disableFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, CallbackInfo ci) {
        ci.cancel();
    }
}