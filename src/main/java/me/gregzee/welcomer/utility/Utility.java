package me.gregzee.welcomer.utility;

import com.destroystokyo.paper.Title;
import me.clip.placeholderapi.PlaceholderAPI;
import me.gregzee.welcomer.manager.ConfigManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for common methods
 */
public final class Utility {

	/**
	 * Colorizes a string
	 * @param message The message to colorize
	 * @return the colorized message
	 */
//	public String colorize(final String message) {
//		if (message == null) {
//			return null;
//		}
//
//		return ChatColor.translateAlternateColorCodes('&', message);
//	}

	// The pattern for hex colors
	private static final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");

	/**
	 * Colorizes a string with support for hex colors
	 * @param message The message to colorize
	 * @return the colorized message
	 */
	public String colorize(final String message) {
		if (message == null) {
			return null;
		}

		// Create a matcher for the hex pattern
		Matcher matcher = HEX_PATTERN.matcher(message);
		StringBuffer buffer = new StringBuffer();

		// Loop through the matches and replace them with the color
		while (matcher.find()) {
			String hexCode = matcher.group(1);
			matcher.appendReplacement(buffer, ChatColor.of("#" + hexCode).toString());
		}

		// Append the rest of the message
		matcher.appendTail(buffer);

		// Return the colorized message
		return ChatColor.translateAlternateColorCodes('&', buffer.toString());
	}

	/**
	 * Plays a sound to a player
	 * @param player The player to play the sound to
	 * @param sound The sound to play
	 * @param volume The volume of the sound
	 * @param pitch The pitch of the sound
	 */
	public void playSound(final Player player, final Sound sound, final float volume, final float pitch) {
		try {
			player.playSound(player.getLocation(), sound, volume, pitch);
		} catch (IllegalArgumentException iae) {
			Bukkit.getLogger().warning("Sound \"" + sound.toString() + "\" not supported. Using fallback sound.");
		} catch (Exception e) {
			Bukkit.getLogger().warning("An error occurred while playing a sound: " + e.getMessage());
		}
	}

	/**
	 * Replaces placeholders with their actual values in a string
	 * @param player The player to replace placeholders for
	 * @param message The message to replace placeholders in
	 * @return the message with placeholders replaced
	 */
	public String setPlaceholders(Player player, String message) {
		if (message == null) {
			Bukkit.getLogger().warning("Message is null in utility.setPlaceholders()");
			return "";
		}

		return PlaceholderAPI.setPlaceholders(player, message);
	}

	/**
	 * Loops through the MOTD messages and sends them to a player
	 * @param player The player to send the MOTD to
	 */
	public void loopMOTD(final Player player) {
		List<String> messages = ConfigManager.MOTD.getMessages();

		if (messages.isEmpty()) {
			Bukkit.getLogger().info("No MOTD messages found in configuration.");
		}

		for (String message : messages) {
			message = colorize(setPlaceholders(player, message));
			Bukkit.getLogger().info("Sending MOTD message to " + player.getName() + ": " + message);
			player.sendMessage(message);
		}
	}


	/**
	 * Sends a title to a player. FadeIn, Stay and FadeOut are automatically pulled from the config | Just a shorter version of {@link org.bukkit.entity.Player#sendTitle(String, String, int, int, int)}
	 * @param player The player to send the title to
	 * @param title The title to send
	 * @param subtitle The subtitle to send
	 */
	public void sendTitle(Player player, String title, String subtitle) {
		Title titleObj = Title.builder()
				.title(title)
				.subtitle(subtitle)
				.fadeIn(ConfigManager.Title.getFadeIn())
				.stay(ConfigManager.Title.getStay())
				.fadeOut(ConfigManager.Title.getFadeOut())
				.build();
		player.sendTitle(titleObj);
	}
}
