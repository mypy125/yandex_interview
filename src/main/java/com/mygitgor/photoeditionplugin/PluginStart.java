package com.mygitgor.photoeditionplugin;

import java.util.List;

public class PluginStart {
    public static void main(String[] args) {
        PluginManager manager = new PluginManager();
        manager.registerPlugin(new GrayscalePlugin());

        Image image = new Image("cat.png");

        ImageEffect effect1 = new ImageEffect("grayscale", null);
        ImageEffect effect2 = new ImageEffect("nonexistent", 123);

        ImageProcessingRequest request = new ImageProcessingRequest(
                image,
                List.of(effect1, effect2)
        );

        ImageProcessor processor = new ImageProcessor(manager);
        processor.process(request);
    }
}
