package me.hardermode.helpers;

import me.hardermode.buff.Buff;
import org.bukkit.Material;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import javax.management.Attribute;
import java.util.Random;

public class Helpers {

  public static int randomIntMinMax(int min, int max) {
    Random r = new Random();
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

  public static double changeGenericAttributes(AttributeInstance attribute, double toBuff) {
    if(attribute != null) {
      return Buff.buffAttribute(attribute, toBuff);
    }
    return 0;
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

  public static <T, K> K cast(T toCast, Class<K> klass) {
    try{
      return klass.cast(toCast);
    } catch(ClassCastException e) {
      return null;
    }
  }
}
