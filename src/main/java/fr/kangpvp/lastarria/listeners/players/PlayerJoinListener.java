package fr.kangpvp.lastarria.listeners.players;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player player = e.getPlayer();
        Location base = new Location(Bukkit.getWorld("viking"), 119.700, 68, 202.252, 89.8f, 5.6f);
        player.teleport(base);

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){

        Player p = event.getPlayer();
        Action action = event.getAction();

        if(event.getClickedBlock() != null && action == Action.RIGHT_CLICK_BLOCK){

            BlockState bs = event.getClickedBlock().getState();
            if(bs instanceof Sign)
            {
                Sign sign = (Sign) bs;

                if(sign.getLine(0).equalsIgnoreCase("[Téléportation]") && sign.getLine(1).equalsIgnoreCase("Monde survie"))
                {
                    p.teleport((Location) Bukkit.getWorld("world"));
                    p.sendMessage("§bTu as été téléporté en monde survie");
                }
            }
        }
    }
}
