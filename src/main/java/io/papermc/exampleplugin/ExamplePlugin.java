package io.papermc.exampleplugin;

import io.papermc.exampleplugin.events.ExampleEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // What should this plugin do at startup?
        new ExampleEvent(this);
    }

    @Override
    public void onDisable() {
        // Has got this plugin anything to do when disabling it?
    }
}
