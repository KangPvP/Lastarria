package fr.kangpvp.lastarria;

import fr.kangpvp.lastarria.commands.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    public ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public void onEnable() {
        System.out.println("Salut la famille good ou pas ?");
        System.out.println("Test BR5");
        getCommand("spawn").setExecutor(new CommandSpawn());
        getCommand("rtp").setExecutor(new Commandrtp());
        getCommand("ec").setExecutor(new Commandec());
        getCommand("fly").setExecutor(new CommandFly(this));
        getCommand("vanish").setExecutor(new CommandVanish(this));
        getCommand("tpall").setExecutor(new CommandTpall());

        getServer().getPluginManager().registerEvents(new MainListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}