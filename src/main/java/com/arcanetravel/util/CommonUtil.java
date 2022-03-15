package com.arcanetravel.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class CommonUtil {

    public static final String LOAD = "&7&l[&2+&7]";
    public static final String WARN = "&7&l[&6!&7]";
    public static final String INFO = "&7&l[&2I&7]";
    public static final String ERROR = "&7&l[&cx&7]";

    public static java.util.logging.@NotNull Logger logger = Bukkit.getLogger();


    public static void showLog(String state, String log) {

        CommonUtil.logger.info(ChatColor.translateAlternateColorCodes('&', state + " " + log));

    }
}
