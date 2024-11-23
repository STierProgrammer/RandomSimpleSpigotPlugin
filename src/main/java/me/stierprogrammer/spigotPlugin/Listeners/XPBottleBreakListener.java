package me.stierprogrammer.spigotPlugin.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class XPBottleBreakListener implements Listener {
    @EventHandler
    public void onBottleBreak(ExpBottleEvent event) {
        event.setShowEffect(false);
    }
}
