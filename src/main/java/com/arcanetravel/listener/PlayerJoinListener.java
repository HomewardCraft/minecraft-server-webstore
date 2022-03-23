package com.arcanetravel.listener;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.database.tables.PlayerCart;
import com.arcanetravel.shopconnectbridge;
import com.arcanetravel.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {

        String uniqueId = String.valueOf(event.getPlayer().getUniqueId()).replace("-", "");

        List<CartItem> items = new ArrayList<>();
        List<PlayerCart> carts = new ArrayList<>();

        try {
            items = shopconnectbridge.cartItemDao.queryBuilder().where().eq("uuid", uniqueId).query();
            carts = shopconnectbridge.playerCartDao.queryBuilder().where().eq("uuid", uniqueId).query();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        //如果cart里有物品或者playerCart有则依照配置文件选择开启或者关闭
        if (carts.size() > 0 || items.size() > 0) {

            if (Util.getConfig().getBoolean("general-settings.auto-open-gui")) {
                Bukkit.dispatchCommand(event.getPlayer(), "purchase");
            }


        }

    }

}
