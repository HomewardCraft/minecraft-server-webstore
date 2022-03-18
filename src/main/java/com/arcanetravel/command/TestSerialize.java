package com.arcanetravel.command;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.shopconnectbridge;
import com.arcanetravel.util.Stream;
import com.j256.ormlite.support.ConnectionSource;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestSerialize implements CommandExecutor {

    private static ConnectionSource source = shopconnectbridge.source;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;

        String uniqueId = String.valueOf(player.getUniqueId()).replace("-", "");
        List<CartItem> items = new ArrayList<>();
        try {
            items = shopconnectbridge.cartItemDao.queryBuilder().where().eq("uuid", uniqueId).query();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (CartItem item : items) {
            try {
                ItemStack cache = (ItemStack) Stream.writeDecodedObject(item.getItem_stack());
                player.sendMessage(String.valueOf(cache.getType()));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        return true;
    }
}
