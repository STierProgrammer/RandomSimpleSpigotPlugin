package me.stierprogrammer.spigotPlugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class XPBottleListener implements Listener {
    @EventHandler
    public void onBottleBreak(ExpBottleEvent event) {
        event.setShowEffect(false);
    }
}
