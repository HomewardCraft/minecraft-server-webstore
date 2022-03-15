package com.arcanetravel.guicluster;

import com.arcanetravel.window.YourWindow;
import me.wolfyscript.utilities.api.inventory.gui.GuiCluster;
import me.wolfyscript.utilities.api.inventory.gui.InventoryAPI;
import me.wolfyscript.utilities.api.inventory.gui.button.buttons.DummyButton;
import me.wolfyscript.utilities.api.inventory.gui.cache.CustomCache;
import me.wolfyscript.utilities.util.NamespacedKey;
import org.bukkit.Material;

public class YourCluster extends GuiCluster<CustomCache> {

    //Use a constant for your Cluster id
    public static final String KEY = "your_cluster";

    //Use a constant NamespacedKey for your windows
    public static final NamespacedKey YOUR_WINDOW = new NamespacedKey(KEY, "your_window");

    //The same for possible global Buttons
    public static final NamespacedKey YOUR_GLOBAL_BUTTON = new NamespacedKey(KEY, "your_global_button");


    public YourCluster(InventoryAPI<CustomCache> inventoryAPI) {
        super(inventoryAPI, KEY);
    }

    @Override
    public void onInit() {


        //Called on initialization! Used to register GuiWindows and Buttons.
        registerGuiWindow(new YourWindow(this));
        registerButton(new DummyButton(YOUR_GLOBAL_BUTTON.getKey(), Material.BARRIER));

    }

}
