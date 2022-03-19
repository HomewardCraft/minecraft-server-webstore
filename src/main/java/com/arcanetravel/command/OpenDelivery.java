package com.arcanetravel.command;

import com.arcanetravel.event.WebStoreImport;
import com.arcanetravel.gui.DeliverGUI;
import com.arcanetravel.shopconnectbridge;
import dev.triumphteam.gui.guis.StorageGui;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;


public class OpenDelivery implements CommandExecutor {

    public shopconnectbridge plugin;

    public OpenDelivery(shopconnectbridge plugin) {
        this.plugin = plugin;
    }

    public static HashMap<String, StorageGui> guis = shopconnectbridge.playerDeliverGUI;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


        StorageGui gui = DeliverGUI.getGui();
        Player player = (Player) sender;


        if (guis.containsKey(String.valueOf(player.getUniqueId()))) { //如果全局GUI有该玩家gui
            //让该玩家gui导入已购商品
            Bukkit.getServer().getPluginManager().callEvent(new WebStoreImport(player, guis.get(String.valueOf(player.getUniqueId()))));

            //展示该GUI给玩家
            guis.get(String.valueOf(player.getUniqueId())).open(player);
        } else {
            guis.put(String.valueOf(player.getUniqueId()), gui);
            guis.get(String.valueOf(player.getUniqueId())).open(player);
        }

        return true;
    }
}
