package me.gregzee.welcomer.utility;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public final class Utility {

	/**
	 * Colorizes a string
	 * @param message
	 * @return
	 */
	public String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	/**
	 * Plays a sound to a player
	 * @param player
	 * @param sound
	 * @param volume
	 * @param pitch
	 */
	public void playSound(Player player, Sound sound, float volume, float pitch) {
		player.playSound(player.getLocation(), sound, volume, pitch);
	}

	
}
