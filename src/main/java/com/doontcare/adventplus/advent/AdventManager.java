package com.doontcare.adventplus.advent;

import com.doontcare.adventplus.utils.ChatUtils;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AdventManager {

    private HashMap<UUID, List<AdventItem>> uuidAdventItemsHashMap = new HashMap<>();

    // Locked data
    private String lockedName;
    private Material lockedItem;
    private List<String> lockedLore;

    public AdventManager() {
        // Get data from config
        lockedName = ChatUtils.translate("&cThis item is locked");
        lockedItem = Material.BARRIER;
        lockedLore = Arrays.asList("", "&7Check back later to claim this gift!", "&7This unlocks in {days} days!", "");
    }

}
