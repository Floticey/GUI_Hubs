package at.floticey.GuiHub;

import at.floticey.test.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class WaypointsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length >= 1) {
                    Waypoint waypoint = new Waypoint(player.getUniqueId(), args[0], player.getLocation());
                    main.waypoints.add(waypoint);
            } else {
                player.sendMessage("error");
            }
        }
        return false;
    }
}
