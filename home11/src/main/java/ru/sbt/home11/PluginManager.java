package ru.sbt.home11;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PluginManager {

    private final String pluginRootDirectory;
    private PluginClassLoader pluginClassLoader;

    public PluginManager(final String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(final String pluginName, final String pluginClassName) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        pluginClassLoader = new PluginClassLoader(new URL[] {new URL("file://" + pluginRootDirectory + "/" + pluginName + "/")});
        Class<?> pluginClass = pluginClassLoader.loadClass(pluginClassName);
        Plugin plugin = (Plugin) pluginClass.newInstance();
        return plugin;
    }
}

