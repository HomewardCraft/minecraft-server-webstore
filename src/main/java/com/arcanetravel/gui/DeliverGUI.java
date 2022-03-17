package com.arcanetravel.gui;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.StorageGui;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

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

        gui.setOpenGuiAction(event -> {
            // Handle your open action
            //TODO 查找CartItem是否有这位玩家的内容

            //TODO 如果没有展示空的GUI

            //TODO 如果有则判断当前还有多少空余的格子

            //TODO 查询空余格子数量的数据库 将物品导入GUI 同时清空数据库的内容

            //TODO TYPE 1 关闭GUI不进行任何操作 指定区间进行数据保存

            //TODO TYPE 2 关闭GUI进行数据保存 GUI内未拿取的物品存入数据库

        });


        return gui;
    }


}
