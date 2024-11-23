package me.stierprogrammer.spigotPlugin.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class SheepListener implements Listener {
    @EventHandler
    public void onShear(PlayerShearEntityEvent event) {
        Player player = event.getPlayer();
        Entity entity = event.getEntity();

        if (entity.getType() == EntityType.SHEEP) {
            player.sendMessage("This is a sheep! You can not do that!");

            event.setCancelled(true);
        }
        else {
            player.sendMessage("This is not a sheep!");
        }
    }
}
