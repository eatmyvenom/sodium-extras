package io.github.eatmyvenom.sodiumExtras.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.eatmyvenom.sodiumExtras.SodiumExtra;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;

@Mixin(Camera.class)
public class CameraMixin {

    @Shadow
    private float cameraY;

    @Shadow
    private Entity focusedEntity;

    @Inject(at = @At("HEAD"), method = "updateEyeHeight")
    public void noLerp(CallbackInfo ci) {
        if(SodiumExtra.getSettings().options.instantSneak) {
            this.cameraY = this.focusedEntity.getStandingEyeHeight();
        }
    }

    @Inject(at = {@At("HEAD")}, method = {"getSubmergedFluidState()Lnet/minecraft/fluid/FluidState;"}, cancellable = true)
	private void getSubmergedFluidState(CallbackInfoReturnable<FluidState> cir)
	{
		if(SodiumExtra.getSettings().options.noOverlay)
			cir.setReturnValue(Fluids.EMPTY.getDefaultState());
    }
}