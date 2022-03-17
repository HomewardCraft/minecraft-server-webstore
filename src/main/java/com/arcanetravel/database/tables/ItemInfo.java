package com.arcanetravel.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "item_info")
public class ItemInfo {

    @DatabaseField(generatedId = true, unique = true)
    private int id;
    @DatabaseField(columnName = "command")
    private String command;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
