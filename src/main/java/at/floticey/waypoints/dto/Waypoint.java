package at.floticey.waypoints.dto;

import org.bukkit.Location;
import java.util.UUID;

public class Waypoint {
    public final UUID uuid = UUID.randomUUID();
    public UUID ownerUUID;
    public String name;
    public Location location;

    public Waypoint(UUID ownerUUID, String name, Location location) {
        this.ownerUUID = ownerUUID;
        this.name = name;
        this.location = location;
    }

    public void update(Waypoint waypoint) {
        this.ownerUUID = waypoint.ownerUUID;
        this.name = waypoint.name;
        this.location = waypoint.location;
    }
}
