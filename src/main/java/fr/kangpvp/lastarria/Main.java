package fr.kangpvp.lastarria;

import fr.kangpvp.lastarria.commands.*;
import fr.kangpvp.lastarria.commands.tp.CommandTpa;
import fr.kangpvp.lastarria.commands.tp.CommandTpaccept;
import fr.kangpvp.lastarria.commands.tp.CommandTpdenny;
import fr.kangpvp.lastarria.listeners.BlockBreakListener;
import fr.kangpvp.lastarria.listeners.CortexListeners;
import fr.kangpvp.lastarria.utils.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Main extends JavaPlugin {

    public ArrayList<Player> invisible_list = new ArrayList<>();
    public Map<Player, Player> tpa = new HashMap<Player, Player>();

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

        getCommand("tpa").setExecutor((CommandExecutor)new CommandTpa(this));
        getCommand("tpaccept").setExecutor((CommandExecutor)new CommandTpaccept(this));
        getCommand("tpdenny").setExecutor((CommandExecutor)new CommandTpdenny(this));

        Bukkit.getPluginManager().registerEvents(new MainListener(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents(new CortexListeners(), (Plugin)this);

        //loadConfigManager();
        ConfigManager.getInstance().setup();
        ConfigManager.getInstance().savePlayersData();
        ConfigManager.getInstance().reloadPlayersData();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}