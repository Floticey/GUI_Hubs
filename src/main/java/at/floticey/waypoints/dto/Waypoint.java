package at.floticey.waypoints.dto;

import org.bukkit.Location;
import java.util.UUID;

public class Waypoint {
    public UUID ownerUUID;
    public String name;
    public Location location;

    public Waypoint(UUID ownerUUID, String name, Location location) {
        this.ownerUUID = ownerUUID;
        this.name = name;
        this.location = location;
    }
}
