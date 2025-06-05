package com.mygitgor.photoeditionplugin;

import java.util.HashMap;
import java.util.Map;

public class PluginManager {
    private final Map<String, Plugin> plugins = new HashMap<>();

    public void registerPlugin(Plugin plugin) {
        plugins.put(plugin.getName(), plugin);
    }

    public Plugin getPlugin(String name) {
        return plugins.get(name);
    }

    public boolean isPluginAvailable(String name) {
        return plugins.containsKey(name);
    }
}
