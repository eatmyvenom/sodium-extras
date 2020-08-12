package io.github.eatmyvenom.sodiumExtras.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.eatmyvenom.sodiumExtras.SodiumExtra;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

@Mixin(World.class)
public abstract class WorldMixin implements WorldAccess{
    @Inject(method = "getRainGradient", at = @At("HEAD"), cancellable = true)
    private void disableRain(float f, CallbackInfoReturnable<Float> cir) {
        if(!SodiumExtra.getSettings().options.rain) {
            cir.setReturnValue(0.0f);
        }
    }

    @Override
    public float getSkyAngle(float tickDelta) {
        if(SodiumExtra.getSettings().options.dayTime) {
            return this.getDimension().method_28528(this.getLevelProperties().getTimeOfDay());
        }
        return this.getDimension().method_28528(5000L);
    }

}