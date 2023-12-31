package me.gregzee.welcomer.commands;

import me.gregzee.welcomer.Welcomer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    private final Welcomer plugin;

    public MainCommand(Welcomer plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        // Check if the command sender is a player
        if (!(commandSender instanceof Player p)) {
            Bukkit.getLogger().info("That command can only be run by players.");
            return false;
        }

        // Check the number of arguments provided in the command
        if (args.length == 1) {
            // Handle the '/welcomer reload' command
            if (args[0].equals("reload")) {
                // Reload the plugin's configuration
                plugin.reloadConfig();
                p.sendMessage(ChatColor.GREEN + "Configuration has been reloaded with no issues.");
                return true;
            } else if (args[0].equals("menu")) {
                // Handle the '/welcomer menu' command (code for the menu feature can be added here)
                // You can create an inventory menu and provide options for players
                // Example code for creating menu items is commented out
            } else {
                // Display the plugin's help message when an invalid argument is provided
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7-=-=-=-=-=-=-=-=- &a&nWelcomer &7-=-=-=-=-=-=-=-=-"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a "));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2✗ &a&n/welcomer reload &7--- &aReloads the configuration"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2✗ &a&n/welcomer help &7--- &aDisplays the help message (this)"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2✗ &a&n/welcomer menu &7--- &aIn-game menu to toggle different features &7(&csoon&7)"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2✗ &aMade by Gregzee <3"));
                return true;
            }
        }

        return true;
    }
}
