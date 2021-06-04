package me.hardermode.helpers;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Random;

public class Helpers {

  public static int randomIntMinMax(long seed, int min, int max) {
    Random r = new Random(seed);
    return r.nextInt(max) + min;
  }

  public static boolean isAnItemOnPlayersHand(PlayerInventory inventory, Material material) {
    boolean isOnMainHand = inventory.getItemInMainHand().getType() == material;
    boolean isOnOffHand = inventory.getItemInOffHand().getType() == material;
    return isOnMainHand || isOnOffHand;
  }

  public static ItemStack getAnItemFromPlayersHand(PlayerInventory inventory, Material material) {
    if(inventory.getItemInMainHand().getType() == material) {
      return inventory.getItemInMainHand();
    } else if(inventory.getItemInOffHand().getType() == material) {
      return inventory.getItemInOffHand();
    }
    return null;
  }

  /**
   * @deprecated use {@link #cast} instead
   * */
  public static Player castPlayer(Entity entity) {
    return entity instanceof Player ? (Player) entity : null;
  }

  /**
   * @deprecated use {@link #cast} instead
   * */
  public static LivingEntity castLivingEntity(Entity entity) {
    return entity instanceof LivingEntity ? (LivingEntity) entity : null;
  }
  /**
  * @deprecated use {@link #cast} instead
  * */
  public static Monster castMonster(Entity entity) {
    return entity instanceof Monster ? (Monster) entity : null;
  }

  public static <T, K> K cast(T toCast) {
    try{
      return (K) toCast;
    } catch(ClassCastException e) {
      return null;
    }
  }
}
