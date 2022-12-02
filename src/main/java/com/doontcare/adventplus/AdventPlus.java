package com.doontcare.adventplus;

import com.doontcare.adventplus.advent.AdventInventory;
import com.doontcare.adventplus.advent.AdventManager;
import com.doontcare.adventplus.commands.CommandAdvent;
import com.doontcare.adventplus.config.ConfigManager;
import com.doontcare.adventplus.config.FileHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdventPlus extends JavaPlugin {

    private FileHandler fileHandler;
    private ConfigManager configManager;

    private AdventManager adventManager;
    private AdventInventory adventInventory;

    private CommandAdvent commandAdvent;

    @Override
    public void onEnable() {
        // Check all players with open advent inventory and re-open it when the day changes.

        fileHandler = new FileHandler();
        configManager = new ConfigManager();

        adventManager = new AdventManager();
        adventInventory = new AdventInventory();

        commandAdvent = new CommandAdvent(this);

        getCommand("advent").setExecutor(commandAdvent);
    }

    @Override
    public void onDisable() {}

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public AdventManager getAdventManager() {
        return adventManager;
    }

    public AdventInventory getAdventInventory() {
        return adventInventory;
    }
}
