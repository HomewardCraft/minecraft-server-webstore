package com.arcanetravel.listener;

import com.arcanetravel.event.GUIItemSave;
import com.arcanetravel.shopconnectbridge;
import dev.triumphteam.gui.guis.StorageGui;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class PlayerLeaveListener implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {

        HashMap<String, StorageGui> playerDeliverGUI = shopconnectbridge.playerDeliverGUI;

        if (playerDeliverGUI.containsKey(String.valueOf(event.getPlayer().getUniqueId()))) {
            //
            System.out.println("是有gui");
            StorageGui storageGui = playerDeliverGUI.get(String.valueOf(event.getPlayer().getUniqueId()));
            Bukkit.getServer().getPluginManager().callEvent(new GUIItemSave(event.getPlayer(), storageGui));
        }




    }
}
