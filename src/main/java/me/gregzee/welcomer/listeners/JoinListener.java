package me.gregzee.welcomer.listeners;

import me.gregzee.welcomer.Welcomer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class JoinListener implements Listener {

    private final Welcomer plugin;

    public JoinListener(Welcomer plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();


        if (plugin.getConfig().getBoolean("MOTD.enabled")) {
            for (String message : plugin.getConfig().getStringList("MOTD.message")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.formatString(message, p)));
            }
        }

        if (plugin.getConfig().getBoolean("JoinWelcomer.enabled")) {
            if (!p.hasPlayedBefore()) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.formatString(plugin.getConfig().getString("JoinWelcomer.First-Join-Message"), p)));
            } else {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.formatString(plugin.getConfig().getString("JoinWelcomer.Join-Message"), p)));
            }
        }

        if (plugin.getConfig().getBoolean("TitleWelcomer.enabled")) {
            String title = ChatColor.translateAlternateColorCodes('&', plugin.formatString(plugin.getConfig().getString("TitleWelcomer.Title"), p));
            String subTitle = ChatColor.translateAlternateColorCodes('&', plugin.formatString(plugin.getConfig().getString("TitleWelcomer.SubTitle"), p));
            int fadeIn = plugin.getConfig().getInt("TitleWelcomer.FadeIn");
            int stay = plugin.getConfig().getInt("TitleWelcomer.Stay");
            int fadeOut = plugin.getConfig().getInt("TitleWelcomer.FadeOut");

            p.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
        }
    }
}
