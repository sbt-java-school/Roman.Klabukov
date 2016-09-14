package ru.sbt.home11;

import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class PluginManagerTest {

    @Test
    public void testSystemLoaderAndPluginLoader() throws MalformedURLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        PluginManager pluginManager=new PluginManager("C:/Users/rmk/Documents/plugins");
        Plugin plugin=new TestPlugin();
        Plugin plugin1=pluginManager.load("Plugin", "ru.sbt.home11.TestPlugin");
        Assert.assertFalse(plugin.getClass()==plugin1.getClass());
    }


}