package me.stierprogrammer.spigotPlugin;

import me.stierprogrammer.spigotPlugin.listeners.BedListenerClass;
import me.stierprogrammer.spigotPlugin.Commands.Commands;
import me.stierprogrammer.spigotPlugin.listeners.PlayerListenerClass;
import me.stierprogrammer.spigotPlugin.listeners.ShearSheepListener;
import me.stierprogrammer.spigotPlugin.listeners.XPListenerBottle;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SpigotPlugin extends JavaPlugin implements Listener {
    String[] commandNames = {"sethome", "home"};
    PluginManager pm = getServer().getPluginManager();
    Commands commands = new Commands();
    BedListenerClass bedListener = new BedListenerClass();
    PlayerListenerClass playerListener = new PlayerListenerClass();
    XPListenerBottle xpListenerBottle = new XPListenerBottle();
    ShearSheepListener shearSheepListener = new ShearSheepListener();

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
