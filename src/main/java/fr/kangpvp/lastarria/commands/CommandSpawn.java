package fr.kangpvp.lastarria.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Location spawn = new Location(Bukkit.getWorld("viking"), 119.700, 68, 202.252, 89.8f, 5.6f);
            player.sendMessage("§aTu as bien été téléporté au spawn");
            player.sendMessage("§4Le PVP est désactivé");
            player.teleport(spawn);
        }

        return false;
    }
}
