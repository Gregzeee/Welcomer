package me.gregzee.welcomer.managers;

import co.aikar.commands.PaperCommandManager;
import me.gregzee.welcomer.Welcomer;
import me.gregzee.welcomer.commands.TestCommand;

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
        manager.registerCommand(new TestCommand(this.plugin));
    }

    private void registerEvents() {
        // Register events here
    }
}