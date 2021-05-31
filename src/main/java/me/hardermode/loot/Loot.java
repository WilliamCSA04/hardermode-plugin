package me.hardermode.loot;

import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;

import java.util.List;
import java.util.Random;

public class Loot {

  public static boolean isSameLootTableOn(LootTable lootTable, LootTables lootTables) {
    return lootTable.getKey().equals(lootTables.getKey());
  }

  public static void addItemStackIntoChest(ItemStack item, List<ItemStack> originalLoot, double chanceToBePresent) {
    if(item.getAmount() > 0) {
      boolean isPresent = Math.random() <= chanceToBePresent;
      if(isPresent) {
        originalLoot.add(item);
      }
    }
  }

  public static void addMultipleItemStacksIntoChest(List<ItemStack> items, List<ItemStack> originalLoot, double chanceToBePresent) {
    boolean isPresent = Math.random() <= chanceToBePresent;
    if(isPresent) {
      originalLoot.addAll(items);
    }
  }

}
