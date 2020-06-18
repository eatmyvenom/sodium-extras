package io.github.eatmyvenom.sodiumExtras.mixin;

import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(GameRenderer.class)
public class static_fov_mixin {
	@Inject(method = "getFov", at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/GameRenderer;lastMovementFovMultiplier:F"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
	private void init(Camera camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> cir, double currentFov) {
		cir.setReturnValue(currentFov);
	}
}
