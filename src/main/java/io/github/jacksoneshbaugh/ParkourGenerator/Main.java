package io.github.jacksoneshbaugh.ParkourGenerator;

import io.github.jacksoneshbaugh.ParkourGenerator.command.CommandParkourGenerator;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.permission.Permission;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import java.util.Optional;

/**
 * The entry point for the ParkourGenerator Spigot plugin.
 * @author Jackson Eshbaugh
 * @version 05/25/2024
 */
@Plugin(name = "ParkourGenerator", version = "1.0.0")
@Description("An automated parkour generator created...because I felt like it.")
@Author("Jackson Eshbaugh — jacksoneshbaugh.github.io — jacksoneshbaugh@gmail.com")

@Command(name = "parkourgenerator", desc = "The main command for using ParkourGenerator", aliases = {"pg"}, usage = "/pg <[g]enerate/[h]elp>")

@Permission(name = "parkourgenerator.command", desc = "Allows access to commands. Must be granted along with any more specific command permissions.", defaultValue = PermissionDefault.OP)
@Permission(name = "parkourgenerator.command.version", desc = "Allows access to the version module of the parkourgenerator command.", defaultValue = PermissionDefault.OP)
@Permission(name = "parkourgenerator.command.generate", desc = "Allows access to the generation module of the parkourgenerator command.", defaultValue = PermissionDefault.OP)
public class Main extends JavaPlugin {

    public static final String VERSION = "1.0.0";

    @Override
    public void onEnable() {
        Bukkit.getServer().getLogger().info("Enabling ParkourGenerator version " + VERSION);

        // Register Commands
        Optional.ofNullable(this.getCommand("parkourgenerator")).ifPresent(cmd -> cmd.setExecutor(new CommandParkourGenerator()));
    }

    @Override
    public void onDisable() {

    }

}