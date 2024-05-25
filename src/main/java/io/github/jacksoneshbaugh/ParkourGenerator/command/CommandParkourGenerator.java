package io.github.jacksoneshbaugh.ParkourGenerator.command;

import io.github.jacksoneshbaugh.ParkourGenerator.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Provides functionality for the "/pg" command and all of its subcommands.
 * @author Jackson Eshbaugh
 * @version 05/25/2024
 */
public class CommandParkourGenerator implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Error: Improper command usage. \n/pg <version/generate>");
            return true;
        }

        if(args[0].equals("version")) {
            sender.sendMessage(ChatColor.AQUA + "[ParkourGenerator] " + ChatColor.GREEN + "You're using ParkourGenerator version " + ChatColor.BOLD + ChatColor.GOLD + Main.VERSION);
            return true;
        }

        return false;
    }
}
