package me.gregzee.welcomer.TabCompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainCommandCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> results = new ArrayList<>();

        // If there's only one argument (i.e., the command name itself)
        if (args.length == 1) {
            // Provide tab-completion suggestions for the first argument
            // In this case, it provides "reload" and "help" as valid command names
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("reload", "help"), results);
        }

        // If there are more than one argument, or if the argument is not recognized, return an empty list
        return results;
    }
}
