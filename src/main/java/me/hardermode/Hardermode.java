package me.hardermode;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
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
    public void onCreeperExplosion(EntityDamageByEntityEvent event) {
        boolean isCreeperExplosion = event.getDamager() instanceof Creeper;
        if(isCreeperExplosion) {
            boolean isPlayer = event.getEntity() instanceof Player;
            if(isPlayer) {
                Player player = (Player) event.getEntity();
                if(player.isBlocking()) {
                    ItemStack shield = null;
                    PlayerInventory inventory = player.getInventory();
                    if(inventory.getItemInOffHand().getType() == Material.SHIELD) {
                        shield = inventory.getItemInOffHand();
                    } else if(inventory.getItemInMainHand().getType() == Material.SHIELD) {
                        shield = inventory.getItemInMainHand();
                    }
                    if(shield != null) {
                        if(shield.getItemMeta() instanceof Damageable) {
                            Damageable damagedShield = (Damageable) shield.getItemMeta();
                            damagedShield.setDamage(750);
                            shield.setItemMeta((ItemMeta) damagedShield);
                        }
                    }

                }
            }
        }
    }

    @Override
    public void onDisable() {
        System.out.println("Starting plugin - [hardermode]");
    }
}
