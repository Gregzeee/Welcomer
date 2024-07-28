package me.gregzee.welcomer.listener;

import me.gregzee.welcomer.Welcomer;
import me.gregzee.welcomer.manager.ConfigManager;
import me.gregzee.welcomer.utility.Utility;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Listener for player quit events
 */
public final class QuitListener implements Listener {

    private final Welcomer instance = Welcomer.getInstance();

    private final ConfigManager configManager = Welcomer.getConfigManager();

    private final Utility utility  = Welcomer.getUtility();

    public void onPlayerQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();

        String quitMessage = utility.parsePlaceholders(player, ConfigManager.QuitWelcome.getQuitMessage());

        if (!ConfigManager.QuitWelcome.isEnabled()) {
            event.setQuitMessage(null);
        } else {
            event.setQuitMessage(utility.colorize(quitMessage));
        }

    }
}
