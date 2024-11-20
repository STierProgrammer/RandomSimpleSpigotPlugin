package me.stierprogrammer.spigotPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        System.out.println("SpigotPlugin enabled");

        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage("Welcome to Localhost!");

        Player player = event.getPlayer();

        System.out.println(player.getName() + " joined");
    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        System.out.println(player.getName() + " quit");
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        System.out.println(player.getName() + " has died");
    }

    @EventHandler
    public void whenBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        System.out.println(player.getName() + " broke a block!");
    }
}
