package at.floticey.waypoints.commands;

import at.floticey.waypoints.dto.Waypoint;
import at.floticey.waypoints.Waypoints;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WaypointsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length >= 1) {
                    Waypoint waypoint = new Waypoint(player.getUniqueId(), args[0], player.getLocation());
                    Waypoints.waypoints.add(waypoint);
                    player.sendMessage("Waypoint " + ChatColor.GREEN + args[0] + ChatColor.RESET + " wurde gesetzt!");
            }
        }
        return false;
    }
}
