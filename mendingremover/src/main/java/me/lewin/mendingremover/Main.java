package me.lewin.mendingremover;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Stating mending remover...");
        getServer().getPluginManager().registerEvents(new RemoveMerchantEnchentment(), this);
        getServer().getPluginManager().registerEvents(new RemoveFishingMending(), this);
        getServer().getPluginManager().registerEvents(new RemoveMending(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Stopping mending remover...");
    }
}
