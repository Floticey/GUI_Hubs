package at.floticey.waypoints.events;

import at.floticey.waypoints.Waypoints;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {

        Player player = e.getPlayer();

        if (Waypoints.spawnPoint != null) {
            player.teleport(Waypoints.spawnPoint);
        }

        player.sendTitle(ChatColor.GOLD + "Welcome!", "", 20, 100, 20);
        player.playSound(Waypoints.spawnPoint, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
    }

}
