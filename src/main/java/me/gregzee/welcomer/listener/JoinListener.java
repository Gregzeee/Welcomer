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

        // Debugging
        Bukkit.getLogger().info("MOTD Enabled: " + ConfigManager.MOTD.isEnabled());

        // Debugging
        if (ConfigManager.MOTD.getMessages() == null || ConfigManager.MOTD.getMessages().isEmpty()) {
            Bukkit.getLogger().warning("No MOTD messages found in the configuration.");

            /* MOTD */
            if (ConfigManager.MOTD.isEnabled()) {
                // loop through the MOTD messages and send them to the player
                utility.loopMOTD(player);
            }

            /* Join Message */
            if (ConfigManager.Join.isEnabled()) {

                final String joinMessage = player.hasPlayedBefore() ? ConfigManager.Join.getJoinMessage() : ConfigManager.Join.getFirstJoinMessage();

                if (joinMessage != null && !joinMessage.isEmpty()) {
                    final String formattedMessage = utility.setPlaceholders(player, joinMessage);
                    event.setJoinMessage(utility.colorize(formattedMessage));
                } else {
                    Bukkit.getLogger().warning("Join message is null or empty in the configuration.");
                }
            }

            /* Title */
            if (ConfigManager.Title.isEnabled()) {
                final String title = ConfigManager.Title.getTitle();
                final String subtitle = ConfigManager.Title.getSubtitle();

                if (title != null && subtitle != null) {
                    final String formattedTitle = utility.colorize(utility.setPlaceholders(player, title));
                    final String formattedSubtitle = utility.colorize(utility.setPlaceholders(player, subtitle));
                    utility.sendTitle(player, formattedTitle, formattedSubtitle);
                } else {
                    Bukkit.getLogger().warning("Title or subtitle is null in the configuration.");
                }
            }

            /* ActionBar */
            if (ConfigManager.ActionBar.isEnabled()) {
                final String actionBarMessage = ConfigManager.ActionBar.getMessage();
                if (actionBarMessage != null && !actionBarMessage.isEmpty()) {
                    final String formattedActionBarMessage = utility.colorize(utility.setPlaceholders(player, actionBarMessage));
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(formattedActionBarMessage));
                } else {
                    Bukkit.getLogger().warning("ActionBar message is null or empty in the configuration.");
                }
            }

            /* Sound */
            if (ConfigManager.Sound.isEnabled()) {
                try {
                    String soundName = ConfigManager.Sound.getSound();
                    Sound sound = Sound.valueOf(soundName);
                    float volume = ConfigManager.Sound.getVolume();
                    float pitch = ConfigManager.Sound.getPitch();
                    utility.playSound(player, sound, volume, pitch);
                } catch (IllegalArgumentException e) {
                    Bukkit.getLogger().warning("Invalid sound specified in config: " + ConfigManager.Sound.getSound());
                }
            }
        }
        // TODO - Fix this stupid nesting here - ugly
        // TODO - Make code more readable
    }
}