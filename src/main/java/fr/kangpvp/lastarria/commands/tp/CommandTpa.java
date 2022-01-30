package fr.kangpvp.lastarria.commands.tp;

import fr.kangpvp.lastarria.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTpa implements CommandExecutor {

    private Main main;

    public CommandTpa(Main main) {
        this.main = main;
    }

    @SuppressWarnings("null")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(sender instanceof Player) {
            Player target = Bukkit.getPlayer(args[0]);
            String starget = args[0];
            String splayer = player.getName();

            if(target != null || target.isOnline()) {
                main.tpa.put(player, target); //qui veux se tp a qui?  player ==>  target  (enregistrement)
                player.sendMessage("§b Vous avez demandé a " + starget + " pour ce tp a lui.");
                target.sendMessage("§b" + splayer + " demande pour ce tp a vous");
                target.sendMessage("§8faite /tpaccept " + splayer + " ou /tpdenny " + splayer);

            }else {
                player.sendMessage("§8Ce joueur n'est pas en ligne ou n'exise pas");
            }
        }else {
            player.sendMessage("§8Seul un joueur peut executé cette commande");
        }
        return false;
    }

}

