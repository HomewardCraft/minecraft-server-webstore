package com.arcanetravel.util;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.database.tables.PlayerCart;
import com.arcanetravel.shopconnectbridge;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

public class ConvertWebCart {

    //导入全局连接
    public static ConnectionSource source = shopconnectbridge.source;

    //插件初始化的时候就吧网络的cart转换为玩家物品的cart
    public static void onConvert() {

        Dao<PlayerCart, String> getCommand = null;
        Dao<CartItem, String> cartItemDao = null;

        try {
            getCommand = DaoManager.createDao(source, PlayerCart.class);
            cartItemDao = DaoManager.createDao(source, CartItem.class);

            List<PlayerCart> carts = getCommand.queryForAll();
            for (PlayerCart cart : carts) {

                //把webcart的物品读出来转换成mc物品
                ItemStack convert = TypeItemConvert.convert(cart.getCommand());
                //创建cartitem未接下来的入库做准备
                CartItem ct = new CartItem();
                ct.setItem_stack(Stream.writeEncodedObject(convert));
                ct.setUuid(cart.getUuid());
                ct.setItemId(cart.getItemId());

                cartItemDao.create(ct);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
