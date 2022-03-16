package com.arcanetravel.util;

import com.arcanetravel.gui.DeliverGUI;
import com.arcanetravel.shopconnectbridge;
import dev.triumphteam.gui.guis.StorageGui;

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
