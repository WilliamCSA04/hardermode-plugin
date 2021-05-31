package me.hardermode;

import me.hardermode.helpers.Helpers;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;
import org.bukkit.loot.Lootable;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;
import java.util.List;
import java.util.Random;

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
                    PlayerInventory inventory = player.getInventory();
                    ItemStack shield = Helpers.getAnItemFromPlayersHand(inventory, Material.SHIELD);
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

    @EventHandler
    public void onStrayHittingPlayer(EntityDamageByEntityEvent event) {
        boolean isArrow = event.getDamager() instanceof Arrow;
        if(isArrow) {
            Arrow arrow = (Arrow) event.getDamager();
            boolean isStray = arrow.getShooter() instanceof Stray;
            if(isStray) {
                LivingEntity entity = Helpers.castLivingEntity(event.getEntity());
                Collection<PotionEffect> effects = entity.getActivePotionEffects();
                for(PotionEffect effect : effects) {
                    boolean hasSlow = effect.getType().getName() == PotionEffectType.SLOW.getName();
                    if(hasSlow){
                        int amplifier = effect.getAmplifier();
                        int SLOW_MAX_LEVEL = 3;
                        if(amplifier < SLOW_MAX_LEVEL) {
                            int amplified = effect.getAmplifier() + 1;
                            PotionEffect amplifiedEffect = new PotionEffect(PotionEffectType.SLOW, 600, amplified);
                            amplifiedEffect.apply(entity);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onLootGeneration(LootGenerateEvent event) {
        ItemStack itemStack = new ItemStack(Material.NETHER_STAR);
        LootTables desertPyramid = LootTables.DESERT_PYRAMID;
        System.out.println("desertPyramid.getKey()" + desertPyramid.getKey());
        System.out.println("event.getLootTable().getKey()" + event.getLootTable().getKey());
        System.out.println("desertPyramid.getKey() == event.getLootTable().getKey()" + (desertPyramid.getKey().equals(event.getLootTable().getKey())));

        if(desertPyramid.getKey().equals(event.getLootTable().getKey())) {
            System.out.println("YAY");
            List<ItemStack> items = event.getLoot();
            items.add(itemStack);
        }

    }

    @Override
    public void onDisable() {
        System.out.println("Starting plugin - [hardermode]");
    }
}
