package at.floticey.GuiHub;

import at.floticey.test.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
public class WaypointsGUI implements CommandExecutor {

    int currentSlot = 10;
    int MAX_SLOTS_PER_ROW = 7;
    int MAX_SLOTS_PER_PAGE = 28;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            Inventory inv = Bukkit.createInventory(player, 54, ChatColor.BLUE + "Waypoints");

            ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta framemeta = frame.getItemMeta();
            framemeta.setDisplayName("");
            frame.setItemMeta(framemeta);
            for (int i : new int[] {0,1,2,3,4,5,6,7,8,9,18,27,36,44,45,46,47,49,51,52,53,45,35,26,17}) {
                inv.setItem(i, frame);
            }

            ItemStack next = new ItemStack(Material.STONE_BUTTON);
            ItemMeta nextmeta = next.getItemMeta();
            nextmeta.setDisplayName("weiter");
            next.setItemMeta(nextmeta);
            inv.setItem(50, next);

            ItemStack back = new ItemStack(Material.STONE_BUTTON);
            ItemMeta backmeta = back.getItemMeta();
            backmeta.setDisplayName("zurück");
            back.setItemMeta(backmeta);
            inv.setItem(48, back);

            for (Waypoint waypoint : main.waypoints) {
                ItemStack waypointitem = new ItemStack(Material.PAPER);
                ItemMeta waypointmeta = waypointitem.getItemMeta();
                waypointmeta.setDisplayName(waypoint.name);
                waypointitem.setItemMeta(waypointmeta);
                inv.setItem(currentSlot, waypointitem);
                if (currentSlot + 1 >= MAX_SLOTS_PER_PAGE)
                        break;
                if (currentSlot + 1 % MAX_SLOTS_PER_ROW == 0) {
                    currentSlot += 3;
                }
            }

            player.openInventory(inv);
        }
        return false;
    }
}
