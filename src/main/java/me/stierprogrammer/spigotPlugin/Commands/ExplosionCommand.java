package me.stierprogrammer.spigotPlugin.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ExplosionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] strings
    ) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");

            return true;
        }

        Location location = player.getLocation();

        Objects.requireNonNull(location.getWorld()).createExplosion(location.getX(), location.getY(), location.getZ(), 5.0F, true, false);

        return true;
    }
}
