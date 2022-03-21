package com.arcanetravel.util;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.database.tables.PlayerCart;
import com.arcanetravel.shopconnectbridge;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLException;
import java.util.List;

import static com.arcanetravel.util.Util.*;

public class ConvertWebCart {

    //导入全局连接
    public static ConnectionSource source = shopconnectbridge.source;

    private static Dao<PlayerCart, String> playerCartDao = null;
    private static Dao<CartItem, String> cartItemDao = null;

    //插件初始化的时候就吧网络的cart转换为玩家物品的cart
    public static void onConvert() {

        Dao<PlayerCart, String> playerCartDao = null;
        Dao<CartItem, String> cartItemDao = null;

        try {
            Util.showLog(INFO, "转化数据库至物品类型");
            playerCartDao = DaoManager.createDao(source, PlayerCart.class);
            cartItemDao = DaoManager.createDao(source, CartItem.class);

            List<PlayerCart> carts = playerCartDao.queryForAll();
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

            Util.showLog(LOAD, "转化数据库成功");
            onRemove();
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO 转换失败备份初始数据 并且回滚事物
            Util.showLog(ERROR, "转化数据库失败 准备回滚");
        }


    }

    /**
     * 清空webstore的数据库，这个方法在执行完onConvert才可以执行
     */
    public static void onRemove() {

        try {

            playerCartDao = DaoManager.createDao(source, PlayerCart.class);
            cartItemDao = DaoManager.createDao(source, CartItem.class);

            //清空数据库
            playerCartDao.deleteBuilder().delete();
            Util.showLog(INFO, "主表清空完毕");

        } catch (Exception exception) {
            exception.printStackTrace();
            Util.showLog(ERROR, "主表清空失败 请手动删除");
        }


    }


}
