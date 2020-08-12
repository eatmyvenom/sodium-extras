package io.github.eatmyvenom.sodiumExtras.mixin;

import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(World.class)
public class worldKiller {

    /**
     * @author urmom
     * @reason urmom
     */
    @Overwrite
    public void tickBlockEntities() {
        //stfu
    }

}
