package io.github.eatmyvenom.sodiumExtras.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.eatmyvenom.sodiumExtras.SodiumExtra;
import net.minecraft.client.color.world.BiomeColors;

@Mixin(BiomeColors.class)
public class BiomeColorsMixin {
    @Inject(method = "getGrassColor", at = @At("RETURN"), cancellable = true)
    private static void grassColor(CallbackInfoReturnable<Integer> cir)
    {
        if(!SodiumExtra.getSettings().options.biomeColors) {
            cir.setReturnValue(9551193); // 9551193 5877296
        }
    }

    @Inject(method = "getWaterColor", at = @At("RETURN"), cancellable = true)
    private static void waterColor(CallbackInfoReturnable<Integer> cir)
    {
        if(!SodiumExtra.getSettings().options.biomeColors) {
            cir.setReturnValue(4159204);
        }
    }

    @Inject(method = "getFoliageColor", at = @At("RETURN"), cancellable = true)
    private static void foliageColor(CallbackInfoReturnable<Integer> cir)
    {
        if(!SodiumExtra.getSettings().options.biomeColors) {
            cir.setReturnValue(5877296);
        }
    }
}
