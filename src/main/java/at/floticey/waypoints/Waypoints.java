package at.floticey.waypoints;

import at.floticey.waypoints.commands.SetSpawnCommand;
import at.floticey.waypoints.commands.SpawnCommand;
import at.floticey.waypoints.commands.RemoveSpawnCommand;
import at.floticey.waypoints.commands.WaypointsCommand;
import at.floticey.waypoints.dto.Waypoint;
import at.floticey.waypoints.events.InventoryClickEvent;
import at.floticey.waypoints.events.PlayerJoinEvent;
import at.floticey.waypoints.gui.SpawnGUI;
import at.floticey.waypoints.gui.WaypointsGUI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public final class Waypoints extends JavaPlugin {
        @Nullable
        public static Location spawnPoint;
        public static List<Waypoint> waypoints = new ArrayList<>();

        @Override
        public void onEnable() {
            // Commands
            getCommand("spawn").setExecutor(new SetSpawnCommand());
            getCommand("warp").setExecutor(new SpawnCommand());
            getCommand("remove").setExecutor(new RemoveSpawnCommand());
            getCommand("guihub").setExecutor(new SpawnGUI());
            getCommand("waypoints").setExecutor(new WaypointsCommand());
            getCommand("waypointGUI").setExecutor(new WaypointsGUI());

            // Events
            Bukkit.getPluginManager().registerEvents(new PlayerJoinEvent(), this);
            Bukkit.getPluginManager().registerEvents(new InventoryClickEvent(), this);
        }
}
