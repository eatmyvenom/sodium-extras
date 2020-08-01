package io.github.eatmyvenom.sodiumExtras;

import java.io.File;

import net.fabricmc.api.ClientModInitializer;

public class SodiumExtra implements ClientModInitializer{

    private static SodiumExtraSettings settings; 

    @Override
    public void onInitializeClient() {
        
    }

    public static SodiumExtraSettings getSettings() {
        if(settings == null) 
            return settings = SodiumExtraSettings.loadFromJson(new File("config/sodium-extra-options.json"));
        else
            return settings;
    }
    
}