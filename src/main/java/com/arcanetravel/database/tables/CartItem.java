package com.arcanetravel.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "cart_item")
public class CartItem {

    @DatabaseField(columnName = "uuid")
    private String uuid;
    @DatabaseField(columnName = "item_stack")
    private String item_stack;
    @DatabaseField(columnName = "item_id")
    private int itemId;
    @DatabaseField(columnName = "amount")
    private int amount;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getItem_stack() {
        return item_stack;
    }

    public void setItem_stack(String item_stack) {
        this.item_stack = item_stack;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
