package com.arcanetravel.util;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class ConnectDataBase {

    public static String databaseUrl = "jdbc:mysql://ba1oretto.com:3306/minecraft_webstore?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true";
    public static String username = "remote";
    public static String password = "sd;lawmd;ls1=1]ro90-2Sjm20050406";

    public static ConnectionSource onConnected() {

        ConnectionSource connectionSource =
                null;
        try {
            connectionSource = new JdbcConnectionSource(databaseUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connectionSource;
    }


}
