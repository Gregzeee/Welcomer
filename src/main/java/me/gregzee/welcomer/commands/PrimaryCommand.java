package me.gregzee.welcomer.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import me.gregzee.welcomer.Welcomer;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.CommandSender;

@CommandAlias("test")
@CommandPermission("test.use")
public class PrimaryCommand extends BaseCommand {

    private final Welcomer plugin;
    private final BukkitAudiences adventure;

    public PrimaryCommand(Welcomer plugin) {
        this.plugin = plugin;
        this.adventure = plugin.getAdventure();
    }

    @Default
    public void test(CommandSender sender, String[] args) {
        if (args.length == 1) {
            if (args[0].equals("reload")) {
                plugin.reloadConfig();
                adventure.sender(sender).sendMessage(Component.text("Configuration has been reloaded.").color(NamedTextColor.GREEN));
                return;
            } else if (args[0].equals("menu")) {
                return;
            } else {
                adventure.sender(sender).sendMessage(Component.text("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
                        .color(NamedTextColor.GRAY));
                adventure.sender(sender).sendMessage(Component.text("-=-=-=-=-=-=-=-=- ")
                        .color(NamedTextColor.GRAY)
                        .append(Component.text("Welcomer ")
                        .color(NamedTextColor.GREEN)
                        .decoration(TextDecoration.UNDERLINED, true)
                        .append(Component.text("-=-=-=-=-=-=-=-=-")
                        .color(NamedTextColor.GRAY))));
                adventure.sender(sender).sendMessage(Component.text("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
                        .color(NamedTextColor.GRAY));
                adventure.sender(sender).sendMessage(Component.text("✗ ")
                        .color(NamedTextColor.DARK_GREEN)
                        .append(Component.text("/welcomer reload ")
                        .color(NamedTextColor.GREEN)
                        .decoration(TextDecoration.UNDERLINED, true)
                        .append(Component.text("--- ")
                        .color(NamedTextColor.GRAY)
                        .append(Component.text("Reloads the configuration")
                        .color(NamedTextColor.GREEN)))));
                adventure.sender(sender).sendMessage(Component.text(""));
                adventure.sender(sender).sendMessage(Component.text("✗ ")
                        .color(NamedTextColor.DARK_GREEN)
                        .append(Component.text("/welcomer help ")
                        .color(NamedTextColor.GREEN)
                        .decoration(TextDecoration.UNDERLINED, true)
                        .append(Component.text("--- ")
                        .color(NamedTextColor.GRAY)
                        .append(Component.text("Displays the help message")
                        .color(NamedTextColor.GREEN)))));
                adventure.sender(sender).sendMessage(Component.text("✗ ")
                        .color(NamedTextColor.DARK_GREEN)
                        .append(Component.text("/welcomer menu ")
                        .color(NamedTextColor.GREEN)
                        .decoration(TextDecoration.UNDERLINED, true)
                        .append(Component.text("--- ")
                        .color(NamedTextColor.GRAY)
                        .append(Component.text("In-game menu to toggle different features")
                        .color(NamedTextColor.GREEN)))));
                return;
            }
        }

        return;
    }
}