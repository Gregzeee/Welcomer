package me.gregzee.welcomer.manager;

import lombok.Getter;
import me.gregzee.welcomer.Welcomer;
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
	}
	
	private String getString(String path) {
		return instance.getConfig().getString(path);
	}

	private boolean getBoolean(String path) {
		return instance.getConfig().getBoolean(path);
	}

	private List<String> getStringList(String path) {
		return instance.getConfig().getStringList(path);
	}

	private int getInt(String path) {
		return instance.getConfig().getInt(path);
	}

	private double getDouble(String path) {
		return instance.getConfig().getDouble(path);
	}
}
