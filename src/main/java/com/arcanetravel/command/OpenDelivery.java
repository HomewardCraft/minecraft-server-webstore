package com.arcanetravel.command;

import com.arcanetravel.shopconnectbridge;
import dev.triumphteam.gui.guis.StorageGui;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class OpenDelivery implements CommandExecutor {

    public shopconnectbridge plugin;

    public OpenDelivery(shopconnectbridge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        StorageGui gui = plugin.guiDeliver;
        Player player = (Player) sender;
        gui.open(player);
        Bukkit.dispatchCommand(sender, "give Caizii apple 10");
        try {
            player.sendMessage(gui.getInventory().getItem(9).displayName());
        } catch (Exception exception) {
            player.sendMessage("当前槽位是空的");
        }



        return true;
    }
}
