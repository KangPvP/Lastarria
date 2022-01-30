package fr.kangpvp.lastarria;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MainListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Location join = new Location(Bukkit.getWorld("viking"), -431.556, 117, 197.420, 90.9f, -1.0f);
        player.teleport(join);
    }
}