package me.stierprogrammer.spigotPlugin;

import me.stierprogrammer.spigotPlugin.listeners.BedListener;
import me.stierprogrammer.spigotPlugin.Commands.Commands;
import me.stierprogrammer.spigotPlugin.listeners.PlayerListener;
import me.stierprogrammer.spigotPlugin.listeners.SheepListener;
import me.stierprogrammer.spigotPlugin.listeners.XPBottleListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SpigotPlugin extends JavaPlugin implements Listener {
    String[] commandNames = {"sethome", "home", "suicide"};
    PluginManager pm = getServer().getPluginManager();
    Commands commands = new Commands();
    BedListener bedListener = new BedListener();
    PlayerListener playerListener = new PlayerListener();
    XPBottleListener xpListenerBottle = new XPBottleListener();
    SheepListener shearSheepListener = new SheepListener();

    @Override
    public void onEnable() {
        System.out.println("SpigotPlugin enabled");

        for (String commandName : commandNames) {
                Objects.requireNonNull(getCommand(commandName)).setExecutor(commands);
        }

        pm.registerEvents(bedListener, this);
        pm.registerEvents(playerListener, this);
        pm.registerEvents(xpListenerBottle, this);
        pm.registerEvents(shearSheepListener, this);
    }
}
