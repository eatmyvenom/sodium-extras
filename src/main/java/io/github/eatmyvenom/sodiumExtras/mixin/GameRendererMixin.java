package io.github.eatmyvenom.sodiumExtras.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import io.github.eatmyvenom.sodiumExtras.SodiumExtra;
import net.java.games.input.Component.Identifier;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(method="bobViewWhenHurt", at = @At("HEAD"), cancellable = true)
    private void cancelHurtCam(MatrixStack ms, float f, CallbackInfo ci) {
        if(!SodiumExtra.getSettings().options.hurtcam) {
            ci.cancel();
        }
    }

    @Inject(method = "getFov", at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/GameRenderer;lastMovementFovMultiplier:F"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
	private void preventFovChange(Camera camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> cir, double currentFov) {
		if(SodiumExtra.getSettings().options.staticFov) {
			cir.setReturnValue(currentFov);
		}
    }
    
    @Inject(method = "toggleShadersEnabled", at = @At("HEAD"), cancellable = true)
    private void preventShaders(CallbackInfo ci) {
        if(SodiumExtra.getSettings().options.preventShaders) {
            ci.cancel();
        }
    }

    @Inject(method = "loadShader", at = @At("HEAD"), cancellable = true)
    private void dontLoadShader(Identifier identifier, CallbackInfo ci) {
        if(SodiumExtra.getSettings().options.preventShaders) {
            ci.cancel();
        }
    }
}