package me.stierprogrammer.spigotPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GodModeCommand implements CommandExecutor {
    private final String activatedMessage = ChatColor.RED + "" + ChatColor.BOLD + "God mode has been activated!\n";
    private final String disabeldMessage = ChatColor.RED + "" + ChatColor.BOLD + "God mode has been disabled!\n";

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    ) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command!");

            return true;
        }

        if (player.isInvulnerable()) {
            player.setInvulnerable(false);

            player.sendMessage(disabeldMessage);

        }
        else {
            player.setInvulnerable(true);

            player.sendMessage(activatedMessage);

        }

        return true;
    }

}

