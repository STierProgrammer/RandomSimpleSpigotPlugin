package me.stierprogrammer.spigotPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SuicideCommand implements CommandExecutor {
    private static final String suicideMessage = ChatColor.RED + "" + ChatColor.BOLD + "You have killed yourself!";

    @Override
    public boolean onCommand(
        @NotNull CommandSender sender,
        @NotNull Command command,
        @NotNull String label,
        @NotNull String[] args
    ) {
        if (sender instanceof Player player) {
            if (command.getName().equalsIgnoreCase("suicide")) {
                player.setHealth(0.0);
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You have killed yourself!");
                return true;
            }
        }

        return true;
    }
}
