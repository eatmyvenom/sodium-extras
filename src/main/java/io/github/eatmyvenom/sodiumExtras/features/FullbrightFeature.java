package io.github.eatmyvenom.sodiumExtras.features;

import io.github.eatmyvenom.sodiumExtras.SodiumExtra;

public class FullbrightFeature implements Feature{

    public void onEnabled() {
        SodiumExtra.MC.options.gamma = 16;
    }

    public void onDisabled() {
        SodiumExtra.MC.options.gamma = 1;
    }
}