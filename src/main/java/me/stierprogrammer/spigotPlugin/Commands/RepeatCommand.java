package me.stierprogrammer.spigotPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RepeatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    ) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can execute this command.");

            return true;
        }

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "You did not provide any arguments!");
        }
        else {
            StringBuilder builder = new StringBuilder();

            for (String arg : args) {
                builder.append(arg);
                builder.append(" ");
            }

            String finalMessage = builder.toString().stripTrailing();

            player.sendMessage(finalMessage);
        }

        return true;
    }
}
