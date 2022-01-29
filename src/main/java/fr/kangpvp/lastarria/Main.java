package fr.kangpvp.lastarria;

import fr.kangpvp.lastarria.commands.CommandSpawn;
import fr.kangpvp.lastarria.commands.Commandrtp;
import fr.kangpvp.lastarria.utils.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Salut la famille good ou pas ?");
        System.out.println("Test BR5");
        getCommand("spawn").setExecutor(new CommandSpawn());
        getCommand("rtp").setExecutor(new Commandrtp());


        //loadConfigManager;
        ConfigManager.getInstance().setup();
        ConfigManager.getInstance().savePlayersData();
        ConfigManager.getInstance().reloadPlayersData();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
