package me.hardermode.helpers;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Helpers {

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

    public static Player castPlayer(Entity entity) {
        return entity instanceof  Player ? (Player) entity : null;
    }

    public static LivingEntity castLivingEntity(Entity entity) {
        return entity instanceof  LivingEntity ? (LivingEntity) entity : null;
    }

}
