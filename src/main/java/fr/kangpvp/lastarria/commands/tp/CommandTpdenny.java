package fr.kangpvp.lastarria.commands.tp;

import fr.kangpvp.lastarria.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTpdenny implements CommandExecutor {
    private Main main;

    public CommandTpdenny(Main main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        String splayer = player.getName();
        if(sender instanceof Player) {
            Player target = Bukkit.getPlayer(args[0]);
            String starget = target.getName();
            if(target != null && target.isOnline()) {

                if(main.tpa.containsKey(target) && main.tpa.get(target) == player) {

                    main.tpa.remove(target);
                    player.sendMessage("§bVous venez de refuser la demande de tp de " + starget);
                    target.sendMessage("§b" + splayer + " a refuser votre demande de tp");
                }else {
                    player.sendMessage("§8Vous n'avez pas recu de demande de tp de la par "+ starget);
                }

            }else {player.sendMessage("§8Ce joueur n'existe pas ou n'est pas en ligne");}
        }else {player.sendMessage("§8Seul un joueur peut executé cette commande");}
        return false;
    }
}
