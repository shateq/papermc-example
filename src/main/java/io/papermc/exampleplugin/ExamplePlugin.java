package io.papermc.exampleplugin;

import io.papermc.exampleplugin.commands.ExampleCommand;
import io.papermc.exampleplugin.events.ExampleEvent;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // What should this plugin do on startup?
        new ExampleEvent(this);
        PluginCommand hello = getCommand("hello");
        hello.setExecutor(new ExampleCommand());
    }

    @Override
    public void onDisable() {
        // Should this plugin do anything when it is disabled?
    }

}
