package com.arcanetravel.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Objects;

public class TypeItemConvert {

    public static ItemStack convert(String item) {

        String type = "";
        int amount = 0;
        String name = "";
        ItemStack cached = new ItemStack(Material.AIR);


        String[] items = item.split("\\s+");
        type = items[0];
        name = items[1];
        amount = Integer.parseInt(items[2]);

        if (type.equalsIgnoreCase("minecraft")) {
            cached = new ItemStack(Material.valueOf(name.toUpperCase()), amount);

        }

        return cached;
    }

}
