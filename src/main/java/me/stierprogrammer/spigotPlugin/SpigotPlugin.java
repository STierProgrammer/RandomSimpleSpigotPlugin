package me.stierprogrammer.spigotPlugin;

import me.stierprogrammer.spigotPlugin.listeners.BedListenerClass;
import me.stierprogrammer.spigotPlugin.listeners.PlayerListenerClass;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        System.out.println("SpigotPlugin enabled");

        getServer().getPluginManager().registerEvents(new BedListenerClass(), this);
        getServer().getPluginManager().registerEvents(new PlayerListenerClass(), this);
    }

}
