package me.gregzee.welcomer.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import me.gregzee.welcomer.Welcomer;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;

@CommandAlias("test")
@CommandPermission("test.use")
public class PrimaryCommand extends BaseCommand {
    private final BukkitAudiences adventure;

    public PrimaryCommand(Welcomer plugin) {
        this.adventure = plugin.getAdventure();
    }

    @Default
    public void test(CommandSender sender) {
        adventure.sender(sender).sendMessage(Component.text("Hello, world!"));
    }
}