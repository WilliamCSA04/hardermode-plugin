package me.hardermode;

import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hardermode extends JavaPlugin implements Listener {

    private FileConfiguration config = getConfig();
    private World world;
    private Server server;

    @Override
    public void onEnable() {
        System.out.println("Starting plugin - [hardermode]");

        server = getServer();
        server.getPluginManager().registerEvents(this, this);

        world = server.getWorlds().get(0);

    }

    public void onDamage(EntityDamageByEntityEvent event) {
        double damage = event.getDamage();
        event.setDamage(damage * 0.2);
    }

    @Override
    public void onDisable() {
        System.out.println("Starting plugin - [hardermode]");
    }
}
