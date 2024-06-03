package at.floticey.GuiHub;

import org.bukkit.Location;
import java.util.UUID;

public class Waypoint {

    UUID ownerUUID;
    String name;
    Location location;
    public Waypoint(UUID ownerUUID, String name, Location location) {
        this.ownerUUID = ownerUUID;
        this.name = name;
        this.location = location;
    }
}
