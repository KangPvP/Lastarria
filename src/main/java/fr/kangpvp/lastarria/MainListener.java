package fr.kangpvp.lastarria;

import fr.kangpvp.lastarria.utils.TeleportUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class MainListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Location join = new Location(player.getWorld(), 119.700, 68, 202.252, 89.8f, 5.6f);
        player.teleport(join);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();

        if(event.getClickedBlock() != null && action == Action.RIGHT_CLICK_BLOCK)
        {
            BlockState bs = event.getClickedBlock().getState();
            if(bs instanceof Sign)
            {
                Sign sign = (Sign) bs;
                if(sign.getLine(0).equalsIgnoreCase("[Téléportation]") && sign.getLine(2).equalsIgnoreCase("Monde Survie"))
                {
                    Location world = new Location(Bukkit.getWorld("world"),  0, 63, 0);
                    player.teleport(world);
                    player.sendMessage("§bTu es maintenant en monde survie");
                }
            }
        }
    }
}