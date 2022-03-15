package com.arcanetravel.window;

import com.arcanetravel.guicluster.YourCluster;
import me.wolfyscript.utilities.api.inventory.gui.GuiCluster;
import me.wolfyscript.utilities.api.inventory.gui.GuiUpdate;
import me.wolfyscript.utilities.api.inventory.gui.GuiWindow;
import me.wolfyscript.utilities.api.inventory.gui.button.buttons.DummyButton;
import me.wolfyscript.utilities.api.inventory.gui.cache.CustomCache;
import org.bukkit.Material;

public class YourWindow extends GuiWindow<CustomCache> {
    //These constants can be private because the Buttons are local and can only be accessed inside this GuiWindow!
    private static final String YOUR_LOCAL_BUTTON = "your_local_button";

    public YourWindow(GuiCluster<CustomCache> guiCluster) {
        super(guiCluster, YourCluster.YOUR_WINDOW.getKey(), 54); //Use the constant you defined in the the GuiCluster
    }

    @Override
    public void onInit() {
        //Called on initialization. Used to register Buttons.
        //For example create a dummy button and use the constant you defined on top!
        registerButton(new DummyButton(YOUR_LOCAL_BUTTON, Material.BARRIER));
    }

    @Override
    public void onUpdateSync(GuiUpdate<CustomCache> update) {
        //Updated sync
        update.setButton(1, YOUR_LOCAL_BUTTON);
        update.setButton(2, YourCluster.YOUR_GLOBAL_BUTTON);
        //As you can see... it can get quite messy if you don't use constants!
        //You would have duplicate Strings everywhere and it makes it more difficult to maintain!
    }

    @Override
    public void onUpdateAsync(GuiUpdate<CustomCache> guiUpdate) {
        //Updated async
    }
}
