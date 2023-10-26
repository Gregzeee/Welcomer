package me.gregzee.welcomer.listeners;

import me.gregzee.welcomer.Welcomer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    private final Welcomer plugin;

    public QuitListener(Welcomer plugin) {
        this.plugin = plugin;
    }

    // This method is called when a player quits the server
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        // Get the player who quit
        Player p = e.getPlayer();

        // Check if the JoinWelcomer feature is enabled in the plugin's configuration
        if (plugin.getConfig().getBoolean("JoinWelcomer.enabled")) {
            // Broadcast a leave message to all players with color codes translated
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.formatString(plugin.getConfig().getString("JoinWelcomer.Leave-Message"), p)));
        }
    }
}
