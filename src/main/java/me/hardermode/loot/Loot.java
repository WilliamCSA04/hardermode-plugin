package me.hardermode.loot;

import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;

import java.util.List;
import java.util.Random;

public class Loot {

  public static void addItemStackIntoChest(ItemStack item, LootTable lootTable, LootTables lootTablesEnum, List<ItemStack> originalLoot, double chanceToBePresent) {
    if(lootTable.getKey().equals(lootTablesEnum.getKey())) {
      boolean isPresent = Math.random() <= chanceToBePresent;
      if(isPresent) {
        originalLoot.add(item);
      }
    }
  }

  public static void addMultipleItemStacksIntoChest(List<ItemStack> items, LootTable lootTable, LootTables lootTablesEnum, List<ItemStack> originalLoot, double chanceToBePresent) {
    if(lootTable.getKey().equals(lootTablesEnum.getKey())) {
      boolean isPresent = Math.random() <= chanceToBePresent;
      if(isPresent) {
        originalLoot.addAll(items);
      }
    }
  }

}
