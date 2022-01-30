package fr.kangpvp.lastarria.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTpall implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            //Teleport all the online players to you
            if (Bukkit.getServer().getOnlinePlayers().size() == 1){
                player.sendMessage(ChatColor.GREEN + "No other players are on right now.");
            }else if(Bukkit.getServer().getOnlinePlayers().size() > 1){
                int numOfPlayers = 0;
                for(Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.teleport(player.getLocation());
                    numOfPlayers++;
                }
                player.sendMessage(ChatColor.YELLOW + " " + (numOfPlayers - 1) + " joueurs ont été téléportés sur toi.");
            }
        }
        return true;
    }
}
