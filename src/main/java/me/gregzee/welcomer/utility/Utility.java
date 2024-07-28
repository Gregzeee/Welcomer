package me.gregzee.welcomer.utility;

import me.clip.placeholderapi.PlaceholderAPI;
import me.gregzee.welcomer.manager.ConfigManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Utility class for common methods
 */
public final class Utility {

	/**
	 * Colorizes a string
	 * @param message The message to colorize
	 * @return the colorized message
	 */
	public String colorize(final String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	/**
	 * Plays a sound to a player
	 * @param player The player to play the sound to
	 * @param sound The sound to play
	 * @param volume The volume of the sound
	 * @param pitch The pitch of the sound
	 */
	public void playSound(final Player player, final Sound sound, final float volume, final float pitch) {
		player.playSound(player.getLocation(), sound, volume, pitch);
	}

	/**
	 * Replaces placeholders with their actual values in a string
	 * @param player The player to replace placeholders for
	 * @param message The message to replace placeholders in
	 * @return the message with placeholders replaced
	 */
	public String parsePlaceholders(final Player player, final String message) {
		return PlaceholderAPI.setPlaceholders(player, message);
	}

	public void loopMOTD(final Player player) {
		for (String message : ConfigManager.MOTD.getMessages()) {
			player.sendMessage(colorize(parsePlaceholders(player, message)));
		}
	}

	public void sendTitle(Player player, String title, String subtitle) {
		player.sendTitle(
				title,
				subtitle,
				ConfigManager.TitleWelcome.getFadeIn(),
				ConfigManager.TitleWelcome.getStay(),
				ConfigManager.TitleWelcome.getFadeOut()
		);
	}
}
