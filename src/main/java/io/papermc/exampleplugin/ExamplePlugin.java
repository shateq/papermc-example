package io.papermc.exampleplugin;

import io.papermc.exampleplugin.commands.ExampleCommand;
import io.papermc.exampleplugin.events.ExampleEvent;
import org.bstats.bukkit.Metrics;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;


public final class ExamplePlugin extends JavaPlugin {
    public static int id = 12345; // Constant plugin id

    @Override
    public void onEnable() {
        // What should this plugin do on startup?
        Metrics m = getMetrics(id);

        new ExampleEvent(this);
        PluginCommand hello = getCommand("hello");
        hello.setExecutor(new ExampleCommand());
    }

    @Override
    public void onDisable() {
        // Should this plugin do anything when it is disabled?
    }

    private @NotNull Metrics getMetrics(int serviceId) {
        return new Metrics(this, serviceId);
    }
}
