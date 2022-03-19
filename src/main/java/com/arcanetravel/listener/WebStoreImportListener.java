package com.arcanetravel.listener;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.event.WebStoreImport;
import com.arcanetravel.shopconnectbridge;
import com.arcanetravel.util.Stream;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebStoreImportListener implements Listener {


    @EventHandler
    public void onWebStoreImport(WebStoreImport event) throws SQLException, InterruptedException, IOException, ClassNotFoundException {
        event.getPlayer().sendMessage("激活自定义事件");
        String uniqueId = String.valueOf(event.getPlayer().getUniqueId()).replace("-", "");

        List<CartItem> items = new ArrayList<>();


        //TODO 查找CartItem是否有这位玩家的内容
        try {
            items = shopconnectbridge.cartItemDao.queryBuilder().where().eq("uuid", uniqueId).query();

        } catch (SQLException e) {
            //如果有任何问题直接中断操作
            event.setCancelled(true);
            e.printStackTrace();
        }

        if (items.size() == 0) {
            event.getPlayer().sendMessage("当前购买车为空");
            event.getPlayer().sendMessage(uniqueId);

            //TODO 如果没有展示空的GUI
        } else {
            //TODO 如果有则判断当前还有多少空余的格子
            //11 12 13 14 15 20 21 22 23 24
            Integer[] cache = {11, 12, 13, 14, 15, 20, 21, 22, 23, 24};
            List<Integer> avaliableIndex = Arrays.asList(cache);
            int pointer = 0;
            //按照当前玩家uuid把她购买的东西放入GUI
            for (Integer number : avaliableIndex) {
                if (event.getGui().getGuiItem(number) == null && pointer <= items.size() - 1) {
                    event.getGui().addItem((ItemStack) Stream.writeDecodedObject(items.get(pointer).getItem_stack()));


                    try {

                        shopconnectbridge.cartItemDao.delete(items.get(pointer));

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    pointer++;


                }
            }
        }
        //TODO TYPE 1 关闭GUI不进行任何操作 指定区间进行数据保存

        //TODO TYPE 2 关闭GUI进行数据保存 GUI内未拿取的物品存入数据库

    }

}
