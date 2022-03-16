package com.arcanetravel.util;

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
    public StorageGui gui;
    public shopconnectbridge plugin;

    public GUIRegister(shopconnectbridge plugin) {
        this.plugin = plugin;
        onInit();
    }

    public void onInit() {
        GuiItem boarder = ItemBuilder.from(Material.GRAY_STAINED_GLASS_PANE).asGuiItem(event -> {
            event.setCancelled(true);
        });
        this.gui = Gui.storage()
                .title(Component.text("你的订单仓库"))
                .rows(5)
                .create();
        Integer[] index = {0, 1, 2, 3, 4, 5, 6, 7, 8, 44, 43, 42, 41, 40, 39, 38, 37, 36};
        List boarderIndex = Arrays.asList(index);
        gui.setItem(boarderIndex, boarder);

    }
}
