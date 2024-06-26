package at.floticey.waypoints.commands;

import at.floticey.waypoints.Waypoints;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (Waypoints.spawnPoint != null) {
                player.teleport(Waypoints.spawnPoint);
                player.sendTitle(ChatColor.GOLD + "Spawn", "", 20, 100, 20);
                player.sendMessage(ChatColor.GREEN + "Du wurdest zum Spawn teleportiert!");
            } else {
                player.sendMessage(ChatColor.RED + "Spawn nicht erreichbar");
            }
        }


        return false;
    }
}
