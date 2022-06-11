package io.papermc.exampleplugin;

import io.papermc.exampleplugin.commands.ExampleCommand;
import io.papermc.exampleplugin.events.ExampleEvent;
import org.bstats.bukkit.Metrics;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class ExamplePlugin extends JavaPlugin {
    public static int id = 12345; // Constant plugin id from bStats

    @Override
    public void onEnable() {
        // What should this plugin do on startup?

        getServer().getPluginManager().registerEvents(new ExampleEvent(), this);
        PluginCommand hello = getCommand("hello");
        hello.setExecutor(new ExampleCommand());

        // bStats metrics
        Metrics m = getMetrics(id);
    }

    @Override
    public void onDisable() {
        // Should this plugin do anything when it is disabled?
    }

    private @NotNull Metrics getMetrics(int serviceId) {
        return new Metrics(this, serviceId);
    }
}
