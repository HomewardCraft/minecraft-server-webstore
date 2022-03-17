package com.arcanetravel.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "player_cart")
public class PlayerCart {
    @DatabaseField(columnName = "uuid")
    private int uuid;
    @DatabaseField(columnName = "command")
    private String command;
    @DatabaseField(columnName = "item_id")
    private int itemId;
    @DatabaseField(columnName = "amount")
    private int amount;

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
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
