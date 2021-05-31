package me.hardermode.buff;

import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.LivingEntity;

public class Buff {

  public static double buffAttribute(AttributeInstance attribute, double buff) {
    double health = attribute.getBaseValue();
    double totalHealth = health + (health * buff);
    attribute.setBaseValue(totalHealth);
    return totalHealth;
  }

}
