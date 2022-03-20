package com.arcanetravel;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.guicluster.YourCluster;
import com.arcanetravel.util.*;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import dev.triumphteam.gui.guis.StorageGui;
import me.wolfyscript.utilities.api.WolfyUtilCore;
import me.wolfyscript.utilities.api.WolfyUtilities;
import me.wolfyscript.utilities.api.inventory.gui.InventoryAPI;
import me.wolfyscript.utilities.api.inventory.gui.cache.CustomCache;
import me.wolfyscript.utilities.api.language.Language;
import me.wolfyscript.utilities.api.language.LanguageAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;


public final class shopconnectbridge extends JavaPlugin {

    private final WolfyUtilities wolfyUtilsApi;

    //全局GUI
    public static HashMap<String, StorageGui> playerDeliverGUI = new HashMap<>();

    //全局数据库连接
    public static ConnectionSource source = ConnectDataBase.onConnected();
    //Dao
    public static Dao<CartItem, String> cartItemDao = null;

    public static Logger logger = Bukkit.getLogger();
    public InventoryAPI<CustomCache> invAPI;

    public shopconnectbridge() {
        //注册wolfyApi
        wolfyUtilsApi = WolfyUtilCore.getInstance().getAPI(this, false);
        //获取InvApi-
        invAPI = wolfyUtilsApi.getInventoryAPI(CustomCache.class);
    }


    @Override
    public void onEnable() {

        //注册默认Config,没有的话创建一个
        saveDefaultConfig();
        // Plugin startup logic
        System.out.println("初始化 ArcaneTravel DataBridge");

        try {

            wolfyUtilsApi.initialize();
            loadLang();
            invAPI.registerCluster(new YourCluster(invAPI));
            logger.info(ChatColor.translateAlternateColorCodes('&', "&7&l[&2+&7] &7&l[&61&7/&71&7] &f前置加载成功：&6WolfyUtilities"));

        } catch (Exception exception) {

            exception.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);

        }

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

    public void loadLang() {

        //Save the language file resource to the plugin folder.
        saveResource("lang/en_US.json", true);
        //Get the LanguageAPI of the api
        LanguageAPI languageAPI = this.wolfyUtilsApi.getLanguageAPI();
        //Create the language
        Language fallBackLanguage = new Language(this, "en_US");
        //Register the language. The first registered language will be automatically be used as the fallback and active language.
        languageAPI.registerLanguage(fallBackLanguage);

    }

}
