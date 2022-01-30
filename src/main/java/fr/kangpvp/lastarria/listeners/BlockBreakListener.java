package fr.kangpvp.lastarria.listeners;

import fr.kangpvp.lastarria.events.SpawnerBreakEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onSpawnerBreak(org.bukkit.event.block.BlockBreakEvent e){
        //we need to figure out if they broke a spawner or not
        Block blockBroken = e.getBlock();
        if (blockBroken.getType().equals(Material.SPAWNER) && e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && e.getPlayer().hasPermission("cortexspawner.silk")) {
            Bukkit.getServer().getPluginManager().callEvent(new SpawnerBreakEvent(e.getPlayer(), blockBroken));
        }else if(blockBroken.getType().equals(Material.SPAWNER) && e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH )&& !(e.getPlayer().hasPermission("cortexspawner.silk"))){
            //dont have perms to silk break
            e.getPlayer().sendMessage(ChatColor.GRAY + "Tu peux maintenant obtenir des spawners avec silk touch");
        }
    }

}

