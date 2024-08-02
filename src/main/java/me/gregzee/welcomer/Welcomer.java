package me.gregzee.welcomer;

import lombok.Getter;
import me.gregzee.welcomer.manager.ConfigManager;
import me.gregzee.welcomer.manager.StartupManager;
import me.gregzee.welcomer.utility.Utility;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Main class for the plugin
 */
@Getter
public final class Welcomer extends JavaPlugin {

    @Getter
    private static Utility utility;

    @Getter
    private static ConfigManager configManager;

    @Getter
    private static Welcomer instance;

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().severe("PlaceholderAPI not found, disabling");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        instance = this;
        utility = new Utility();
        configManager = new ConfigManager();

        new StartupManager();

        File configFile = new File(instance.getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            Bukkit.getLogger().severe("Configuration file does not exist.");
        } else {
            Bukkit.getLogger().info("Configuration file exists");
        }

        sendEnableMessage();
    }

    @Override
    public void onDisable() {
        saveConfig();
        sendDisableMessage();
    }

    /**
     * Send a message to the console when the plugin is enabled
     */
    private void sendEnableMessage() {
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage("");
        console.sendMessage(utility.colorize("&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        console.sendMessage(utility.colorize("                 &eWelcomer"));
        console.sendMessage(utility.colorize("            &eWelcomer has &aenabled"));
        console.sendMessage(utility.colorize("&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        console.sendMessage(utility.colorize("               &cMade by Gregzee"));
        console.sendMessage("");
    }

    /**
     * Send a message to the console when the plugin is disabled
     */
    private void sendDisableMessage() {
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage("");
        console.sendMessage(utility.colorize("&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        console.sendMessage(utility.colorize("                 &eWelcomer"));
        console.sendMessage(utility.colorize("            &eWelcomer has &cdisabled"));
        console.sendMessage(utility.colorize("&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        console.sendMessage(utility.colorize("               &cMade by Gregzee"));
        console.sendMessage("");
    }
}
