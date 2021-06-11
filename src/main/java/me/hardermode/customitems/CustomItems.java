package me.hardermode.customitems;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class CustomItems extends ItemStack {


  protected CustomItems(Material material, String name, List<String> lore) {
    super(material);
    ItemMeta meta = this.getItemMeta();
    meta.setDisplayName(name);
    meta.setLore(lore);
    this.setItemMeta(meta);
  }

}
