package com.arcanetravel.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "inventory_cache")
public class InventoryCache {

    @DatabaseField(columnName = "uuid")
    private String uuid;
    @DatabaseField(columnName = "item_stack")
    private String item_stack;
    @DatabaseField(columnName = "item_id")
    private int itemId;
    @DatabaseField(columnName = "amount")
    private int amount;

}
