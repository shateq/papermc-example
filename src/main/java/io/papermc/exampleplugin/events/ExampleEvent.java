package io.papermc.exampleplugin.events;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import io.papermc.exampleplugin.ExamplePlugin;

public class ExampleEvent implements Listener {
    private static ExamplePlugin javaPlugin;

    public ExampleEvent(ExamplePlugin examplePlugin) {
        javaPlugin = examplePlugin;
        Bukkit.getPluginManager().registerEvents(this, javaPlugin);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPaperServerListPing(final PaperServerListPingEvent e) {
        Bukkit.getogger().info("Pong!");
    }
}
