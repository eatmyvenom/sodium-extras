package io.github.eatmyvenom.sodiumExtras.options;

import com.google.common.collect.ImmutableList;
import me.jellysquid.mods.sodium.client.gui.options.OptionFlag;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;
import io.github.eatmyvenom.sodiumExtras.SodiumExtraFeatures;
import io.github.eatmyvenom.sodiumExtras.features.FullbrightFeature;

import java.util.ArrayList;
import java.util.List;

public class SodiumExtrasOptionPages {

    private static final SodiumExtraOptionStorage extraOpts = new SodiumExtraOptionStorage();

    public static OptionPage extraPage() {
        List<OptionGroup> groups = new ArrayList<>();

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Biome Colors")
                        .setTooltip("Biome colors change based on the biome")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.biomeColors = value, options -> options.options.biomeColors)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Sky colors")
                        .setTooltip("Have sky colors change based on biome")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.skycolors = value, options -> options.options.skycolors)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Rain senabled")
                        .setTooltip("Show rain when it rains")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.rain = value, options -> options.options.rain)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Show time")
                        .setTooltip("Show the current daytime by the sun")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.dayTime = value, options -> options.options.dayTime)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Render Paintings")
                        .setTooltip("Show paintings")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.renderPaintings = value, options -> options.options.renderPaintings)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Hurtcam")
                        .setTooltip("Shake the camera when the player is damaged")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.hurtcam = value, options -> options.options.hurtcam)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Toasts")
                        .setTooltip("Advancement and crafting recipe popups")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.toasts = value, options -> options.options.toasts)
                        .build())
                        
                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Static fov")
                        .setTooltip("Don't change fov based on speed or effects")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.staticFov = value, options -> options.options.staticFov)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Instant sneak")
                        .setTooltip("Don't lerp the camera to sneak")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.instantSneak = value, options -> options.options.instantSneak)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Light Updates")
                        .setTooltip("Process lighting updates")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.lightUpdates = value, options -> options.options.lightUpdates)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Piston Animations")
                        .setTooltip("Process piston animations")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.pistonAnimations = value, options -> options.options.pistonAnimations)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("No overlays")
                        .setTooltip("Disable camera overlays")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.noOverlay = value, options -> options.options.noOverlay)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Prevent Shaders")
                        .setTooltip("Prevents any types of shaders from loading")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.preventShaders = value, options -> options.options.preventShaders)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Fullbright")
                        .setTooltip("Make everything max brightness")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> {options.options.fullbright = value; SodiumExtraFeatures.fullbrightFeature.toggle(value); }, options -> options.options.fullbright)
                        .build())
                
                .build());

        return new OptionPage("Extras", ImmutableList.copyOf(groups));
    }
}