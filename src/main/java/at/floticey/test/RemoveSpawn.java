package at.floticey.test;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (player.isOp()) {
                main.location = null;
                player.sendMessage(ChatColor.RED + "Dein Spawn wurde zurückgesetzt!");
            } else {
                player.sendMessage(ChatColor.RED + "Du bist nicht berechtigt einen Spawn zu setzen!");
            }
        }

        return false;
    }
}
