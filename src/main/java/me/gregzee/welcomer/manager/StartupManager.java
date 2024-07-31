package me.gregzee.welcomer.manager;

import me.gregzee.welcomer.Welcomer;
import me.gregzee.welcomer.command.PrimaryCommand;
import me.gregzee.welcomer.listener.JoinListener;
import me.gregzee.welcomer.listener.QuitListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;

/**
 * Used to load all necessary components
 */
public final class StartupManager {

    private final Welcomer instance = Welcomer.getInstance();

    private final ConfigManager configManager = Welcomer.getConfigManager();

    public StartupManager() {
        load();
    }

    /**
     * Load all necessary components
     */
    private void load() {
        if (instance == null) {
            Bukkit.getLogger().severe("Welcomer instance is null.");
            return;
        }

        instance.saveDefaultConfig();
        Bukkit.getLogger().info("[Welcomer] Default config saved.");

        Bukkit.getLogger().info("[Welcomer] Copied default config options.");
        instance.getConfig().options().copyDefaults(true);

        Bukkit.getLogger().info("[Welcomer] Config saved.");
        instance.saveConfig();

        Bukkit.getLogger().info("[Welcomer] Configuration file saved and defaults copied.");

        // Load the configuration settings
        configManager.load();
        Bukkit.getLogger().info("Configuration loaded.");

        registerCommands();
        registerEvents();
        enableBStats();
    }

    /**
     * Register all commands
     */
    private void registerCommands() {
        instance.getCommand("welcomer").setExecutor(new PrimaryCommand());
    }

    /**
     * Register all events
     */
    private void registerEvents() {
        instance.getServer().getPluginManager().registerEvents(new JoinListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new QuitListener(), instance);
    }

    /**
     * Enable bStats
     */
    private void enableBStats() {
        try {
            new Metrics(instance, 21222);
        } catch (Exception e) {
            Bukkit.getLogger().warning("Something went wrong while enabling bStats.\n" + e.getMessage());
        }
    }
}