package com.arcanetravel.util;


import com.arcanetravel.listener.GUIItemSaveListener;
import com.arcanetravel.listener.WebStoreImportListener;
import com.arcanetravel.shopconnectbridge;

import static com.arcanetravel.util.CommonUtil.LOAD;
import static com.arcanetravel.util.CommonUtil.WARN;


//事件注册器，用来集中注册事件
public class EventRegister extends CommandRegister {

    public shopconnectbridge plugin;

    public EventRegister(shopconnectbridge plugin) {
        this.plugin = plugin;
    }

    public void RegisterEvent() {
        CommonUtil.showLog(WARN, "&f事件模块开始注册");
        plugin.getServer().getPluginManager().registerEvents(new WebStoreImportListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GUIItemSaveListener(), plugin);
        CommonUtil.showLog(LOAD, "&f事件模块注册完毕");

    }

}
