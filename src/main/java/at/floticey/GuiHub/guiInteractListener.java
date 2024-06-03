package at.floticey.GuiHub;

import at.floticey.test.main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class guiInteractListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.BLACK.toString() + "Hubs") && e.getCurrentItem() != null) {
            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();

            switch (e.getRawSlot()) {
                case 0:
                    break;

                case 11:
                    if (player.isOp()) {
                        main.location = player.getLocation();
                        player.sendMessage(ChatColor.GREEN + "Spawn per GUI wurde gesetzt!");
                    } else {
                        player.sendMessage(ChatColor.RED + "Spawn per GUI konnte nicht gesetzt werden [No Permissions]");
                    }
                    break;

                case 13:
                    if (main.location != null) {
                        player.teleport(main.location);
                        player.sendMessage(ChatColor.GREEN + "GUI Warp TP");
                    } else {
                        player.sendMessage(ChatColor.RED + "GUI Warp konnte nicht gefunden werden!");
                    }

                    break;

                case 15:
                    if (player.isOp()) {
                        main.location = null;
                        player.sendMessage(ChatColor.GREEN + "GUI Warp wurde zurückgesetzt!");
                    } else {
                        player.sendMessage(ChatColor.RED + "Spawn per GUI konnte nicht zurückgesetzt werden [No Permissions]");
                    }

                    break;

                //next page case 26:

                    //break;
                default:
                    return;
            }

            player.closeInventory();

        }
    }
}
