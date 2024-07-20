package me.gregzee.welcomer.utility;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public final class Utility {

	public String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public void playSound(Player player, Sound sound, float volume, float pitch) {
		player.playSound(player.getLocation(), sound, volume, pitch);
	}

	
}
