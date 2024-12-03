package me.stierprogrammer.spigotPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PermCommand implements CommandExecutor {
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    ) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");

            return true;
        }

        if (player.hasPermission("permissions.perms")) {
            player.sendMessage(ChatColor.GREEN + "You have permission to use this command.");
        }
        else {
            player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");

        }
        return true;
    }
}
