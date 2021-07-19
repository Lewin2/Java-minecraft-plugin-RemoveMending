package me.lewin.mendingremover;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;

public class RemoveMerchantEnchentment implements Listener {
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if(event.getView().getType() != InventoryType.MERCHANT) {return;}
        Merchant merchant = ((MerchantInventory) event.getInventory()).getMerchant();
        List<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>(merchant.getRecipes());
        recipes.removeIf(recipe -> recipe.getResult().getItemMeta().hasEnchants());
        recipes.removeIf(recipe -> recipe.getResult().getType() == Material.ENCHANTED_BOOK);
        merchant.setRecipes(recipes);
        if(recipes.size() < 1) {
            event.setCancelled(true);
        }
    }
}
