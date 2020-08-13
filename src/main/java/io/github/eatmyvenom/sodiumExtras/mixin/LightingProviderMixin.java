package io.github.eatmyvenom.sodiumExtras.mixin;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.light.LightingProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.eatmyvenom.sodiumExtras.SodiumExtra;

@Mixin(LightingProvider.class)
public class LightingProviderMixin {

    @Inject(at = @At("HEAD"), method = "checkBlock", cancellable = true)
    public void checkBlock(BlockPos pos, CallbackInfo ci) {
        if(!SodiumExtra.getSettings().options.lightUpdates)
            ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "doLightUpdates", cancellable = true)
    public void doLightUpdates(int maxUpdateCount, boolean doSkylight, boolean skipEdgeLightPropagation, CallbackInfoReturnable<Integer> cir) { 
        if(!SodiumExtra.getSettings().options.lightUpdates)
            cir.setReturnValue(0);
    }


}
