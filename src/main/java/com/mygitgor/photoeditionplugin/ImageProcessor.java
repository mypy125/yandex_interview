package com.mygitgor.photoeditionplugin;

public class ImageProcessor {
    private final PluginManager pluginManager;

    public ImageProcessor(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    public void process(ImageProcessingRequest request) {
        for (ImageEffect effect : request.effects()) {
            Plugin plugin = pluginManager.getPlugin(effect.pluginName());

            if (plugin == null) {
                System.out.println("Plugin not found " + effect.pluginName());
                continue;
            }

            if (!plugin.validateParameter(effect.parameter())) {
                System.out.println("Invalid parameter for plugin " + effect.pluginName());
                continue;
            }

            plugin.applyImage(request.image(), effect.parameter());
        }
    }

}
