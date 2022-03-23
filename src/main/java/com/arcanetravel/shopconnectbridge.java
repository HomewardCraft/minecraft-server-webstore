package com.arcanetravel;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.database.tables.PlayerCart;
import com.arcanetravel.util.*;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import dev.triumphteam.gui.guis.StorageGui;
import me.mattstudios.mf.base.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;


public final class shopconnectbridge extends JavaPlugin {


    //全局GUI
    public static HashMap<String, StorageGui> playerDeliverGUI = new HashMap<>();

    //全局数据库连接
    public static ConnectionSource source;
    //Dao
    public static Dao<CartItem, String> cartItemDao = null;
    public static Dao<PlayerCart, String> playerCartDao = null;

    public static Logger logger = Bukkit.getLogger();

    public static FileConfiguration config;

    //全局plugin
    public static shopconnectbridge plugin;

    public static CommandManager commandManager;

    //构造器
    public shopconnectbridge() {
        plugin = this;
    }


    @Override
    public void onEnable() {

        //注册默认Config,没有的话创建一个
        saveDefaultConfig();
        config = getConfig();

        this.saveResource("database.yml", false);
        this.saveResource("message.yml", false);

        // Plugin startup logic
        Util.showLog("初始化 ArcaneTravel DataBridge");

        //事件注册器注册事件
        new EventRegister(this).RegisterEvent();
        //指令注册器 API
        commandManager = new CommandManager(this);
        //指令注册器加载指令
        new CommandRegister(this).RegisterCommand();


        logger.info(ChatColor.translateAlternateColorCodes('&', "&7&l[&2+&7] &f加载成功"));

        source = ConnectDataBase.onConnected();
        //初始化网络商店database倒入Inventory类型仓库
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
        Util.globalSave(playerDeliverGUI);

        //关闭连接源
        try {
            source.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
