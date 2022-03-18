package com.arcanetravel.listener;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.database.tables.PlayerCart;
import com.arcanetravel.event.WebStoreImport;
import com.arcanetravel.shopconnectbridge;
import com.arcanetravel.util.Stream;
import com.arcanetravel.util.TypeItemConvert;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class WebStoreImportListener implements Listener {

    private static ConnectionSource source = shopconnectbridge.source;


    @EventHandler
    public void onWebStoreImport(WebStoreImport event) throws SQLException, InterruptedException, IOException, ClassNotFoundException {
        event.getPlayer().sendMessage("激活自定义事件");
        String uniqueId = String.valueOf(event.getPlayer().getUniqueId()).replace("-", "");

        List<CartItem> items = new ArrayList<>();


        //TODO 查找CartItem是否有这位玩家的内容
        try {
            items = shopconnectbridge.cartItemDao.queryBuilder().where().eq("uuid", uniqueId).query();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (items.size() == 0) {
            event.getPlayer().sendMessage("当前购买车为空");
            event.getPlayer().sendMessage(uniqueId);

            //TODO 如果没有展示空的GUI
        } else {
            //TODO 如果有则判断当前还有多少空余的格子
            event.getPlayer().sendMessage(items.toString());
            //11 12 13 14 15 20 21 22 23 24
            Integer[] cache = {11, 12, 13, 14, 15, 20, 21, 22, 23, 24};
            List<Integer> avaliableIndex = Arrays.asList(cache);
            int pointer = 0;


            CartItem items1 = items.get(0);
            CartItem items2 = items.get(1);

            ItemStack diamond = new ItemStack(Material.TNT);
            String diamondcode = Stream.writeEncodedObject(diamond);
            System.out.println(diamondcode);
            ItemStack decodediamond = (ItemStack) Stream.writeDecodedObject(diamondcode);
            System.out.println(decodediamond.getType());

            event.getGui().addItem((ItemStack) Stream.writeDecodedObject(items1.getItem_stack()));
//            event.getGui().addItem(writeDecodedObject(itemcode));
            event.getGui().addItem((ItemStack) Stream.writeDecodedObject(items2.getItem_stack()));
//            event.getGui().addItem(writeDecodedObject(itemcode));


//            event.getGui().addItem((ItemStack) Stream.writeDecodedObject(items.get(2).getItem_stack()));
//            event.getGui().addItem((ItemStack) Stream.writeDecodedObject(items.get(1).getItem_stack()));
//            event.getGui().addItem((ItemStack) Stream.writeDecodedObject(items.get(0).getItem_stack()));

//            for (Integer number : avaliableIndex) {
//                if (event.getGui().getGuiItem(number) == null && pointer <= items.size() - 1) {
//                    event.getGui().addItem((ItemStack) Stream.writeDecodedObject(items[0].getItem_stack()));
//                    pointer++;
//                }
//            }


        }


        //TODO 查询空余格子数量的数据库 将物品导入GUI 同时清空数据库的内容

        //TODO TYPE 1 关闭GUI不进行任何操作 指定区间进行数据保存

        //TODO TYPE 2 关闭GUI进行数据保存 GUI内未拿取的物品存入数据库

    }

}
