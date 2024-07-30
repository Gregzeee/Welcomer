package me.gregzee.welcomer.listener;

import me.gregzee.welcomer.Welcomer;
import me.gregzee.welcomer.manager.ConfigManager;
import me.gregzee.welcomer.utility.Utility;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Listener for player join events
 */
public final class JoinListener implements Listener {

    private final Utility utility = Welcomer.getUtility();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        /* MOTD */
        if (ConfigManager.MOTD.isEnabled()) {
            utility.loopMOTD(player);
        }

        /* Join Message */
        if (ConfigManager.Join.isEnabled()) {
            final String joinMessage = ConfigManager.Join.getJoinMessage();

            if (player.hasPlayedBefore()) {
                Bukkit.broadcastMessage(utility.colorize(utility.setPlaceholders(player, joinMessage)));
            } else {
                Bukkit.broadcastMessage(utility.colorize(utility.setPlaceholders(player, ConfigManager.Join.getFirstJoinMessage())));
            }
        }

        /* Title */
        if (ConfigManager.Title.isEnabled()) {
            final String title = utility.colorize(utility.setPlaceholders(player, ConfigManager.Title.getTitle()));
            final String subtitle = utility.colorize(utility.setPlaceholders(player, ConfigManager.Title.getSubtitle()));

            utility.sendTitle(player, title, subtitle);
        }

        /* ActionBar */
        if (ConfigManager.ActionBar.isEnabled()) {
            final String actionBarMessage = utility.colorize(utility.setPlaceholders(player, ConfigManager.ActionBar.getMessage()));

            // TODO - Move to adventure
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(actionBarMessage));
        }

        /* Sound */
        if (ConfigManager.Sound.isEnabled()) {
            player.playSound(player.getLocation(), Sound.valueOf(ConfigManager.Sound.getSound()), ConfigManager.Sound.getVolume(), ConfigManager.Sound.getPitch());
        }
    }
}
