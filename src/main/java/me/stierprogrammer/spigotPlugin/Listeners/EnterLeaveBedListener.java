package me.stierprogrammer.spigotPlugin.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import java.util.HashMap;
import java.util.UUID;

public class EnterLeaveBedListener implements Listener {
    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    private static final long COOLDOWN_TIME = 10 * 60 * 1000;

    @EventHandler
    public void onEnterBed(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();

        long currentTime = System.currentTimeMillis();

        if (cooldowns.containsKey(playerId)) {
            long lastTime = cooldowns.get(playerId);

            if ((currentTime - lastTime) < COOLDOWN_TIME) {
                player.sendMessage(ChatColor.RED + "You can only gain EXP every 10 minutes!");

                return;
            }
        }

        player.giveExp(50);
        player.sendMessage(ChatColor.GOLD + "YOU GAINED EXP!");

        cooldowns.put(playerId, currentTime);
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        String message = ChatColor.AQUA + "" + ChatColor.BOLD + "You have survived!";

        if (player.getTotalExperience() >= 50) {
            player.sendMessage(message);
        }
        else if (player.getTotalExperience() < 50) {
            player.setHealth(0);
        }
    }
}
