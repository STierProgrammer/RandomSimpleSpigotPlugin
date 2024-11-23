package me.stierprogrammer.spigotPlugin;

import me.stierprogrammer.spigotPlugin.Commands.GodModeCommand;
import me.stierprogrammer.spigotPlugin.Commands.HomeCommands;
import me.stierprogrammer.spigotPlugin.Commands.SuicideCommand;
import me.stierprogrammer.spigotPlugin.listeners.BedListener;
import me.stierprogrammer.spigotPlugin.listeners.PlayerListener;
import me.stierprogrammer.spigotPlugin.listeners.SheepListener;
import me.stierprogrammer.spigotPlugin.listeners.XPBottleListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;

public final class SpigotPlugin extends JavaPlugin implements Listener {
    PluginManager pm = getServer().getPluginManager();
    BedListener bedListener = new BedListener();
    PlayerListener playerListener = new PlayerListener();
    XPBottleListener xpListenerBottle = new XPBottleListener();
    SheepListener shearSheepListener = new SheepListener();
    GodModeCommand godmodeCommand = new GodModeCommand();
    HomeCommands homeCommands = new HomeCommands();
    final String[] homeCommandsList = {"home", "sethome"};
    SuicideCommand suicideCommand = new SuicideCommand();

    @Override
    public void onEnable() {
        System.out.println("SpigotPlugin enabled");

        for (String homeCommand : homeCommandsList) {
            Objects.requireNonNull(getCommand(homeCommand)).setExecutor(homeCommands);
        }

        Objects.requireNonNull(getCommand("godmode")).setExecutor(godmodeCommand);
        Objects.requireNonNull(getCommand("suicide")).setExecutor(suicideCommand);

        pm.registerEvents(bedListener, this);
        pm.registerEvents(playerListener, this);
        pm.registerEvents(xpListenerBottle, this);
        pm.registerEvents(shearSheepListener, this);
    }
}
