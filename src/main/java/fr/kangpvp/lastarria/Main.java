package fr.kangpvp.lastarria;

import fr.kangpvp.lastarria.commands.CommandSpawn;
import fr.kangpvp.lastarria.commands.Commandec;
import fr.kangpvp.lastarria.commands.Commandrtp;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Salut la famille good ou pas ?");
        System.out.println("Test BR5");
        getCommand("spawn").setExecutor(new CommandSpawn());
        getCommand("rtp").setExecutor(new Commandrtp());
        getCommand("ec").setExecutor(new Commandec());
        getServer().getPluginManager().registerEvents(new MainListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
