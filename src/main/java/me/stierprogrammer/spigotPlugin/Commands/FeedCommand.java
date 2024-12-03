package me.stierprogrammer.spigotPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(
            @NotNull CommandSender commandSender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] strings
    ) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage("Only players can use this command!");

            return true;
        }

        player.setFoodLevel(20);
        player.sendMessage(ChatColor.GREEN + "Food set to max!");

        return true;
    }
}
