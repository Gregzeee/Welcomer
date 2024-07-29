package me.gregzee.welcomer.handler;

import me.gregzee.welcomer.Welcomer;
import me.gregzee.welcomer.manager.ConfigManager;
import me.gregzee.welcomer.utility.Utility;
import org.bukkit.command.CommandSender;

public final class PrimaryCommandHandler {

	private static final ConfigManager configManager = Welcomer.getConfigManager();
	private static final Utility utility = Welcomer.getUtility();

	/**
	 * Handles the menu command
	 * @param sender The player who executed the command
	 */
	public static boolean handleMenuCommand(final CommandSender sender) {
		// handle menu command
		return true;
	}

	/**
	 * Handles the reload command
	 * @param sender The player who executed the command
	 */
	public static boolean handleReloadCommand(final CommandSender sender) {
		if (!sender.hasPermission("welcomer.commands.reload")) {
			sender.sendMessage(utility.colorize(ConfigManager.getPrefix() + " " + ConfigManager.getNoPermissionMessage()));
			return true;
		}

		long now = System.currentTimeMillis();
		configManager.load();
		long result = System.currentTimeMillis() - now;
		sender.sendMessage(utility.colorize(ConfigManager.getPrefix() + " &aConfiguration reloaded in &f" + result + "ms"));
		return true;
	}
}
