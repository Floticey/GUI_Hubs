package at.floticey.waypoints.gui;

import at.floticey.waypoints.Waypoints;
import at.floticey.waypoints.dto.Waypoint;
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

            int currentSlot = 10;
            int MAX_SLOTS_PER_ROW = 7;
            int MAX_SLOTS_PER_PAGE = 28;

            Inventory inv = Bukkit.createInventory(player, 54, ChatColor.BLUE + "Waypoints");

            ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta framemeta = frame.getItemMeta();
            framemeta.setDisplayName(ChatColor.RESET + " ");
            frame.setItemMeta(framemeta);
            for (int i : BORDER_SLOTS) {
                inv.setItem(i, frame);
            }

            ItemStack next = new ItemStack(Material.STONE_BUTTON);
            ItemMeta nextmeta = next.getItemMeta();
            nextmeta.setDisplayName(ChatColor.RESET + "weiter");
            next.setItemMeta(nextmeta);
            inv.setItem(PAGINATION_NEXT_SLOT, next);

            ItemStack back = new ItemStack(Material.STONE_BUTTON);
            ItemMeta backmeta = back.getItemMeta();
            backmeta.setDisplayName(ChatColor.RESET + "zurück");
            back.setItemMeta(backmeta);
            inv.setItem(PAGINATION_BACK_SLOT, back);

            for (Waypoint waypoint : main.waypoints) {
            for (Waypoint waypoint : Waypoints.waypoints) {
                ItemStack waypointitem = new ItemStack(Material.PAPER);
                ItemMeta waypointmeta = waypointitem.getItemMeta();
                waypointmeta.setDisplayName(ChatColor.RESET + (ChatColor.GREEN + waypoint.name));
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
