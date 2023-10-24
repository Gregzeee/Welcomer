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

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        if (plugin.getConfig().getBoolean("JoinWelcomer.enabled")) {

            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.formatString(plugin.getConfig().getString("JoinWelcomer.Leave-Message"), p)));

        }
    }
}
