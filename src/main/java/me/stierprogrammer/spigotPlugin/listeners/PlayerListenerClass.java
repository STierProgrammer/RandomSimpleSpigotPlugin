package me.stierprogrammer.spigotPlugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListenerClass implements Listener {
    @EventHandler
    public void whenPlayerJoins(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        String joinMessage = ChatColor.AQUA + "Welcome " + ChatColor.GOLD + playerName + ChatColor.AQUA + "!";

        event.setJoinMessage(joinMessage);
    }

}
