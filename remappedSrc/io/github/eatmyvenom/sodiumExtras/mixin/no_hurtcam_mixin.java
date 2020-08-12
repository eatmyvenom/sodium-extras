package io.github.eatmyvenom.sodiumExtras.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;

@Mixin(GameRenderer.class)
public class no_hurtcam_mixin {
    @Inject(method="bobViewWhenHurt", at = @At("HEAD"), cancellable = true)
    private void cancelHurtCam(MatrixStack ms, float f, CallbackInfo ci)
    {
        ci.cancel();
    }
}