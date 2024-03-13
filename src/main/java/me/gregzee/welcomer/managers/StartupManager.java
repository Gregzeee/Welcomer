package me.gregzee.welcomer.managers;

import co.aikar.commands.PaperCommandManager;
import me.gregzee.welcomer.Welcomer;
import me.gregzee.welcomer.commands.PrimaryCommand;
import me.gregzee.welcomer.listener.JoinListener;
import me.gregzee.welcomer.listener.QuitListener;

public class StartupManager {

    private final Welcomer plugin;
    private final PaperCommandManager manager;

    public StartupManager(Welcomer plugin) {
        this.plugin = plugin;
        this.manager = plugin.getCommandManager();

        load();
    }

    private void load() {
        registerCommands();
        registerEvents();
    }

    private void registerCommands() {
        manager.registerCommand(new PrimaryCommand(this.plugin));
    }

    private void registerEvents() {
        plugin.getServer().getPluginManager().registerEvents(new JoinListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new QuitListener(), plugin);
    }
}