package me.stierprogrammer.spigotPlugin.Listeners;

import me.stierprogrammer.spigotPlugin.SpigotPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DeathListener implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        new BukkitRunnable() {
            public void run() {
                Player player = event.getEntity().getPlayer();

                if (player != null)
                    player.sendMessage(ChatColor.RED + "You died!!!");
            }
        }.runTaskLater(SpigotPlugin.getPlugin(), 10L);

    }
}
