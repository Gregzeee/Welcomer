package me.gregzee.welcomer.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
    }
}
