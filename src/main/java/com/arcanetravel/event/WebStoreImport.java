package com.arcanetravel.event;

import dev.triumphteam.gui.guis.StorageGui;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WebStoreImport extends Event implements Cancellable {

    private Player player;
    private StorageGui gui;
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelledFlag = false;

    public WebStoreImport(Player player, StorageGui gui) {
        this.player = player;
        this.gui = gui;
    }

    public StorageGui getGui() {
        return gui;
    }

    public void setGui(StorageGui gui) {
        this.gui = gui;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelledFlag;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelledFlag = cancel;
    }
}
