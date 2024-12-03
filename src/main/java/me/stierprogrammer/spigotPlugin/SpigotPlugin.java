package me.stierprogrammer.spigotPlugin;

import me.stierprogrammer.spigotPlugin.Commands.*;
import me.stierprogrammer.spigotPlugin.Listeners.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SpigotPlugin extends JavaPlugin implements Listener {
    private static SpigotPlugin plugin;

    final String[] homeCommandsList = {"home", "sethome", "homes"};
    PluginManager pm = getServer().getPluginManager();
    HomeCommands homeCommands = new HomeCommands();
    GodModeCommand godmodeCommand = new GodModeCommand();
    SuicideCommand suicideCommand = new SuicideCommand();
    FeedCommand feedCommand = new FeedCommand();
    ExplosionCommand explosionCommand = new ExplosionCommand();
    PermCommand permCommand = new PermCommand();

    EnterLeaveBedListener enterLeaveBedListener = new EnterLeaveBedListener();
    JoinLeavePlayerListener joinLeavePlayerListener = new JoinLeavePlayerListener();
    XPBottleBreakListener xpBottleBreakListener = new XPBottleBreakListener();
    SheepShearListener sheepShearListener = new SheepShearListener();
    DeathListener deathListener = new DeathListener();
    OnMoveListener onMoveListener = new OnMoveListener(this);

    @Override
    public void onEnable() {
        plugin = this;

        System.out.println("SpigotPlugin enabled");

        for (String homeCommand : homeCommandsList) {
            Objects.requireNonNull(getCommand(homeCommand)).setExecutor(homeCommands);
        }

        Objects.requireNonNull(getCommand("godmode")).setExecutor(godmodeCommand);
        Objects.requireNonNull(getCommand("suicide")).setExecutor(suicideCommand);
        Objects.requireNonNull(getCommand("feed")).setExecutor(feedCommand);
        Objects.requireNonNull(getCommand("explosion")).setExecutor(explosionCommand);
        Objects.requireNonNull(getCommand("perm")).setExecutor(permCommand);

        pm.registerEvents(enterLeaveBedListener, this);
        pm.registerEvents(joinLeavePlayerListener, this);
        pm.registerEvents(xpBottleBreakListener, this);
        pm.registerEvents(sheepShearListener, this);
        pm.registerEvents(deathListener, this);
        pm.registerEvents(onMoveListener, this);
    }

    public static SpigotPlugin getPlugin() {
        return plugin;
    }
}
