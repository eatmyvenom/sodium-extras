package io.github.eatmyvenom.sodiumExtras.mixin;

import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class clientkiller {
    @Inject(method = "tickTime", at = @At("HEAD"), cancellable = true)
    public void dodatic(CallbackInfo ci) {
        ci.cancel();
    }
}
