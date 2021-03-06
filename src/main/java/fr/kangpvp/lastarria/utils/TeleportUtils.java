package fr.kangpvp.lastarria.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Random;

public class TeleportUtils {

    public static HashSet<Material> bad_blocks = new HashSet<>();

    static{
        bad_blocks.add(Material.LAVA);
    }

    public static Location generateLocation(Player player){

        Random random = new Random();

        int x = random.nextInt(2000);
        int y = 300;
        int z = random.nextInt(2000);

        Location randomLocation = new Location(Bukkit.getWorld("world"), x, y, z);

        y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);
        randomLocation.setY(y);

        if(isLocationSafe(randomLocation)){
            return randomLocation;
        }else{
            Location dummy = new Location(Bukkit.getWorld("viking"), -431.556, 117, -197.420, 90.9f, -1.0f);
            return dummy;
        }
    }

    public static boolean isLocationSafe(Location location){

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        Block block = location.getWorld().getBlockAt(x, y, z);
        Block below = location.getWorld().getBlockAt(x, y - 1, z);
        Block above = location.getWorld().getBlockAt(x, y + 1, z);

        return !(bad_blocks.contains(below.getType()) || block.getType().isSolid() || (above.getType().isSolid()));
    }
}
