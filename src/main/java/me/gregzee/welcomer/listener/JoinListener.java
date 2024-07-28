package me.gregzee.welcomer.listener;

import me.gregzee.welcomer.Welcomer;
import me.gregzee.welcomer.manager.ConfigManager;
import me.gregzee.welcomer.utility.Utility;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

// TODO - Add more comments
/**
 * Listener for player join events
 */
public final class JoinListener implements Listener {

    private final Utility utility = Welcomer.getUtility();

    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        /* MOTD */
        if (ConfigManager.MOTD.isEnabled()) {
            utility.loopMOTD(player);
        }

        /* Join Message */
        if (ConfigManager.JoinWelcome.isEnabled()) {
            final String joinMessage = ConfigManager.JoinWelcome.getJoinMessage();

            if (player.hasPlayedBefore()) {
                event.setJoinMessage(utility.colorize(utility.parsePlaceholders(player, joinMessage)));
            } else {
                event.setJoinMessage(utility.colorize(utility.parsePlaceholders(player, ConfigManager.JoinWelcome.getFirstJoinMessage())));
            }
        }

        /* Title */
        if (ConfigManager.TitleWelcome.isEnabled()) {
            final String title = utility.colorize(utility.parsePlaceholders(player, ConfigManager.TitleWelcome.getTitle()));
            final String subtitle = utility.colorize(utility.parsePlaceholders(player, ConfigManager.TitleWelcome.getSubtitle()));

            utility.sendTitle(player, title, subtitle);
        }

        /* ActionBar */
        if (ConfigManager.ActionBarWelcome.isEnabled()) {
            final String actionBarMessage = utility.colorize(utility.parsePlaceholders(player, ConfigManager.ActionBarWelcome.getMessage()));

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(actionBarMessage));
            // TODO - Move to adventure
            // TODO - Move sound to its own place and then use it here
        }
    }
}
