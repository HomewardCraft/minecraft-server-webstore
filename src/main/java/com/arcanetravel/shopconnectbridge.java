package com.arcanetravel;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.guicluster.YourCluster;
import com.arcanetravel.util.*;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import dev.triumphteam.gui.guis.StorageGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;


public final class shopconnectbridge extends JavaPlugin {


    //全局GUI
    public static HashMap<String, StorageGui> playerDeliverGUI = new HashMap<>();

    //全局数据库连接
    public static ConnectionSource source = ConnectDataBase.onConnected();
    //Dao
    public static Dao<CartItem, String> cartItemDao = null;

    public static Logger logger = Bukkit.getLogger();


    public shopconnectbridge() {

    }


    @Override
    public void onEnable() {

        //注册默认Config,没有的话创建一个
        saveDefaultConfig();
        this.saveResource("database.yml", false);
        this.saveResource("message.yml", false);

        // Plugin startup logic
        System.out.println("初始化 ArcaneTravel DataBridge");


        //指令注册器加载指令
        new CommandRegister(this).RegisterCommand();
        //事件注册器注册事件
        new EventRegister(this).RegisterEvent();

        logger.info(ChatColor.translateAlternateColorCodes('&', "&7&l[&2+&7] &f加载成功"));

        //TODO 初始化网络商店database倒入Inventory类型仓库
        ConvertWebCart.onConvert();

        //注册Dao
        try {
            cartItemDao = DaoManager.createDao(source, CartItem.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {


        // Plugin shutdown logic
        logger.info(ChatColor.translateAlternateColorCodes('&', "&7&l[&c-&7] &f关闭成功"));

        //保存所有玩家的GUI
        CommonUtil.globalSave(playerDeliverGUI);


    }


}
