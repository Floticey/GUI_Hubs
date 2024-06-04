package at.floticey.waypoints.commands;

import at.floticey.waypoints.Waypoints;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (player.isOp()) {
                Waypoints.spawnPoint = null;
                player.sendMessage(ChatColor.RED + "Dein Spawn wurde zurückgesetzt!");
            } else {
                player.sendMessage(ChatColor.RED + "Du bist nicht berechtigt einen Spawn zu setzen!");
            }
        }

        return false;
    }
}
