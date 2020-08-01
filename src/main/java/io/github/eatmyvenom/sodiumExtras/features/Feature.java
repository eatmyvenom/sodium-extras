package io.github.eatmyvenom.sodiumExtras.features;

public interface Feature {
    public void onEnabled();
    public void onDisabled();

    default void toggle(Boolean enabled) {
        if(enabled) {
            onEnabled();
        } else {
            onDisabled();
        }
    }
}