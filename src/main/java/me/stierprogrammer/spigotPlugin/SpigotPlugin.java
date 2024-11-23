package me.stierprogrammer.spigotPlugin;

import me.stierprogrammer.spigotPlugin.Commands.GodModeCommand;
import me.stierprogrammer.spigotPlugin.Commands.HomeCommands;
import me.stierprogrammer.spigotPlugin.Commands.SuicideCommand;
import me.stierprogrammer.spigotPlugin.Listeners.EnterLeaveBedListener;
import me.stierprogrammer.spigotPlugin.Listeners.JoinLeavePlayerListener;
import me.stierprogrammer.spigotPlugin.Listeners.SheepShearListener;
import me.stierprogrammer.spigotPlugin.Listeners.XPBottleBreakListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SpigotPlugin extends JavaPlugin implements Listener {
    PluginManager pm = getServer().getPluginManager();

    final String[] homeCommandsList = {"home", "sethome", "homes"};
    HomeCommands homeCommands = new HomeCommands();
    GodModeCommand godmodeCommand = new GodModeCommand();
    SuicideCommand suicideCommand = new SuicideCommand();

    EnterLeaveBedListener enterLeaveBedListener = new EnterLeaveBedListener();
    JoinLeavePlayerListener joinLeavePlayerListener = new JoinLeavePlayerListener();
    XPBottleBreakListener xpBottleBreakListener = new XPBottleBreakListener();
    SheepShearListener sheepShearListener = new SheepShearListener();

    @Override
    public void onEnable() {
        System.out.println("SpigotPlugin enabled");

        for (String homeCommand : homeCommandsList) {
            Objects.requireNonNull(getCommand(homeCommand)).setExecutor(homeCommands);
        }

        Objects.requireNonNull(getCommand("godmode")).setExecutor(godmodeCommand);
        Objects.requireNonNull(getCommand("suicide")).setExecutor(suicideCommand);

        pm.registerEvents(enterLeaveBedListener, this);
        pm.registerEvents(joinLeavePlayerListener, this);
        pm.registerEvents(xpBottleBreakListener, this);
        pm.registerEvents(sheepShearListener, this);
    }
}
