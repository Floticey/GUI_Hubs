package at.floticey.waypoints.events;

import at.floticey.waypoints.Waypoints;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InventoryClickEvent implements Listener {
    @EventHandler
    public void onClick(org.bukkit.event.inventory.InventoryClickEvent e) {
        if (e.getView().getTitle().equals("Waypoints") && e.getCurrentItem() != null) {
            Player player = (Player) e.getWhoClicked();

            if (Waypoints.playerGUIs.containsKey(player.getUniqueId())) {
                Waypoints.playerGUIs.get(player.getUniqueId()).handleClick(e);
            }
        }
    }
}
