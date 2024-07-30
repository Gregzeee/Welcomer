package me.gregzee.welcomer.listener;

import me.gregzee.welcomer.Welcomer;
import me.gregzee.welcomer.manager.ConfigManager;
import me.gregzee.welcomer.utility.Utility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.logging.Level;

/**
 * Listener for player quit events
 */
public final class QuitListener implements Listener {

    private final Utility utility  = Welcomer.getUtility();

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        final Player player = event.getPlayer();

        if (ConfigManager.Quit.isEnabled()) {
            final String quitMessage = utility.colorize(utility.setPlaceholders(player, ConfigManager.Quit.getQuitMessage()));

            event.setQuitMessage(quitMessage);
        }
    }
}
