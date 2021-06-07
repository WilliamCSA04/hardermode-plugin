package me.hardermode;

import me.hardermode.buff.Buff;
import me.hardermode.configuration.Configuration;
import me.hardermode.helpers.Helpers;
import me.hardermode.loot.Loot;
import me.hardermode.tippedarrow.TippedArrow;
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
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

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
  public void onArrowHittingPlayer(EntityDamageByEntityEvent event) {
    boolean isArrow = event.getDamager() instanceof Arrow;
    if(isArrow) {
      Arrow arrow = (Arrow) event.getDamager();
      LivingEntity entity = Helpers.castLivingEntity(event.getEntity());
      Collection<PotionEffect> effects = entity.getActivePotionEffects();
      for(PotionEffect effect : effects) {
        int amplifier = effect.getAmplifier();
        int MAX_LEVEL = 4;
        if(amplifier < MAX_LEVEL) {
          int amplified = effect.getAmplifier() + 1;
          PotionEffect amplifiedEffect = new PotionEffect(effect.getType(), effect.getDuration(), amplified);
          amplifiedEffect.apply(entity);
        }
      }
    }
  }

  @EventHandler
  public void onLootGenerationAddEnderEye(LootGenerateEvent event) {
    ItemStack enderEye = new ItemStack(Material.ENDER_EYE, 0);
    double changeToBePresent = 0;
    LootTable lootTable = event.getLootTable();
    if(Loot.isSameLootTableOn(lootTable, LootTables.ABANDONED_MINESHAFT)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 3));
      changeToBePresent = 0.01;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.BASTION_TREASURE)) {
      changeToBePresent = 0.4;
      enderEye.setAmount(Helpers.randomIntMinMax(1, 4));
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.BASTION_BRIDGE)) {
      changeToBePresent = 0.05;
      enderEye.setAmount(Helpers.randomIntMinMax(1, 2));
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.BASTION_HOGLIN_STABLE)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 2));
      changeToBePresent = 0.05;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.BURIED_TREASURE)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 2));
      changeToBePresent = 0.02;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.END_CITY_TREASURE)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 5));
      changeToBePresent = 0.1;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.DESERT_PYRAMID)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 2));
      changeToBePresent = 0.01;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.IGLOO_CHEST)) {
      enderEye.setAmount(1);
      changeToBePresent = 0.05;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.JUNGLE_TEMPLE)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 3));
      changeToBePresent = 0.04;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.NETHER_BRIDGE)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 5));
      changeToBePresent = 0.3;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.PILLAGER_OUTPOST)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 2));
      changeToBePresent = 0.05;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.RUINED_PORTAL)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 3));
      changeToBePresent = 0.01;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.SHIPWRECK_SUPPLY)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 3));
      changeToBePresent = 0.03;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.SHIPWRECK_TREASURE)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 2));
      changeToBePresent = 0.07;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.SIMPLE_DUNGEON)) {
      enderEye.setAmount(1);
      changeToBePresent = 0.01;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.UNDERWATER_RUIN_BIG)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 2));
      changeToBePresent = 0.08;
    } else if(Loot.isSameLootTableOn(lootTable, LootTables.WOODLAND_MANSION)) {
      enderEye.setAmount(Helpers.randomIntMinMax(1, 5));
      changeToBePresent = 0.15;
    }
    Loot.addItemStackIntoChest(enderEye, event.getLoot(), changeToBePresent);
  }

  @EventHandler
  public void onSpawnNormalSkeleton(CreatureSpawnEvent event) {
    Skeleton skeleton = Helpers.cast(event.getEntity(), Skeleton.class);
    if(skeleton != null) {
      boolean isStray = skeleton instanceof Stray;
      boolean isWitherSkeleton = skeleton instanceof WitherSkeleton;
      if(!isStray && !isWitherSkeleton) {
        boolean spawnWithSpecialArrow = Math.random() < 0.15;
        if(spawnWithSpecialArrow) {
          List<String> arrows = new ArrayList<>();
          arrows.add(TippedArrow.Variant.DECAY.toString());
          arrows.add(TippedArrow.Variant.POISON.toString());
          arrows.add(TippedArrow.Variant.HARMING.toString());
          arrows.add(TippedArrow.Variant.WEAKNESS.toString());
          int position = new Random().nextInt(arrows.size());
          skeleton.setMetadata("SpecialArrow", new FixedMetadataValue(this, arrows.get(position)));
        }
      }
    }
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

      int arrowCD = monster.getArrowCooldown() / 2;
      monster.setArrowCooldown(arrowCD);
    }
  }

  @EventHandler
  public void onElderGuardianSpawn(CreatureSpawnEvent event) {
    ElderGuardian elderGuardian = Helpers.cast(event.getEntity(), ElderGuardian.class);
    if(elderGuardian != null) {
      AttributeInstance maxHealth = elderGuardian.getAttribute(Attribute.GENERIC_MAX_HEALTH);
      AttributeInstance attackDamage = elderGuardian.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
      AttributeInstance armor = elderGuardian.getAttribute(Attribute.GENERIC_ARMOR);
      if(maxHealth != null) {
        double buff = Buff.buffAttribute(maxHealth, 0.2);
        elderGuardian.setHealth(buff);
      }
      if(attackDamage != null) {
        Buff.buffAttribute(attackDamage, 0.1);
      }
      if(armor != null) {
        Buff.buffAttribute(armor, 0.5);
      }
    }
  }

  @EventHandler
  public void onBattleWithElderGuardian(EntityDamageByEntityEvent event){
    ElderGuardian elderGuardian = Helpers.cast(event.getEntity(), ElderGuardian.class);
    if(elderGuardian != null) {
      Entity entity = event.getDamager();
      LivingEntity livingEntity = Helpers.cast(entity, LivingEntity.class);
      if(livingEntity != null) {
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.POISON, 300, 0);
        potionEffect.apply(livingEntity);
      } else {
        Projectile projectile = Helpers.cast(entity, Projectile.class);
        if(projectile != null) {
          livingEntity = Helpers.cast(projectile.getShooter(), LivingEntity.class);
          if(livingEntity != null) {
            PotionEffect potionEffect = new PotionEffect(PotionEffectType.BLINDNESS, 600, 0);
            potionEffect.apply(livingEntity);
          }
        }
      }
    }
  }

  @EventHandler
  public void onElderGuardianDeath(EntityDeathEvent event) {
    ElderGuardian elderGuardian = Helpers.cast(event.getEntity(), ElderGuardian.class);
    if(elderGuardian != null) {
      elderGuardian.getWorld().createExplosion(elderGuardian.getLocation(), 4F);
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

  @EventHandler
  public void onDeathChangeDrops(EntityDeathEvent event) {
    Entity entity = event.getEntity();
    double rng = Math.random();
    List<ItemStack> drops = event.getDrops();
    if(entity instanceof ElderGuardian) {
      ItemStack trident = new ItemStack(Material.TRIDENT);
      drops.add(trident);
      if(rng < 0.05) {
        ItemStack enchantedGoldenApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        drops.add(enchantedGoldenApple);
      }
    }
    if(entity instanceof Husk) {
      if(rng < 0.1) {
        ItemStack sand = new ItemStack(Material.SAND);
        drops.add(sand);
      }
    } else if(entity instanceof Skeleton) {
      List<MetadataValue> metadataList = entity.getMetadata("SpecialArrow");
      if(metadataList.size() > 0) {
        String skeletonSpecialArrow = metadataList.get(0).asString();
        Random random = new Random();
        int amplifier = random.nextInt(5);
        int quantity = random.nextInt(5) + 1;
        if(TippedArrow.Variant.POISON.toString().equals(skeletonSpecialArrow)) {
          ItemStack tippedArrow = TippedArrow.tippedArrowBuilder(PotionEffectType.POISON, PotionType.POISON, Helpers.randomIntMinMax(100, 900), amplifier);
          tippedArrow.setAmount(quantity);
          drops.add(tippedArrow);
        } else if(TippedArrow.Variant.DECAY.toString().equals(skeletonSpecialArrow)) {
          ItemStack tippedArrow = TippedArrow.tippedArrowBuilder(PotionEffectType.WITHER, PotionType.UNCRAFTABLE, Helpers.randomIntMinMax(100, 600), amplifier);
          ItemMeta tippedArrowItemMeta = tippedArrow.getItemMeta();
          tippedArrowItemMeta.setDisplayName("Withering arrow");
          tippedArrow.setAmount(quantity);
          tippedArrow.setItemMeta(tippedArrowItemMeta);
          drops.add(tippedArrow);
        } else if(TippedArrow.Variant.HARMING.toString().equals(skeletonSpecialArrow)) {
          ItemStack tippedArrow = TippedArrow.tippedArrowBuilder(PotionEffectType.HARM, PotionType.INSTANT_DAMAGE, Helpers.randomIntMinMax(20, 100), amplifier);
          tippedArrow.setAmount(quantity);
          drops.add(tippedArrow);
        } else if(TippedArrow.Variant.WEAKNESS.toString().equals(skeletonSpecialArrow)) {
          ItemStack tippedArrow = TippedArrow.tippedArrowBuilder(PotionEffectType.WEAKNESS, PotionType.WEAKNESS, Helpers.randomIntMinMax(100, 900), amplifier);
          tippedArrow.setAmount(quantity);
          drops.add(tippedArrow);
        }
      }
      if(entity instanceof Stray) {
        if(rng < 0.1) {
          ItemStack ice = new ItemStack(Material.ICE);
          drops.add(ice);
        }
      }
    }
  }

  @EventHandler
  public void onSkeletonShootingArrow(EntityShootBowEvent event) {
    Skeleton skeleton = Helpers.cast(event.getEntity(), Skeleton.class);
    if(skeleton != null) {
      List<MetadataValue> metadataList = skeleton.getMetadata("SpecialArrow");
      if(metadataList.size() > 0) {
        if(!(skeleton instanceof Stray || skeleton instanceof WitherSkeleton)) {
          Arrow project = Helpers.cast(event.getProjectile(), Arrow.class);
          if(project != null) {
            String skeletonSpecialArrow = metadataList.get(0).asString();
            int DEFAULT_AMPLIFIER = 0;
            if(TippedArrow.Variant.POISON.toString().equals(skeletonSpecialArrow)) {
              int tickDuration = Helpers.randomIntMinMax(100, 600);
              project.addCustomEffect(new PotionEffect(PotionEffectType.POISON, tickDuration, DEFAULT_AMPLIFIER), false);
            } else if(TippedArrow.Variant.HARMING.toString().equals(skeletonSpecialArrow)) {
              int tickDuration = Helpers.randomIntMinMax(20, 100);
              project.addCustomEffect(new PotionEffect(PotionEffectType.HARM, tickDuration, DEFAULT_AMPLIFIER), false);
            } else if(TippedArrow.Variant.DECAY.toString().equals(skeletonSpecialArrow)) {
              int tickDuration = Helpers.randomIntMinMax(100, 600);
              project.addCustomEffect(new PotionEffect(PotionEffectType.WITHER, tickDuration, DEFAULT_AMPLIFIER), false);
            } else if(TippedArrow.Variant.WEAKNESS.toString().equals(skeletonSpecialArrow)) {
              int tickDuration = Helpers.randomIntMinMax(200, 900);
              project.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, tickDuration, DEFAULT_AMPLIFIER), false);
            }
          }
        }
      }

    }
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    int noDamageTicks = player.getNoDamageTicks() / 2;
    player.setNoDamageTicks(noDamageTicks);
  }

  @Override
  public void onDisable() {
    System.out.println("Ending plugin - [hardermode]");
  }
}
