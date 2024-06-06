package at.floticey.waypoints.commands;

import at.floticey.waypoints.Waypoints;
import at.floticey.waypoints.gui.WaypointsGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.stream.Collectors;

public class WaypointsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            new WaypointsGUI(Waypoints.waypoints.stream().filter(w -> w.ownerUUID.equals(player.getUniqueId())).collect(Collectors.toList())).openGUI(player);
        }
        return false;
    }
}
