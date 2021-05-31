package me.hardermode;

import me.hardermode.buff.Buff;
import me.hardermode.configuration.Configuration;
import me.hardermode.helpers.Helpers;
import me.hardermode.loot.Loot;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public final class Hardermode extends JavaPlugin implements Listener {

  private FileConfiguration config = getConfig();
  private World world;
  private Server server;

  @Override
  public void onEnable() {
    System.out.println("Starting plugin - [hardermode]");

    server = getServer();
    server.getPluginManager().registerEvents(this, this);
    Configuration.startConfiguration(server).configure();
    world = server.getWorlds().get(0);
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
  public void onLootGenerationAddEnderEye(LootGenerateEvent event) {
    long seed = world.getSeed();
    ItemStack enderEye = new ItemStack(Material.ENDER_EYE, 0);
    double changeToBePresent = 0;
    LootTable lootTable = event.getLootTable();
    if(Loot.isSameLootTableOn(lootTable, LootTables.ABANDONED_MINESHAFT)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 3));
      changeToBePresent = 0.01;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.BASTION_TREASURE)) {
      changeToBePresent = 0.1;
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 4));
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.BASTION_BRIDGE)) {
      changeToBePresent = 0.05;
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 2));
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.BASTION_HOGLIN_STABLE)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 2));
      changeToBePresent = 0.05;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.BURIED_TREASURE)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 2));
      changeToBePresent = 0.02;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.END_CITY_TREASURE)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 5));
      changeToBePresent = 0.1;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.DESERT_PYRAMID)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 2));
      changeToBePresent = 0.01;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.IGLOO_CHEST)) {
      enderEye.setAmount(1);
      changeToBePresent = 0.05;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.JUNGLE_TEMPLE)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 3));
      changeToBePresent = 0.04;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.NETHER_BRIDGE)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 5));
      changeToBePresent = 0.2;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.PILLAGER_OUTPOST)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 2));
      changeToBePresent = 0.05;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.RUINED_PORTAL)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 3));
      changeToBePresent = 0.01;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.SHIPWRECK_SUPPLY)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 3));
      changeToBePresent = 0.03;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.SHIPWRECK_TREASURE)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 2));
      changeToBePresent = 0.07;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.SIMPLE_DUNGEON)) {
      enderEye.setAmount(1);
      changeToBePresent = 0.01;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.UNDERWATER_RUIN_BIG)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 2));
      changeToBePresent = 0.08;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.WOODLAND_MANSION)) {
      enderEye.setAmount(Helpers.randomIntMinMax(seed, 1, 5));
      changeToBePresent = 0.1;
    }
    Loot.addItemStackIntoChest(enderEye, event.getLoot(), changeToBePresent);
  }

  @EventHandler
  public void onMonsterSpawnBuffIt(CreatureSpawnEvent event) {
    Monster monster = Helpers.castMonster(event.getEntity());
    if(monster != null) {
      AttributeInstance maxHealthAttribute = monster.getAttribute(Attribute.GENERIC_MAX_HEALTH);
      AttributeInstance attackDamage = monster.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
      if(maxHealthAttribute != null) {
        double buff = Buff.buffAttribute(maxHealthAttribute, 0.3);
        monster.setHealth(buff);
      }
      if(attackDamage != null) {
        Buff.buffAttribute(attackDamage, 0.25);
      }
    }
  }

  @EventHandler
  public void onIllagerSpawnReplaceByIllusioner(CreatureSpawnEvent event) {
    Entity entity = event.getEntity();
    if(entity instanceof Illager && !(entity instanceof Spellcaster)) {
      boolean shouldSpawnIllusionerInstead = Math.random() < 0.1;
      if(shouldSpawnIllusionerInstead) {
        event.setCancelled(true);
        entity.getWorld().spawnEntity(event.getLocation(), EntityType.ILLUSIONER);
      }
    }
  }

  @Override
  public void onDisable() {
    System.out.println("Ending plugin - [hardermode]");
  }
}
