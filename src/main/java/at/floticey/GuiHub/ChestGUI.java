package at.floticey.GuiHub;

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

import java.util.Arrays;

public class ChestGUI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            Inventory inv = Bukkit.createInventory(player, 27, ChatColor.BLACK + "Hubs");

            ItemStack limedye = new ItemStack(Material.LIME_DYE);
            ItemMeta limedyemeta = limedye.getItemMeta();
            limedyemeta.setDisplayName(ChatColor.GREEN + "Set Spawn");
            limedyemeta.setLore(Arrays.asList(ChatColor.GRAY + "Set Spawnpoint"));
            limedye.setItemMeta(limedyemeta);
            inv.setItem(11, limedye);

            ItemStack paper = new ItemStack(Material.PAPER);
            ItemMeta papermeta = paper.getItemMeta();
            papermeta.setDisplayName(ChatColor.BLACK + "Next Page");
            paper.setItemMeta(papermeta);
            inv.setItem(26, paper);

            ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
            ItemMeta enderpearlmeta = enderpearl.getItemMeta();
            enderpearlmeta.setDisplayName(ChatColor.GOLD + "Go to Spawn");
            enderpearlmeta.setLore(Arrays.asList(ChatColor.GRAY + "Come to Spawn"));
            enderpearl.setItemMeta(enderpearlmeta);
            inv.setItem(13, enderpearl);

            ItemStack reddye = new ItemStack(Material.RED_DYE);
            ItemMeta reddyemeta = reddye.getItemMeta();
            reddyemeta.setDisplayName(ChatColor.RED + "Delete Spawn");
            reddyemeta.setLore(Arrays.asList(ChatColor.GRAY + "Delete current Spawnpoint"));
            reddye.setItemMeta(reddyemeta);
            inv.setItem(15, reddye);

            ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta framemeta = frame.getItemMeta();
            framemeta.setDisplayName("");
            frame.setItemMeta(framemeta);
            for (int i : new int[] {1,2,3,4,5,6,7,8,9,17,18,19,20,21,22,23,24,25}) {
                inv.setItem(i, frame);
            }

            ItemStack close = new ItemStack(Material.BARRIER);
            ItemMeta closemeta = close.getItemMeta();
            closemeta.setDisplayName(ChatColor.RED + "Exit");
            close.setItemMeta(closemeta);
            inv.setItem(0, close);

            player.openInventory(inv);

        }


        return false;
    }
}
