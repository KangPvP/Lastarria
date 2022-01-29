package fr.kangpvp.lastarria;

import fr.kangpvp.lastarria.utils.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
    System.out.println("Salut la street good ou pas ?");


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
