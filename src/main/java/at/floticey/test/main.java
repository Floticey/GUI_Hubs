package at.floticey.test;

import at.floticey.GuiHub.ChestGUI;
import at.floticey.GuiHub.guiInteractListener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;

public final class main extends JavaPlugin {

        @Nullable
        public static Location location;

        @Override
        public void onEnable() {

            getCommand("spawn").setExecutor(new SetSpawnCommand());
            getCommand("warp").setExecutor(new SpawnCommand());
            getCommand("remove").setExecutor(new RemoveSpawn());
            getCommand("guihub").setExecutor(new ChestGUI());
            Bukkit.getPluginManager().registerEvents(new JoinWarp(), this);
            Bukkit.getPluginManager().registerEvents(new guiInteractListener(), this);

        }
}
