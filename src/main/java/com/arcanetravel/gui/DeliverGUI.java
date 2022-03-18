package com.arcanetravel.gui;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.shopconnectbridge;
import com.j256.ormlite.stmt.Where;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.StorageGui;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeliverGUI {

    public static StorageGui getGui() {

        StorageGui gui;

        GuiItem boarder = ItemBuilder.from(Material.GRAY_STAINED_GLASS_PANE).asGuiItem(event -> {
            event.setCancelled(true);
        });
        gui = Gui.storage()
                .title(Component.text("Your Purchasing"))
                .rows(3)
                .create();
        Integer[] index = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 16, 17, 18, 19, 25, 26};
        List boarderIndex = Arrays.asList(index);
        gui.setItem(boarderIndex, boarder);
//        gui.getFiller().fillBorder(boarder);
        gui.setOpenGuiAction(event -> {


        });


        return gui;
    }


}
