package io.github.eatmyvenom.sodiumExtras.options;

import java.io.File;

import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;

public class SodiumExtraOptionStorage implements OptionStorage<SodiumExtraSettings>{

    private final SodiumExtraSettings extraOpts;

    public SodiumExtraOptionStorage() {
        extraOpts = SodiumExtraSettings.loadFromJson(new File("config/sodium-extra-options.json"));
    }

    @Override
    public SodiumExtraSettings getData() {
        return this.extraOpts;
    }

    @Override
    public void save() {
        this.extraOpts.writeToFile();
    }
    
}