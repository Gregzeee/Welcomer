package me.gregzee.welcomer.manager;

import lombok.Getter;
import me.gregzee.welcomer.Welcomer;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

/**
 * Used to manage all the configuration options
 */
public final class ConfigManager {

	private final Welcomer instance = Welcomer.getInstance();

	@Getter
	private static String prefix;

	@Getter
	private static String reloadPermission;

	@Getter
	private static String menuPermission;

	@Getter
	private static String noPermissionMessage;

	@Getter
	public static final class MOTD {

		@Getter
		private static boolean enabled;

		@Getter
		private static List<String> messages;
	}

	@Getter
	public static final class Join {

		@Getter
		private static boolean enabled;

		@Getter
		private static String firstJoinMessage;

		@Getter
		private static String joinMessage;
	}

	@Getter
	public static final class Quit {

		@Getter
		private static boolean enabled;

		@Getter
		private static String quitMessage;
	}

	@Getter
	public static final class Title {

		@Getter
		private static boolean enabled;

		@Getter
		private static String title;

		@Getter
		private static String subtitle;

		@Getter
		private static int fadeIn;

		@Getter
		private static int stay;

		@Getter
		private static int fadeOut;
	}

	@Getter
	public static final class ActionBar {

		@Getter
		private static boolean enabled;

		@Getter
		private static String message;
	}

	@Getter
	public static final class Sound {

		@Getter
		private static boolean enabled;

		@Getter
		private static String sound;

		@Getter
		private static float volume;

		@Getter
		private static float pitch;
	}

	@Getter
	public static final class GUI {

		@Getter
		private static boolean enabled;
	}

	/**
	 * Load the configuration file
	 */
	public void load() {
		FileConfiguration config = instance.getConfig();
		if (config == null) {
			instance.getLogger().severe("Config is null in ConfigManager.load()");
			return;
		}

		// General
		prefix = getString("Prefix");
		noPermissionMessage = getString("NoPermissionMessage");

		// MOTD
		MOTD.enabled = getBoolean("MOTD.Enabled");
		MOTD.messages = getStringList("MOTD.Messages");

		// Join
		Join.enabled = getBoolean("Join.Enabled");
		Join.firstJoinMessage = getString("Join.First-Join-Message");
		Join.joinMessage = getString("Join.Join-Message");

		// Quit
		Quit.enabled = getBoolean("Quit.Enabled");
		Quit.quitMessage = getString("Quit.Quit-Message");

		// Title
		Title.enabled = getBoolean("Title.Enabled");
		Title.title = getString("Title.Title");
		Title.subtitle = getString("Title.Subtitle");
		Title.fadeIn = getInt("Title.FadeIn");
		Title.stay = getInt("Title.Stay");
		Title.fadeOut = getInt("Title.FadeOut");

		// ActionBar
		ActionBar.enabled = getBoolean("ActionBar.Enabled");
		ActionBar.message = getString("ActionBar.Message");

		// Sound
		Sound.enabled = getBoolean("Sound.Enabled");
		Sound.sound = getString("Sound.Sound");
		Sound.volume = (float) getDouble("Sound.Volume");
		Sound.pitch = (float) getDouble("Sound.Pitch");

		// GUI
		GUI.enabled = getBoolean("GUI.Enabled");
//
//		// Debug output | Used for testing
//		debug();
	}

	/********************************************************************************************/
	/*                 Short versions of instance.getConfig().get...(path);                     */

	/**
	 * Get a string from the configuration file
	 * @param path The path to the string
	 * @return The string
	 */
	private String getString(String path) {
		return instance.getConfig().getString(path);
	}

	/**
	 * Get a boolean from the configuration file
	 * @param path The path to the boolean
	 * @return The boolean
	 */
	private boolean getBoolean(String path) {
		return instance.getConfig().getBoolean(path);
	}

	/**
	 * Get a list of strings from the configuration file
	 * @param path The path to the list
	 * @return The list
	 */
	private List<String> getStringList(String path) {
		return instance.getConfig().getStringList(path);
	}

	/**
	 * Get an integer from the configuration file
	 * @param path The path to the integer
	 * @return The integer
	 */
	private int getInt(String path) {
		return instance.getConfig().getInt(path);
	}

	/**
	 * Get a double from the configuration file
	 * @param path The path to the double
	 * @return The double
	 */
	private double getDouble(String path) {
		return instance.getConfig().getDouble(path);
	}

	/*                 Short versions of instance.getConfig().get...(path);                     */
	/********************************************************************************************/

	/**
	 * Log the configuration values for debugging | Used for testing
	 */
	public void debug() {
		// General
		Bukkit.getLogger().info("Prefix: " + prefix);
		Bukkit.getLogger().info("No Permission Message: " + noPermissionMessage);

		// MOTD
		Bukkit.getLogger().info("MOTD Enabled: " + MOTD.enabled);
		Bukkit.getLogger().info("MOTD Messages: " + MOTD.messages);

		// Join
		Bukkit.getLogger().info("Join Enabled: " + Join.enabled);
		Bukkit.getLogger().info("First Join Message: " + Join.firstJoinMessage);
		Bukkit.getLogger().info("Join Message: " + Join.joinMessage);

		// Quit
		Bukkit.getLogger().info("Quit Enabled: " + Quit.enabled);
		Bukkit.getLogger().info("Quit Message: " + Quit.quitMessage);

		// Title
		Bukkit.getLogger().info("Title Enabled: " + Title.enabled);
		Bukkit.getLogger().info("Title: " + Title.title);
		Bukkit.getLogger().info("Subtitle: " + Title.subtitle);
		Bukkit.getLogger().info("FadeIn: " + Title.fadeIn);
		Bukkit.getLogger().info("Stay: " + Title.stay);
		Bukkit.getLogger().info("FadeOut: " + Title.fadeOut);

		// ActionBar
		Bukkit.getLogger().info("ActionBar Enabled: " + ActionBar.enabled);
		Bukkit.getLogger().info("ActionBar Message: " + ActionBar.message);

		// Sound
		Bukkit.getLogger().info("Sound Enabled: " + Sound.enabled);
		Bukkit.getLogger().info("Sound: " + Sound.sound);
		Bukkit.getLogger().info("Volume: " + Sound.volume);
		Bukkit.getLogger().info("Pitch: " + Sound.pitch);

		// GUI
		Bukkit.getLogger().info("GUI Enabled: " + GUI.enabled);
	}
}
