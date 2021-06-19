package me.lewin.mendingremover;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class RemoveMending implements Listener {
    @EventHandler
    public void click(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (p.hasPermission("removemendingop")){
            return;
        }
        for (ItemStack item : p.getInventory().getContents()){
            if (item == null){continue;}
            if (item.containsEnchantment(Enchantment.MENDING)) {
                if (item.getType() == Material.ELYTRA) {continue;}
                if (item.getType() == Material.TRIDENT) {continue;}
                item.removeEnchantment(Enchantment.MENDING);
                continue;
            }
            if (item.getType() == Material.ENCHANTED_BOOK){
                EnchantmentStorageMeta enchmeta = (EnchantmentStorageMeta) item.getItemMeta();
                if (enchmeta.hasStoredEnchant(Enchantment.MENDING)) {
                    enchmeta.removeStoredEnchant(Enchantment.MENDING);
                    item.setItemMeta(enchmeta);
                }
                if (!enchmeta.hasStoredEnchants()){
                    item.setType(Material.BOOK);
                }
            }
        }
    }
}