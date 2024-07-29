package me.gregzee.welcomer.command;

import me.gregzee.welcomer.Welcomer;
import me.gregzee.welcomer.handler.PrimaryCommandHandler;
import me.gregzee.welcomer.manager.ConfigManager;
import me.gregzee.welcomer.utility.Utility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Primary command executor including all commands like /welcomer menu, /welcomer reload
 */
public final class PrimaryCommand implements CommandExecutor, TabCompleter {

    private final Utility utility = Welcomer.getUtility();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if ("menu".equalsIgnoreCase(args[0])) {
            PrimaryCommandHandler.handleMenuCommand();
            return true;
        } else if ("reload".equalsIgnoreCase(args[0])) {
            PrimaryCommandHandler.handleReloadCommand();
            return true;
        } else {
            sender.sendMessage(utility.colorize(ConfigManager.getPrefix() + " &cInvalid usage! &f/welcomer <menu/reload>"));
        }

        return true;
    }

    private static final String[] COMMANDS = {"menu", "reload"};

    @Override
    public @NotNull List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return new ArrayList<>();
        }

        List<String> completions = new ArrayList<>();
        List<String> suggestions = new ArrayList<>();

        if (args.length == 1) {
            completions.addAll(Arrays.asList(COMMANDS));
        }

        StringUtil.copyPartialMatches(args[0], completions, suggestions);
        suggestions.sort(String.CASE_INSENSITIVE_ORDER);

        return suggestions;
    }
}