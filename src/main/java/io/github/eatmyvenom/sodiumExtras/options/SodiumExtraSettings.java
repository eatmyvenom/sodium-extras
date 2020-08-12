package io.github.eatmyvenom.sodiumExtras.options;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.github.eatmyvenom.sodiumExtras.SodiumExtraFeatures;

public class SodiumExtraSettings {

    public final Settings options = new Settings();

    public static class Settings {
        public boolean biomeColors = true;
        public boolean skycolors = true;
        public boolean hurtcam = true;
        public boolean toasts = true;
        public boolean staticFov = false;
        public boolean instantSneak = false;
        public boolean noOverlay = false;
        public boolean preventShaders = false;
        public boolean fullbright = false;
        public boolean rain = true;
        public boolean dayTime = true;
        public boolean lightUpdates = true;
        public boolean pistonAnimations = true;
    }

    private void initFeatures() {
        SodiumExtraFeatures.fullbrightFeature.toggle(options.fullbright);
    }
    
    private File jsonFile;
    private static final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).excludeFieldsWithModifiers(Modifier.PRIVATE).create();

    public static SodiumExtraSettings loadFromJson(File file) {
        SodiumExtraSettings settings;
        
        if(file.exists()) {
            try{ 
                FileReader reader = new FileReader(file);
                settings = gson.fromJson(reader, SodiumExtraSettings.class);
            } catch (IOException e) {
                throw new RuntimeException("Wat", e);
            }
            
        } else {
            settings = new SodiumExtraSettings();
        }
        settings.jsonFile = file;

        settings.writeToFile();
        settings.initFeatures();
        return settings;
    }

    public void writeToFile() {
        File parent = this.jsonFile.getParentFile();
        
        if(!parent.exists()) {
            boolean canMakeDir = parent.mkdirs();
            if(!canMakeDir) {
                throw new RuntimeException("There was an error when you tried to save the file, it like cant exist there :(");
            }
        }

        try (FileWriter writer = new FileWriter(jsonFile)){
            gson.toJson(this, writer);
        } catch (IOException e) {
            throw new RuntimeException("Yea it cant write the file. Idk why but uh yea");
        }


    }
    
    
}