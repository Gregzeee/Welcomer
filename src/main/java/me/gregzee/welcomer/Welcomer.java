package me.gregzee.welcomer;

import lombok.Getter;
import me.gregzee.welcomer.manager.ConfigManager;
import me.gregzee.welcomer.manager.StartupManager;
import me.gregzee.welcomer.utility.Utility;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;

/**
 * Main class for the plugin
 */
@Getter
public final class Welcomer extends JavaPlugin {

    @Getter
    private static final Utility utility = new Utility();

    @Getter
    private static final ConfigManager configManager = new ConfigManager();

    @Getter
	private static Welcomer instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        getConfig().options().copyDefaults();
        saveConfig();

        new StartupManager();

        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            getLogger().log(Level.INFO, "PlaceholderAPI found, enabling placeholders.");
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
        console.sendMessage(utility.colorize("&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        console.sendMessage(utility.colorize("                 &eWelcomer"));
        console.sendMessage(utility.colorize("            &eWelcomer has &aenabled"));
        console.sendMessage(utility.colorize("&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        console.sendMessage(utility.colorize("               &cMade by Gregzee"));
    }

    /**
     * Send a message to the console when the plugin is disabled
     */
    private void sendDisableMessage() {
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage(utility.colorize("&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        console.sendMessage(utility.colorize("                 &eWelcomer"));
        console.sendMessage(utility.colorize("            &eWelcomer has &cdisabled"));
        console.sendMessage(utility.colorize("&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        console.sendMessage(utility.colorize("               &cMade by Gregzee"));
    }
}
