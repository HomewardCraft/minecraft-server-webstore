package com.arcanetravel.command;

import com.arcanetravel.shopconnectbridge;
import me.mattstudios.mf.annotations.Command;
import me.mattstudios.mf.annotations.Default;
import me.mattstudios.mf.annotations.SubCommand;
import me.mattstudios.mf.base.CommandBase;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@Command("webstore")
public class Main extends CommandBase {
    shopconnectbridge plugin = shopconnectbridge.plugin;

    @Default
    public void defaultCommand(final CommandSender commandSender) {
        commandSender.sendMessage("Current version checked!");
    }


    @SubCommand("reload")
    public void testSubCommand(final CommandSender commandSender) {
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7webstore reload success!"));
        plugin.reloadConfig();
        plugin.saveConfig();
    }


}
