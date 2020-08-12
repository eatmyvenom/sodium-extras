package io.github.eatmyvenom.sodiumExtras.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.toast.ToastManager;

@Mixin(ToastManager.class)
public class no_toast_mixin {
    @Inject(method = "add", at = @At("HEAD"), cancellable = true)
    public void shutupPls(CallbackInfo ci) {
        ci.cancel();
    }
}