package com.arcanetravel.util;

import com.arcanetravel.event.WebStoreImport;
import com.arcanetravel.shopconnectbridge;
import dev.triumphteam.gui.guis.StorageGui;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GUIManipulation {

    public shopconnectbridge plugin;

    public static boolean openGUI(StorageGui gui, Player player, HashMap<String, StorageGui> guis) {


        if (guis.containsKey(String.valueOf(player.getUniqueId()))) {
            guis.get(String.valueOf(player.getUniqueId())).open(player);
        } else {
            guis.put(String.valueOf(player.getUniqueId()), gui);
            guis.get(String.valueOf(player.getUniqueId())).open(player);
        }

        Bukkit.getServer().getPluginManager().callEvent(new WebStoreImport(player, guis.get(String.valueOf(player.getUniqueId()))));


        return true;
    }

    public static boolean isGUIEmpty(StorageGui gui) {
        Integer[] cache = {11, 12, 13, 14, 15, 20, 21, 22, 23, 24};
        List<Integer> avaliableIndex = Arrays.asList(cache);
        boolean state = true;

        for (Integer number : avaliableIndex) {
            if (gui.getInventory().getItem(number) != null)
                state = false;
        }

        return state;

    }

}
