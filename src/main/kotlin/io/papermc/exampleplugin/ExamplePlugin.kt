package io.papermc.exampleplugin

import io.papermc.exampleplugin.commands.ExampleCommand
import io.papermc.exampleplugin.events.ExampleEvent
import org.bstats.bukkit.Metrics
import org.bukkit.plugin.java.JavaPlugin

class ExamplePlugin : JavaPlugin() {
    val id = 12345 // Constant plugin id from bStats

    override fun onEnable() {
        // What should this plugin do on startup?

        server.pluginManager.registerEvents(ExampleEvent(), this)
        val hello = getCommand("hello")
        hello!!.setExecutor(ExampleCommand())

        // bStats metrics
        val m = getMetrics(id)
    }

    override fun onDisable() {
        // Should this plugin do anything when it is disabled?
    }

    private fun getMetrics(serviceId: Int) = Metrics(this, serviceId)
}