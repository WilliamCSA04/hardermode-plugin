package me.hardermode.helpers;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Helpers {

    public static boolean isAnItemOnPlayersHandFromMaterial(PlayerInventory inventory, Material material) {
        boolean isOnMainHand = inventory.getItemInMainHand().getType() == material;
        boolean isOnOffHand = inventory.getItemInOffHand().getType() == material;
        return isOnMainHand || isOnOffHand;
    }

    public static ItemStack getAnItemFromPlayersHandFromMaterial(PlayerInventory inventory, Material material) {
        if(inventory.getItemInMainHand().getType() == material) {
            return inventory.getItemInMainHand();
        } else if(inventory.getItemInOffHand().getType() == material) {
            return inventory.getItemInOffHand();
        }
        return null;
    }

}
