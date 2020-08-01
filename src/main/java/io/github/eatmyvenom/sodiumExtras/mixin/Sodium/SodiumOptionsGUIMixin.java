package io.github.eatmyvenom.sodiumExtras.mixin.Sodium;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.eatmyvenom.sodiumExtras.options.SodiumExtrasOptionPages;
import me.jellysquid.mods.sodium.client.gui.SodiumOptionsGUI;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;

@Mixin(SodiumOptionsGUI.class)
public class SodiumOptionsGUIMixin {

    @Shadow 
    private List<OptionPage> pages = new ArrayList<>();

    @Inject(method = "<init>", at = @At("TAIL"))
    public void addPage(CallbackInfo ci) {
        this.pages.add(SodiumExtrasOptionPages.extraPage());
    }
}