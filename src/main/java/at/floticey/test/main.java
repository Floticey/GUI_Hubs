package at.floticey.test;

import at.floticey.GuiHub.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public final class main extends JavaPlugin {
        @Nullable
        public static Location location;
        public static List<Waypoint> waypoints = new ArrayList<>();
        @Override
        public void onEnable() {

            getCommand("spawn").setExecutor(new SetSpawnCommand());
            getCommand("warp").setExecutor(new SpawnCommand());
            getCommand("remove").setExecutor(new RemoveSpawn());
            getCommand("guihub").setExecutor(new ChestGUI());
            getCommand("waypoints").setExecutor(new WaypointsCommand());
            getCommand("waypointGUI").setExecutor(new WaypointsGUI());
            Bukkit.getPluginManager().registerEvents(new JoinWarp(), this);
            Bukkit.getPluginManager().registerEvents(new guiInteractListener(), this);

        }
}
