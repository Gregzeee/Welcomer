package me.gregzee.welcomer.utility;

import net.md_5.bungee.api.ChatColor;

public class Utility {

	public String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
