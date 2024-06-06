package at.floticey.waypoints.gui;

import at.floticey.waypoints.Waypoints;
import at.floticey.waypoints.dto.Waypoint;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class WaypointsGUI {
    private static final int[] BORDER_SLOTS = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 18, 27, 36, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 45, 35, 26, 17};
    private static final int PAGINATION_NEXT_SLOT = 51;
    private static final int PAGINATION_BACK_SLOT = 47;
    private static final int[] WAYPOINT_SLOTS = new int[]{10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43};
    private static final String WAYPOINT_UUID_KEY = "WAYPOINT_UUID";
    private Inventory inv;
    private List<Waypoint> waypoints;

    private int currentSlot;
    private int MAX_SLOTS_PER_ROW;
    private int MAX_SLOTS_PER_PAGE;
    private int currentPage;

    public WaypointsGUI(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
        this.currentPage = 0;
        this.currentSlot = 10;
        this.MAX_SLOTS_PER_ROW = 7;
        this.MAX_SLOTS_PER_PAGE = 28;
    }

    private void generateFrame() {
        if (this.inv == null) return;
        ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta framemeta = frame.getItemMeta();
        framemeta.setDisplayName(ChatColor.RESET + " ");
        frame.setItemMeta(framemeta);
        for (int i : BORDER_SLOTS) {
            inv.setItem(i, frame);
        }
    }

    private void generatePaginationButtons(Boolean back, Boolean next) {
        if (this.inv == null) return;
        ItemStack backButton;
        ItemStack nextButton;


        if (back) {
            backButton = new ItemStack(Material.RED_TERRACOTTA);
            ItemMeta buttonmeta = backButton.getItemMeta();
            buttonmeta.setDisplayName(ChatColor.RESET + "Back");
            backButton.setItemMeta(buttonmeta);
        } else {
            backButton = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta backMeta = backButton.getItemMeta();
            backMeta.setDisplayName(ChatColor.RESET + " ");
            backButton.setItemMeta(backMeta);
        }

        if (next) {
            nextButton = new ItemStack(Material.LIME_TERRACOTTA);
            ItemMeta buttonmeta = nextButton.getItemMeta();
            buttonmeta.setDisplayName(ChatColor.RESET + "Next");
            nextButton.setItemMeta(buttonmeta);
        } else {
            nextButton = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta nextMeta = nextButton.getItemMeta();
            nextMeta.setDisplayName(ChatColor.RESET + " ");
            nextButton.setItemMeta(nextMeta);
        }

        inv.setItem(PAGINATION_BACK_SLOT, backButton);
        inv.setItem(PAGINATION_NEXT_SLOT, nextButton);
    }

    private void generateWaypoints(int page) {
        if (this.inv == null || waypoints.isEmpty()) return;
        this.currentSlot = 10;

        List<Waypoint> pageWaypoints = this.waypoints.subList(page * MAX_SLOTS_PER_PAGE, Math.min((page + 1) * MAX_SLOTS_PER_PAGE, this.waypoints.size()));

        this.generatePaginationButtons(page > 0, (page + 1) * MAX_SLOTS_PER_PAGE < this.waypoints.size());

        for (int slot : WAYPOINT_SLOTS) {
            inv.setItem(slot, null);
        }

        int currentWaypointSlot = 0;
        for (Waypoint waypoint : pageWaypoints) {
            ItemStack waypointitem = new ItemStack(Material.COMPASS);
            CompassMeta waypointmeta = (CompassMeta) waypointitem.getItemMeta();
            waypointmeta.setDisplayName(ChatColor.RESET + (ChatColor.GREEN + waypoint.name));
            waypointmeta.getPersistentDataContainer().set(new NamespacedKey(Waypoints.getPlugin(), this.WAYPOINT_UUID_KEY), PersistentDataType.STRING, waypoint.uuid.toString());
            waypointmeta.setLore(Arrays.asList(ChatColor.GRAY + "X: " + waypoint.location.getBlockX(), ChatColor.GRAY + "Y: " + waypoint.location.getBlockY(), ChatColor.GRAY + "Z: " + waypoint.location.getBlockZ()));
            waypointmeta.setLodestone(waypoint.location);
            waypointmeta.setLodestoneTracked(false);
            waypointitem.setItemMeta(waypointmeta);
            inv.setItem(currentSlot, waypointitem);
            currentWaypointSlot++;
            if (currentWaypointSlot >= MAX_SLOTS_PER_PAGE)
                break;
            else if (currentWaypointSlot % MAX_SLOTS_PER_ROW == 0) {
                currentSlot += 3;
            } else {
                currentSlot++;
            }
        }
    }

    public void handleClick(org.bukkit.event.inventory.InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getClickedInventory().getType().equals(InventoryType.PLAYER)) return;
        e.setCancelled(true);

        if (e.getRawSlot() == PAGINATION_NEXT_SLOT && e.getCurrentItem().getType().equals(Material.LIME_TERRACOTTA)) {
            //next page
            this.currentPage++;
            this.generateWaypoints(this.currentPage);
        } else if (e.getRawSlot() == PAGINATION_BACK_SLOT && e.getCurrentItem().getType().equals(Material.RED_TERRACOTTA)) {
            //back page
            Math.max(0, this.currentPage--);
            this.generateWaypoints(this.currentPage);
        } else if (Arrays.stream(WaypointsGUI.WAYPOINT_SLOTS).anyMatch(slot -> slot == e.getRawSlot())) {
            //waypoint
            player.closeInventory();
            ItemStack clickedItem = e.getClickedInventory().getItem(e.getRawSlot());
            UUID waypointUUID = UUID.fromString(clickedItem.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Waypoints.getPlugin(), this.WAYPOINT_UUID_KEY), PersistentDataType.STRING));
            Waypoint waypoint = Waypoints.waypoints.stream().filter(wp -> wp.uuid.equals(waypointUUID)).findFirst().orElse(null);
            if (waypoint == null) return;
            player.sendMessage(ChatColor.GREEN + "Teleporting to " + waypoint.name + "...");
            player.teleport(waypoint.location);
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        }
    }

    public void openGUI(Player player) {
        this.inv = Bukkit.createInventory(player, 54, "Waypoints");
        this.generateFrame();
        this.generateWaypoints(this.currentPage);
        Waypoints.playerGUIs.put(player.getUniqueId(), this);
        player.openInventory(inv);
    }
}
