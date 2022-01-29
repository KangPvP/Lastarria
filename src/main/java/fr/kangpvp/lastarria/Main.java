package fr.kangpvp.lastarria;

import fr.kangpvp.lastarria.commands.CommandTest;
import fr.kangpvp.lastarria.listeners.ListenersManager;
import fr.kangpvp.lastarria.utils.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Salut la famille good ou pas ?");
        System.out.println("Test BRs5");

        new ListenersManager(this).RegisterListeners();
        Bukkit.getPluginCommand("test").setExecutor((CommandExecutor) new CommandTest());


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
