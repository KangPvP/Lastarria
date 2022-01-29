package fr.kangpvp.lastarria.listeners;

import fr.kangpvp.lastarria.Main;
import fr.kangpvp.lastarria.listeners.players.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenersManager {
    public Plugin plugin;
    public PluginManager pluginManager;

    public ListenersManager(Main plugin) {
        this.plugin = plugin;
        this.pluginManager= Bukkit.getPluginManager();
    }

    public void RegisterListeners() {
        //Players
        this.pluginManager.registerEvents(new PlayerJoinListener(), this.plugin);

        //Worlds
    }
}
