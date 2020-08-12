package io.github.eatmyvenom.sodiumExtras.mixin;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.light.LightingProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(LightingProvider.class)
public class LightKiller {
    /**
     * @author me
     * @reason me
     */
    @Overwrite
    public void checkBlock(BlockPos pos) {
        return;
    }
}
