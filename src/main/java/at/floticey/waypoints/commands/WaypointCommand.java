package at.floticey.waypoints.commands;

import at.floticey.waypoints.Waypoints;
import at.floticey.waypoints.dto.Waypoint;
import at.floticey.waypoints.utils.WaypointManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WaypointCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length >= 1) {
                switch (args[0]) {
                    case "create": {
                        if (args.length >= 2) {
                            if (args[1].equals("all")) {
                                for (int i = 0; i < 43; i++) {
                                    String name = args[1] + i;
                                    WaypointManager.createWaypoint(player, name, player.getLocation());
                                    player.sendMessage(ChatColor.GREEN + "Created " + name + "!");
                                }
                            } else {
                                WaypointManager.createWaypoint(player, args[1], player.getLocation());
                                player.sendMessage(ChatColor.GREEN + "Created " + args[1] + "!");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Missing argument <name>!");
                        }
                        break;
                    }

                    case "edit": {
                        if (args.length >= 2) {
                            Waypoint waypoint = Waypoints.waypoints.stream().filter(wp -> wp.name.equals(args[1])).findFirst().orElse(null);
                            if (waypoint != null) {
                                System.out.println("EDIT WAYPOINT!");
                            } else {
                                player.sendMessage(ChatColor.RED + "Waypoint " + args[1] + " does not exist!");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Missing argument <name>!");
                        }
                        break;
                    }

                    case "delete": {
                        if (args.length >= 2) {
                            WaypointManager.deleteWaypoint(player, args[1]);
                            player.sendMessage(ChatColor.GOLD + "Waypoint " + args[1] + " deleted successfully!");
                        } else {
                            player.sendMessage(ChatColor.RED + "Missing argument <name>!");
                        }
                        break;
                    }

                    default: {
                        player.sendMessage(ChatColor.RED + "Use 'create', 'edit' or 'delete'!");
                        break;
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "Use 'create', 'edit' or 'delete'!");
            }
        }
        return false;
    }
}
