package com.arcanetravel.listener;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.event.GUIItemSave;
import com.arcanetravel.shopconnectbridge;
import com.arcanetravel.util.Stream;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Arrays;
import java.util.List;

/**
 * 处理当GUI关闭时的物品入库操作或者是全局定时操作
 */
public class GUIItemSaveListener implements Listener {

    @EventHandler
    public void onGUIItemSave(GUIItemSave event) {


        //遍历指定物品栏储存到数据库

        //11 12 13 14 15 20 21 22 23 24
        Integer[] cache = {11, 12, 13, 14, 15, 20, 21, 22, 23, 24};
        List<Integer> avaliableIndex = Arrays.asList(cache);
        String uuid = String.valueOf(event.getPlayer().getUniqueId()).replace("-", "");

        for (Integer number : avaliableIndex) {
            if (event.getGui().getInventory().getItem(number) != null) {
                //
                CartItem cacheItem = new CartItem(uuid, Stream.writeEncodedObject(event.getGui().getInventory().getItem(number)), number, 0);

                try {
                    shopconnectbridge.cartItemDao.create(cacheItem);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        }


        try {
            event.getPlayer().sendMessage(event.getGui().getInventory().getItem(11).displayName());
        } catch (Exception exception) {
            event.getPlayer().sendMessage("当前槽位是空的");
        }
    }

}
