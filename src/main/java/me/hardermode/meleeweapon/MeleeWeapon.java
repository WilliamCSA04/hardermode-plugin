package me.hardermode.meleeweapon;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class MeleeWeapon {

  public static List<Material> meleeWeaponMaterials() {
    List<Material> weapons = new ArrayList<>();
    weapons.add(Material.STONE_SWORD);
    weapons.add(Material.WOODEN_SWORD);
    weapons.add(Material.IRON_SWORD);
    weapons.add(Material.DIAMOND_SWORD);
    weapons.add(Material.NETHERITE_SWORD);
    weapons.add(Material.STONE_AXE);
    weapons.add(Material.WOODEN_AXE);
    weapons.add(Material.IRON_AXE);
    weapons.add(Material.DIAMOND_AXE);
    weapons.add(Material.NETHERITE_AXE);
    return weapons;
  }

}
