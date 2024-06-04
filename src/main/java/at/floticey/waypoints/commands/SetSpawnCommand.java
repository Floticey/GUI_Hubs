package at.floticey.waypoints.commands;

import at.floticey.waypoints.Waypoints;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (player.isOp()) {
                Waypoints.spawnPoint = player.getLocation();

                player.sendMessage(ChatColor.GREEN + "Dein Spawn wurde gesetzt!");
            } else {
                player.sendMessage(ChatColor.RED + "Du bist nicht berechtigt dazu einen Spawn zu setzen!");
            }
        }

        return false;
    }
}


