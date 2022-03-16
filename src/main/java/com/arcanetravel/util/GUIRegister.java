package com.arcanetravel.util;

import com.arcanetravel.gui.DeliverGUI;
import com.arcanetravel.shopconnectbridge;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.StorageGui;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class GUIRegister {
    public StorageGui guiDeliver;
    public shopconnectbridge plugin;

    public GUIRegister(shopconnectbridge plugin) {
        this.plugin = plugin;
        onInit();
    }

    public void onInit() {
        guiDeliver = DeliverGUI.getGui();
    }
}
