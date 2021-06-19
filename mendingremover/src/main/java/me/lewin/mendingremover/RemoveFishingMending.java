package me.lewin.mendingremover;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class RemoveFishingMending implements Listener {
    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        if(event.getCaught() instanceof Item) {
            ItemStack fished = ((Item) event.getCaught()).getItemStack();
            if(fished.getType() == Material.ENCHANTED_BOOK) {
                EnchantmentStorageMeta enchmeta = (EnchantmentStorageMeta) fished.getItemMeta();
                if(enchmeta.hasStoredEnchant(Enchantment.MENDING)) {
                    System.out.println("mending"); // test
                    enchmeta.removeStoredEnchant(Enchantment.MENDING);
                    fished.setItemMeta(enchmeta);
                    if (!enchmeta.hasStoredEnchants()){
                        fished.setType(Material.BOOK);
                    }
                }
            }
            if (fished.containsEnchantment(Enchantment.MENDING)) {
                fished.removeEnchantment(Enchantment.MENDING);
            }
        }
    }
}
