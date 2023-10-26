package me.gregzee.welcomer;

import me.gregzee.welcomer.TabCompleters.MainCommandCompleter;
import me.gregzee.welcomer.commands.MainCommand;
import me.gregzee.welcomer.listeners.QuitListener;
import me.gregzee.welcomer.listeners.JoinListener;
import me.gregzee.welcomer.listeners.MenuHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Welcomer extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // Load and save the default configuration if it doesn't exist
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Register event listeners for player joins, quits, and inventory clicks
        getServer().getPluginManager().registerEvents(new QuitListener(this), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new MenuHandler(this), this);

        // Register the main command and its tab completer
        getCommand("welcomer").setExecutor(new MainCommand(this));
        getCommand("welcomer").setTabCompleter(new MainCommandCompleter());

        // Log a message indicating that the plugin has started up without issues
        getLogger().info("-------------------------------");
        getLogger().info("Welcomer");
        getLogger().info("Made by Gregzee <3");
        getLogger().info("Started up with no issues.");
        getLogger().info("-------------------------------");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        // Save the configuration
        saveConfig();

        // Log a message indicating that the plugin has been disabled without issues
        getLogger().info("-------------------------------");
        getLogger().info("Welcomer");
        getLogger().info("Made by Gregzee <3");
        getLogger().info("Disabled with no issues.");
        getLogger().info("-------------------------------");
    }

    // Format a string by replacing placeholders with server and player information
    public String formatString(String message, Player p) {
        int onlinePlayers = Bukkit.getOnlinePlayers().size();
        String formattedMessage = message.replace("{ServerName}", getConfig().getString("Variables.ServerName"));
        formattedMessage = formattedMessage.replace("{ServerIP}", getConfig().getString("Variables.ServerIP"));
        formattedMessage = formattedMessage.replace("{ServerPort}", getConfig().getString("Variables.ServerPort"));
        formattedMessage = formattedMessage.replace("{Store}", getConfig().getString("Variables.ServerStore"));
        formattedMessage = formattedMessage.replace("{Discord}", getConfig().getString("Variables.ServerDiscord"));
        formattedMessage = formattedMessage.replace("{OnlinePlayers}", Integer.toString(onlinePlayers));
        formattedMessage = formattedMessage.replace("{PlayerName}", p.getName());
        formattedMessage = formattedMessage.replace("{PlayerDisplayName}", p.getDisplayName());
        formattedMessage = formattedMessage.replace("{MaxPlayers}", Integer.toString(Bukkit.getMaxPlayers()));

        return formattedMessage;
    }
}
