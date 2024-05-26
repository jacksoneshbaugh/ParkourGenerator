package io.github.jacksoneshbaugh.ParkourGenerator.command;

import io.github.jacksoneshbaugh.ParkourGenerator.Main;
import io.github.jacksoneshbaugh.ParkourGenerator.Util;
import io.github.jacksoneshbaugh.ParkourGenerator.generator.ParkourGenerator;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Provides functionality for the "/pg" command and all of its subcommands.
 * @author Jackson Eshbaugh
 * @version 05/25/2024
 */
public class CommandParkourGenerator implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!sender.hasPermission("parkourgenerator.command")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command. Ask an administrator if you think this is an error.");
            return true;
        }

        if(args.length == 0) {
            sender.sendMessage(ChatColor.AQUA + "[ParkourGenerator] " + ChatColor.RED + "Error: Improper command usage. \n/pg <[v]ersion/[g]enerate>");
            return true;
        }


        // /pg [v]ersion
        if(args[0].equals("version") || args[0].equals("v")) {

            if(!sender.hasPermission("parkourgenerator.command.version")) {
                sender.sendMessage(ChatColor.AQUA + "[ParkourGenerator] " + ChatColor.RED + "Error: You don't have permission to execute this command. Ask an administrator if you think this is an error.");
                return true;
            }

            sender.sendMessage(ChatColor.AQUA + "[ParkourGenerator] " + ChatColor.GREEN + "You're using ParkourGenerator version " + ChatColor.BOLD + ChatColor.GOLD + Main.VERSION);
            return true;
        }

        // /pg [g]enerate
        if(args[0].equals("generate") || args[0].equals("g")) {

            if(!sender.hasPermission("parkourgenerator.command.generate")) {
                sender.sendMessage(ChatColor.AQUA + "[ParkourGenerator] " + ChatColor.RED + "Error: You don't have permission to execute this command. Ask an administrator if you think this is an error.");
                return true;
            }

            if(!(sender instanceof Player player)) {
                sender.sendMessage(ChatColor.AQUA + "[ParkourGenerator] " + ChatColor.RED + "Error: This command must be run by a player in-game.");
                return true;
            }

            if(args.length > 1) {
                // /pg [g]enerate [h]elp
                if(args[1].equals("help") || args[1].equals("h")) {
                    player.sendMessage(ChatColor.AQUA + "[ParkourGenerator] " + ChatColor.YELLOW + "/pg [g]enerate [number of segments/[h]elp]");
                    player.sendMessage(ChatColor.AQUA + "[ParkourGenerator] " + ChatColor.YELLOW + "Running /pg generate or /pg g will generate a parkour of random length.");
                    return true;
                }

                // /pg [g]enerate [number of segments]

                int[] startPosition = {
                        player.getLocation().getBlockX(),
                        player.getLocation().getBlockY(),
                        player.getLocation().getBlockZ()
                };

                int numSegments;

                try {
                    numSegments = Integer.parseInt(args[1]);
                } catch(NumberFormatException e) {
                    player.sendMessage(ChatColor.AQUA + "[ParkourGenerator] " + ChatColor.RED + "Error: You provided a non-integer number (\"" + ChatColor.UNDERLINE + ChatColor.YELLOW + args[1] + ChatColor.RED + "\"). Please try again.");
                    return true;
                }

                ParkourGenerator.getInstance().generateParkour(startPosition, Util.getCardinalDirection(player), player.getWorld(), numSegments);
                player.sendMessage(ChatColor.AQUA + "[ParkourGenerator] " + ChatColor.GREEN + "Successfully generated parkour.");

                return true;
            }

            // /pg [g]enerate
            int[] startPosition = {
                    player.getLocation().getBlockX(),
                    player.getLocation().getBlockY(),
                    player.getLocation().getBlockZ()
            };

            ParkourGenerator.getInstance().generateParkour(startPosition, Util.getCardinalDirection(player), player.getWorld());
            player.sendMessage(ChatColor.AQUA + "[ParkourGenerator] " + ChatColor.GREEN + "Successfully generated parkour.");

            return true;
        }

        return false;
    }
}
