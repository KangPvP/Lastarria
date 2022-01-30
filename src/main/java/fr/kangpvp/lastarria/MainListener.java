package fr.kangpvp.lastarria;

import fr.kangpvp.lastarria.listeners.BlockBreakListener;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MainListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Location join = new Location(Bukkit.getWorld("viking"), -431.556, 117, 197.420, 90.9f, -1.0f);
        player.teleport(join);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if(player.getLocation().getWorld().equals("viking")){
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onFall(EntityDamageEvent event){
        Entity entity = event.getEntity();
        if(event.getEntity().equals(entity)){
            if(event.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
                if(entity.getWorld().getName().equals("Lobby")){
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent event) {
        Player player = (Player) event.getEntity();
        if(player.getLocation().getWorld().equals("viking")){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if(player.getLocation().getWorld().equals("viking")){
            if (event.isCancelled()) {
                return;
            }
            event.setCancelled(true);
            Bukkit.getScheduler().runTaskLater (Main.INSTANCE, () -> player.updateInventory(), 5);
        }
    }

}