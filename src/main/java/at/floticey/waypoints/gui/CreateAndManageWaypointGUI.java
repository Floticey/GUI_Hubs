package at.floticey.waypoints.gui;

import at.floticey.waypoints.Waypoints;
import at.floticey.waypoints.dto.Waypoint;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class CreateAndManageWaypointGUI {
    private static final int[] BORDER_SLOTS = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 18, 27, 36, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 45, 35, 26, 17};
    private static final int PAGINATION_NEXT_SLOT = 51;
    private static final int PAGINATION_BACK_SLOT = 47;
    private static final int[] WAYPOINT_SLOTS = new int[]{10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43};
    private Inventory inv;
    private Waypoint waypoint;

    public CreateAndManageWaypointGUI(Waypoint waypoint) {
        this.inv = Bukkit.createInventory(null, 54, "Waypoints");

    }

    int currentSlot = 10;
    int MAX_SLOTS_PER_ROW = 7;
    int MAX_SLOTS_PER_PAGE = 28;
    int currentPage = 0;


    private void generateFrame() {
        ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta framemeta = frame.getItemMeta();
        framemeta.setDisplayName(ChatColor.RESET + " ");
        frame.setItemMeta(framemeta);
        for (int i : BORDER_SLOTS) {
            inv.setItem(i, frame);
        }
    }

    private void generateWaypoints(int page) {

    }

    public void openGUI(Player player, List<Waypoint> waypoints) {
        this.inv = Bukkit.createInventory(player, 54, "Waypoints");

        player.openInventory(inv);
    }
}
