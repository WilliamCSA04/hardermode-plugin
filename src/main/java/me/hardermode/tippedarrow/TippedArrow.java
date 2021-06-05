package me.hardermode.tippedarrow;

import me.hardermode.helpers.Helpers;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.Random;

public class TippedArrow {

  public static ItemStack tippedArrowBuilder(PotionEffectType potionEffectType, PotionType potionType, int ticks, int amplifier) {
    ItemStack tippedArrow = new ItemStack(Material.TIPPED_ARROW);
    ItemMeta tippedArrowMeta = tippedArrow.getItemMeta();
    if(tippedArrowMeta != null) {
      PotionMeta potionMeta = Helpers.cast(tippedArrowMeta, PotionMeta.class);
      if(potionMeta != null) {
        PotionEffect poison = new PotionEffect(potionEffectType, ticks, amplifier);
        potionMeta.addCustomEffect(poison, true);
        potionMeta.setBasePotionData(new PotionData(potionType));
        tippedArrow.setItemMeta(potionMeta);
      }
    }
    return tippedArrow;
  }

}
