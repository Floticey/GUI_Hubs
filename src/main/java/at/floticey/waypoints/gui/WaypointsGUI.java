package at.floticey.waypoints.gui;

import at.floticey.waypoints.Waypoints;
import at.floticey.waypoints.commands.WaypointsCommand;
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
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            int startSlot = 10;
            int MAX_SLOTS_PER_ROW = 7;
            int MAX_SLOTS_PER_PAGE = 28;
            int currentSlot = 10;

            Inventory inv = Bukkit.createInventory(player, 54, ChatColor.BLUE + "Waypoints");

            ItemStack next = new ItemStack(Material.STONE_BUTTON);
            ItemMeta nextmeta = next.getItemMeta();
            nextmeta.setDisplayName(ChatColor.RESET + "weiter");
            next.setItemMeta(nextmeta);
            inv.setItem(50, next);

            ItemStack back = new ItemStack(Material.STONE_BUTTON);
            ItemMeta backmeta = back.getItemMeta();
            backmeta.setDisplayName(ChatColor.RESET + "zurück");
            back.setItemMeta(backmeta);
            inv.setItem(48, back);

            ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta framemeta = frame.getItemMeta();
            framemeta.setDisplayName("");
            frame.setItemMeta(framemeta);
            for (int i : new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 18, 27, 36, 45, 46, 47, 49, 51, 52, 53, 44, 35, 26, 17}) {
                inv.setItem(i, frame);
            }

            for (Waypoint waypoint : Waypoints.waypoints) {
                ItemStack waypointitem = new ItemStack(Material.PAPER);
                ItemMeta waypointmeta = waypointitem.getItemMeta();
                waypointmeta.setDisplayName(ChatColor.RESET + (ChatColor.GREEN + waypoint.name));
                waypointitem.setItemMeta(waypointmeta);
                currentSlot++;

                if (currentSlot + 1 % MAX_SLOTS_PER_ROW == 0) {
                    currentSlot += 3;
                }

                if (currentSlot + 1 >= MAX_SLOTS_PER_PAGE)
                    break;
                inv.setItem(currentSlot, waypointitem);
            }
            player.openInventory(inv);
        }
        return false;
    }
}