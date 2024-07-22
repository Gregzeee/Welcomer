package me.gregzee.welcomer.manager;

import me.gregzee.welcomer.Welcomer;

import java.util.List;

public final class ConfigManager {

	private final Welcomer instance = Welcomer.getInstance();

	private String prefix;

	private String reloadPermission;

	private String menuPermission;

	private String noPermissionMessage;

	private static final class MOTD {

		private static boolean enabled;

		private static List<String> messages;
	}

	private static final class JoinWelcome {

		private static boolean enabled;

		private static String firstJoinMessage;

		private static String joinMessage;
	}

	private static final class QuitWelcome {

		private static boolean enabled;

		private static String quitMessage;
	}

	private static final class TitleWelcome {

		private static boolean enabled;

		private static String title;

		private static String subtitle;

		private static int fadeIn;

		private static int stay;

		private static int fadeOut;
	}

	private static final class ActionBarWelcome {

		private static boolean enabled;

		private static String message;

		private static final class Sound {

			private static boolean enabled;

			private static org.bukkit.Sound sound;

			private static float volume;

			private static float pitch;
		}
	}

	private static final class GUI {

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
