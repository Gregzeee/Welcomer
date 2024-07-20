package me.gregzee.welcomer;

import lombok.Getter;
import me.gregzee.welcomer.manager.StartupManager;
import me.gregzee.welcomer.utility.Utility;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Welcomer extends JavaPlugin {

    @Getter
    private static final Utility utility = new Utility();

    @Getter
	private static Welcomer instance;

    @Override
    public void onEnable() {
        instance = this;

        new StartupManager();

        sendEnableMessage();

    }

    @Override
    public void onDisable() {
        sendDisableMessage();
    }

    private void sendEnableMessage() {
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage(utility.colorize("&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        console.sendMessage(utility.colorize("                 &eWelcomer"));
        console.sendMessage(utility.colorize("          Plugin has been enabled"));
        console.sendMessage(utility.colorize("&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        console.sendMessage(utility.colorize("               &cMade by Gregzee"));
    }

    private void sendDisableMessage() {
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage(utility.colorize("&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        console.sendMessage(utility.colorize("                 &eWelcomer"));
        console.sendMessage(utility.colorize("          Plugin has been disabled"));
        console.sendMessage(utility.colorize("&7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        console.sendMessage(utility.colorize("               &cMade by Gregzee"));
    }
}
