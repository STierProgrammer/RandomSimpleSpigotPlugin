package me.stierprogrammer.spigotPlugin.Listeners;

import me.stierprogrammer.spigotPlugin.SpigotPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.UUID;

public class OnMoveListener implements Listener {
    private final SpigotPlugin plugin;
    private static final Long COOLDOWN_TIME = 10 * 60 * 100L;
    private final HashMap<UUID, Long> movements = new HashMap<>();

    public OnMoveListener(SpigotPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        UUID PlayerUUID = player.getUniqueId();

        long currentTime = System.currentTimeMillis();

        if (movements.containsKey(PlayerUUID)) {
            long lastTime = movements.get(PlayerUUID);

            if ((currentTime - lastTime) < COOLDOWN_TIME) {
                return;
            }
        }

        player.sendMessage(ChatColor.GREEN + "YOU MOVED ;)");
        movements.put(PlayerUUID, currentTime);
    }
}
