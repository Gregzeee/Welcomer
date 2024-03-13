package me.gregzee.welcomer.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
    }
}
