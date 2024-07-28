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
	public static final class JoinWelcome {

		@Getter
		private static boolean enabled;

		@Getter
		private static String firstJoinMessage;

		@Getter
		private static String joinMessage;
	}

	@Getter
	public static final class QuitWelcome {

		@Getter
		private static boolean enabled;

		@Getter
		private static String quitMessage;
	}

	@Getter
	public static final class TitleWelcome {

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
	public static final class ActionBarWelcome {

		@Getter
		private static boolean enabled;

		@Getter
		private static String message;


		// TODO - Make an independent place for Sound
		@Getter
		private static final class Sound {

			@Getter
			private static boolean enabled;

			@Getter
			private static org.bukkit.Sound sound;

			@Getter
			private static float volume;

			@Getter
			private static float pitch;
		}
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
		reloadPermission = getString("ReloadPermission");
		menuPermission = getString("MenuPermission");
		noPermissionMessage = getString("NoPermissionMessage");

		// MOTD
		MOTD.enabled = getBoolean("MOTD.Enabled");
		MOTD.messages = getStringList("MOTD.Messages");

		// JoinWelcome
		JoinWelcome.enabled = getBoolean("JoinWelcome.Enabled");
		JoinWelcome.firstJoinMessage = getString("JoinWelcome.First-Join-Message");
		JoinWelcome.joinMessage = getString("JoinWelcome.Join-Message");

		// QuitWelcome
		QuitWelcome.enabled = getBoolean("QuitWelcome.Enabled");
		QuitWelcome.quitMessage = getString("QuitWelcome.Quit-Message");

		// TitleWelcome
		TitleWelcome.enabled = getBoolean("TitleWelcome.Enabled");
		TitleWelcome.title = getString("TitleWelcome.Title");
		TitleWelcome.subtitle = getString("TitleWelcome.Subtitle");
		TitleWelcome.fadeIn = getInt("TitleWelcome.FadeIn");
		TitleWelcome.stay = getInt("TitleWelcome.Stay");
		TitleWelcome.fadeOut = getInt("TitleWelcome.FadeOut");

		// ActionBarWelcome
		ActionBarWelcome.enabled = getBoolean("ActionBarWelcome.Enabled");
		ActionBarWelcome.message = getString("ActionBarWelcome.Message");
		ActionBarWelcome.Sound.enabled = getBoolean("ActionBarWelcome.Sound.Enabled");
		ActionBarWelcome.Sound.sound = org.bukkit.Sound.valueOf(getString("ActionBarWelcome.Sound.Sound"));
		ActionBarWelcome.Sound.volume = (float) getDouble("ActionBarWelcome.Sound.Volume");
		ActionBarWelcome.Sound.pitch = (float) getDouble("ActionBarWelcome.Sound.Pitch");

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
