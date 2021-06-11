package me.hardermode.customitems;

import me.hardermode.helpers.Helpers;
import org.bukkit.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public class LitwarAxe extends CustomItems {

  private static List<String> loreList = Arrays.asList("\"In my heart, it is always summer\"", "- Litwar");

  public LitwarAxe() {
    super(Material.DIAMOND_AXE, "Litwar's Axe", loreList);
  }

  public static void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event, Server server, JavaPlugin plugin) {
    LivingEntity entity = Helpers.cast(event.getEntity(), LivingEntity.class);
    LivingEntity damager = Helpers.cast(event.getDamager(), LivingEntity.class);
    if(entity != null && damager != null) {
      EntityEquipment inventory = damager.getEquipment();
      if(inventory != null) {
        ItemMeta meta = inventory.getItemInMainHand().getItemMeta();
        if(meta != null) {
          if(meta.hasLore()) {
            List<String> itemLore = meta.getLore();
            boolean sameLore = true;
            for(String lore : itemLore) {
              sameLore = sameLore && loreList.contains(lore);
              if(!sameLore) break;
            }
            if(sameLore) {
              server.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                World world = entity.getWorld();
                if(!entity.isDead()) {
                  Location loc = entity.getLocation();
                  Player player = Helpers.cast(damager, Player.class);
                  int invokeTimes = 3;
                  if(player.getName().equals("litwar")) {
                    invokeTimes = 7;
                  }
                  for(int i = 0; i < invokeTimes; i++) {
                    world.strikeLightning(loc);
                  }
                }
              }, 15L);
            }
          }
        }
      }
    }
  }
}
