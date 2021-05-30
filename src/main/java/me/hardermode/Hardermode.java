package me.hardermode;

import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
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

    public void doubleDamage(EntityDamageByEntityEvent event) {
        double damage = event.getDamage();
        event.setDamage(damage * 0.2);
    }

    public void destroyShieldOnCreeperExplosion(EntityDamageByEntityEvent event) {
        boolean isEntityExplosion = event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION;
        boolean isCreeper = event.getDamager() instanceof Creeper;
        if(isEntityExplosion && isCreeper) {
            Entity entity = event.getEntity();
            Player player = entity instanceof Player ? (Player) entity : null;
            if(player != null) {
                boolean isBlocking = player.isBlocking();
                if(isBlocking) {
                   ItemMeta shield = player.getInventory().getItemInOffHand().getItemMeta();
                   if(shield instanceof Damageable) {
                       ((Damageable) shield).setDamage(500);
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
