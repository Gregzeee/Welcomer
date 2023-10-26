package me.gregzee.welcomer.listeners;

import me.gregzee.welcomer.Welcomer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private final Welcomer plugin;

    public JoinListener(Welcomer plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        // Check if MOTD (Message of the Day) is enabled
        if (plugin.getConfig().getBoolean("MOTD.enabled")) {
            // Loop through each message in the MOTD configuration
            for (String message : plugin.getConfig().getStringList("MOTD.message")) {
                // Send the message to the player with color codes translated
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.formatString(message, p)));
            }
        }

        // Check if JoinWelcomer is enabled
        if (plugin.getConfig().getBoolean("JoinWelcomer.enabled")) {
            // Check if the player has played before
            if (!p.hasPlayedBefore()) {
                // Broadcast the first join message with color codes translated
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.formatString(plugin.getConfig().getString("JoinWelcomer.First-Join-Message"), p)));
            } else {
                // Broadcast the regular join message with color codes translated
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.formatString(plugin.getConfig().getString("JoinWelcomer.Join-Message"), p)));
            }
        }

        // Check if TitleWelcomer is enabled
        if (plugin.getConfig().getBoolean("TitleWelcomer.enabled")) {
            // Get title and subtitle from the configuration with color codes translated
            String title = ChatColor.translateAlternateColorCodes('&', plugin.formatString(plugin.getConfig().getString("TitleWelcomer.Title"), p));
            String subTitle = ChatColor.translateAlternateColorCodes('&', plugin.formatString(plugin.getConfig().getString("TitleWelcomer.SubTitle"), p));

            // Get fade-in, stay, and fade-out times from the configuration
            int fadeIn = plugin.getConfig().getInt("TitleWelcomer.FadeIn");
            int stay = plugin.getConfig().getInt("TitleWelcomer.Stay");
            int fadeOut = plugin.getConfig().getInt("TitleWelcomer.FadeOut");

            // Send the title and subtitle to the player
            p.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
        }
    }
}
