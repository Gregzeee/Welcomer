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

        if (!(commandSender instanceof Player p)) {
            Bukkit.getLogger().info("That command can only be run by players.");
            return false;
        }

        if (args.length == 1) {
            if (args[0].equals("reload")) {
                plugin.reloadConfig();
                p.sendMessage(ChatColor.GREEN + "Configuration has been reloaded with no issues.");
                return true;
            } else if (args[0].equals("menu")) {
//                Inventory mainMenu = Bukkit.createInventory(p, InventoryType.HOPPER, ChatColor.translateAlternateColorCodes('&', "                    Welcomer Configuration"));
//
//                if (plugin.getConfig().getBoolean("JoinWelcomer.enabled")) {
//                    ItemStack joinWelcomer = new ItemStack(Material.GREEN_CONCRETE);
//                    ItemMeta joinWelcomerMeta = joinWelcomer.getItemMeta();
//                    joinWelcomerMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2✓ &aJoin and leave welcomer"));
//                    joinWelcomer.setItemMeta(joinWelcomerMeta);
//                } else if (!plugin.getConfig().getBoolean("JoinWelcomer.enabled")) {
//                    ItemStack joinWelcomer = new ItemStack(Material.RED_CONCRETE);
//                    ItemMeta joinWelcomerMeta = joinWelcomer.getItemMeta();
//                    joinWelcomerMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2✓ &aJoin and leave welcomer"));
//                    joinWelcomer.setItemMeta(joinWelcomerMeta);
//                }
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7-=-=-=-=-=-=-=-=- &a&nWelcomer &7-=-=-=-=-=-=-=-=-"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a "));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2✗ &a&n/welcomer reload &7--- &aReloads the configuration"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2✗ &a&n/welcomer help &7--- &aDisplays the help message(this)"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2✗ &a&n/welcomer menu &7--- &ain-game menu to toggle different features &7(&csoon&7)"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2✗ &aMade by Gregzee <3"));
                return true;
            }
        }
        return true;
    }
}
