package me.stierprogrammer.spigotPlugin.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeavePlayerListener implements Listener {
    @EventHandler
    public void whenPlayerJoins(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getDisplayName();
        String firstJoinMessage = ChatColor.AQUA + "Welcome " + ChatColor.GOLD + ChatColor.BOLD  + playerName + ChatColor.AQUA + "!";
        String defJoinMessage = ChatColor.AQUA + "Looks who's back: " + ChatColor.GOLD + ChatColor.BOLD  + playerName + ChatColor.AQUA + "!";

        if (player.hasPlayedBefore()) {
            event.setJoinMessage(defJoinMessage);
        }

        else if (!(player.hasPlayedBefore())) {
            event.setJoinMessage(firstJoinMessage);
        }
    }

    @EventHandler
    public void whenPlayerQuits(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName();
        String quitMessage = ChatColor.GOLD + "" + ChatColor.BOLD + playerName + ChatColor.AQUA + " left the server!";

        event.setQuitMessage(quitMessage);
    }

}
