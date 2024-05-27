package at.floticey.GuiHub;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class guiInteractListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (e.getView().getTitle().equals("Hubs") && e.getCurrentItem() != null) {
            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();

            switch (e.getRawSlot()) {
                case 0:
                    player.closeInventory();
                    break;

                case 11:

                    break;

                case 13:
                    break;

                case 15:
                    break;
            }

            player.closeInventory();

        }
    }
}
