package me.hardermode;

import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hardermode extends JavaPlugin implements Listener {

    private FileConfiguration config = getConfig();
    private World world;
    private Server server;

    @Override
    public void onEnable() {
        System.out.println("Inicializando plugin");

        server = getServer();
        server.getPluginManager().registerEvents(this, this);

        world = server.getWorlds().get(0);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
