package io.github.eatmyvenom.sodiumExtras;

import com.google.common.collect.ImmutableList;
import me.jellysquid.mods.sodium.client.gui.options.OptionFlag;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;

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
                        .setName("Hurtcam")
                        .setTooltip("Shake the camera when the player is damaged")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.hurtcam = value, options -> options.options.hurtcam)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Toasts")
                        .setTooltip("Advancement and crafting recipe popups")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.toasts = value, options -> options.options.toasts)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                        
                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Static fov")
                        .setTooltip("Don't change fov based on speed or effects")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.staticFov = value, options -> options.options.staticFov)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("Instant sneak")
                        .setTooltip("Don't lerp the camera to sneak")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.instantSneak = value, options -> options.options.instantSneak)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, extraOpts)
                        .setName("No overlays")
                        .setTooltip("Disable camera overlays")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.options.noOverlay = value, options -> options.options.noOverlay)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                
                .build());

        return new OptionPage("Extras", ImmutableList.copyOf(groups));
    }
}