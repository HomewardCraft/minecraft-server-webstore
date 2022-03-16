package com.arcanetravel.command;

import com.arcanetravel.shopconnectbridge;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.StorageGui;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpenDelivery implements CommandExecutor {

    public shopconnectbridge plugin;

    public OpenDelivery(shopconnectbridge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        StorageGui gui = plugin.gui;
        Player player = (Player) sender;
        gui.open(player);
        player.sendMessage(gui.getInventory().getItem(9).displayName());
        return true;
    }
}
