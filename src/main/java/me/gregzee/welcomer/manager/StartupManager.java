package me.gregzee.welcomer.manager;

import me.gregzee.welcomer.Welcomer;
import me.gregzee.welcomer.command.PrimaryCommand;
import me.gregzee.welcomer.listener.JoinListener;
import me.gregzee.welcomer.listener.QuitListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;

public final class StartupManager {

    private final Welcomer instance = Welcomer.getInstance();

    public StartupManager() {
        load();
    }

    private void load() {
        registerCommands();
        registerEvents();
        enableBStats();
    }

    private void registerCommands() {
        instance.getCommand("welcomer").setExecutor(new PrimaryCommand());
    }

    private void registerEvents() {
        instance.getServer().getPluginManager().registerEvents(new JoinListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new QuitListener(), instance);
    }

    private void enableBStats() {
        try {
            new Metrics(instance, 21222);
        } catch (Exception e) {
            Bukkit.getLogger().warning("Something went wrong while enabling bStats.\n" + e.getMessage());
        }
    }
}