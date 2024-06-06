package at.floticey.waypoints.utils;

import at.floticey.waypoints.Waypoints;
import at.floticey.waypoints.dto.Waypoint;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WaypointManager {
    public static void createWaypoint(Player player, String name, Location location) {
        Waypoint waypoint = new Waypoint(player.getUniqueId(), name, location);
        Waypoints.waypoints.add(waypoint);
    }

    public static void deleteWaypoint(Player player, String name) {
        Waypoints.waypoints.removeIf(waypoint -> waypoint.name.equals(name));
    }
}
