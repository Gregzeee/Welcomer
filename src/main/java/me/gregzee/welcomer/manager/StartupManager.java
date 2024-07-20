package me.gregzee.welcomer.manager;

import me.gregzee.welcomer.Welcomer;
import me.gregzee.welcomer.command.PrimaryCommand;
import me.gregzee.welcomer.listener.JoinListener;
import me.gregzee.welcomer.listener.QuitListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;

public class StartupManager {

    private final Welcomer plugin;

    public StartupManager(Welcomer plugin) {
        this.plugin = plugin;

        load();
    }

    private void load() {
        registerCommands();
        registerEvents();
        enableBStats();
    }

    private void registerCommands() {
        plugin.getCommand("welcomer").setExecutor(new PrimaryCommand());
    }

    private void registerEvents() {
        plugin.getServer().getPluginManager().registerEvents(new JoinListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new QuitListener(), plugin);
    }

    private void enableBStats() {
        try {
            new Metrics(plugin, 21222);
        } catch (Exception e) {
            Bukkit.getLogger().warning("Something went wrong while enabling bStats.\n" + e.getMessage());
        }
    }
}