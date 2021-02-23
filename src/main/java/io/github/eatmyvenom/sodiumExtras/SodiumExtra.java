package io.github.eatmyvenom.sodiumExtras;

import java.io.File;

import io.github.eatmyvenom.sodiumExtras.options.SodiumExtraSettings;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class SodiumExtra implements ClientModInitializer{

    private static SodiumExtraSettings settings; 
    public static final MinecraftClient MC = MinecraftClient.getInstance();

    @Override
    public void onInitializeClient() {
        
    }

    public static SodiumExtraSettings getSettings() {
        if(settings == null) 
            return settings = SodiumExtraSettings.loadFromJson(new File("config/sodium-extras-options.json"));
        else
            return settings;
    }
    
}