package com.arcanetravel.util;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.database.tables.PlayerCart;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class ConnectDataBase {

    public static String username;
    public static String password;
    public static String port;
    public static String database;
    public static String ip;

    public static String databaseUrl;

    public static ConnectionSource onConnected() {

        username = Util.getConfig("database.yml").getString("username");
        password = Util.getConfig("database.yml").getString("password");
        port = Util.getConfig("database.yml").getString("port");
        database = Util.getConfig("database.yml").getString("name");
        ip = Util.getConfig("database.yml").getString("ip");
        databaseUrl = ("jdbc:mysql://" + ip + ":" + port + "/" + database + "?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true");

        ConnectionSource connectionSource = null;

        try {

            connectionSource = new JdbcConnectionSource(databaseUrl, username, password);

            TableUtils.createTableIfNotExists(connectionSource, PlayerCart.class);
            TableUtils.createTableIfNotExists(connectionSource, CartItem.class);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connectionSource;
    }


}
