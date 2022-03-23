package com.arcanetravel.command;

import com.arcanetravel.gui.DeliverGUI;
import com.arcanetravel.shopconnectbridge;
import com.arcanetravel.util.GUIManipulation;
import dev.triumphteam.gui.guis.StorageGui;
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

        GUIManipulation.openGUI(gui, player, guis);

        return true;
    }


}
