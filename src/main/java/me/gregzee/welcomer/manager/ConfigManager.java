package me.gregzee.welcomer.manager;

import me.gregzee.welcomer.Welcomer;

public final class ConfigManager {

	private final Welcomer instance = Welcomer.getInstance();

	private String prefix;

	private String reloadPermission;

	private String menuPermission;

	private String noPermissionMessage;

	private static final class MOTD {

		private boolean enabled;

		private String[] messages;
	}

	private static final class JoinWelcome {

		private boolean enabled;

		private String firstJoinMessage;

		private String joinMessage;
	}

	private static final class QuitWelcome {

		private boolean enabled;

		private String quitMessage;
	}

	private static final class TitleWelcome {

		private boolean enabled;

		private String title;

		private String subtitle;

		private int fadeIn;

		private int stay;

		private int fadeOut;
	}

	private static final class ActionBarWelcome {

		private boolean enabled;

		private String message;

		private final class Sound {

			private boolean enabled;

			private org.bukkit.Sound sound;

			private float volume;

			private float pitch;
		}
	}

	private static final class GUI {

		private boolean enabled;
	}

	public void load() {
		prefix = getString("prefix");
		reloadPermission = getString("reload-permission");
		menuPermission = getString("menu-permission");
		noPermissionMessage = getString("no-permission-message");
	}

	private String getString(String path) {
		return instance.getConfig().getString(path);
	}

	private boolean getBoolean(String path) {
		return instance.getConfig().getBoolean(path);
	}
}
