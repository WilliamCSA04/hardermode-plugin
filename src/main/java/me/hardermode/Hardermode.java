package me.hardermode;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;
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

    @EventHandler
    public void doubleDamage(EntityDamageByEntityEvent event) {
        double damage = event.getDamage();
        event.setDamage(damage + damage * 0.2);
    }

    @EventHandler
    public void destroyShieldOnCreeperExplosion(PlayerItemDamageEvent event) {
        ItemStack item = event.getItem();
        boolean isShield = item.getType() == Material.SHIELD;
        if(isShield) {
            ItemMeta itemMeta = item.getItemMeta();
            if(itemMeta instanceof Damageable) {
                Damageable damagedShieldMeta = (Damageable) itemMeta;
                damagedShieldMeta.setDamage(10000);
                item.setItemMeta((ItemMeta) damagedShieldMeta);
            }
        }
    }

    @Override
    public void onDisable() {
        System.out.println("Starting plugin - [hardermode]");
    }
}
