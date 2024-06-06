package at.floticey.waypoints;

import at.floticey.waypoints.commands.WaypointCommand;
import at.floticey.waypoints.commands.WaypointsCommand;
import at.floticey.waypoints.dto.Waypoint;
import at.floticey.waypoints.events.InventoryClickEvent;
import at.floticey.waypoints.gui.WaypointsGUI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class Waypoints extends JavaPlugin {
    private static Waypoints plugin;
    public static List<Waypoint> waypoints = new ArrayList<>();
    public static HashMap<UUID, WaypointsGUI> playerGUIs = new HashMap<>();

    @Override
    public void onEnable() {
        plugin = this;

        // Commands
        getCommand("waypoint").setExecutor(new WaypointCommand());
        getCommand("waypoints").setExecutor(new WaypointsCommand());

        // Events
        Bukkit.getPluginManager().registerEvents(new InventoryClickEvent(), this);
    }

    public static Waypoints getPlugin() {
        return plugin;
    }
}
