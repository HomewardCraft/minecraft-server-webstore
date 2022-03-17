package com.arcanetravel.listener;

import com.arcanetravel.database.tables.PlayerCart;
import com.arcanetravel.event.WebStoreImport;
import com.arcanetravel.shopconnectbridge;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class WebStoreImportListener implements Listener {

    private static ConnectionSource source = shopconnectbridge.source;



    @EventHandler
    public void onWebStoreImport(WebStoreImport event) throws SQLException {
        event.getPlayer().sendMessage("激活自定义事件");
        UUID uniqueId = event.getPlayer().getUniqueId();

        Dao<PlayerCart, Integer> getCommand = DaoManager.createDao(source, PlayerCart.class);

        List<PlayerCart> carts = getCommand.queryBuilder().where().eq("uuid", 1234567890).query();
        for (PlayerCart cart : carts) {
            System.out.println(cart.getCommand());
        }

    }

}
