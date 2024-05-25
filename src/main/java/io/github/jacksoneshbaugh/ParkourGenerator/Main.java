package io.github.jacksoneshbaugh.ParkourGenerator;

import io.github.jacksoneshbaugh.ParkourGenerator.command.CommandParkourGenerator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The entry point for the ParkourGenerator Spigot plugin.
 * @author Jackson Eshbaugh
 * @version 05/25/2024
 */
public class Main extends JavaPlugin {

    public static final String VERSION = "1.0.0";

    @Override
    public void onEnable() {
        Bukkit.getServer().getLogger().info("Enabling ParkourGenerator version " + VERSION);

        // Register Commands
        this.getCommand("parkourgenerator").setExecutor(new CommandParkourGenerator());
    }

    @Override
    public void onDisable() {

    }

}