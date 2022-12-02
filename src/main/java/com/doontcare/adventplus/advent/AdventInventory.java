package com.doontcare.adventplus.advent;

import com.doontcare.adventplus.utils.ChatUtils;
import com.doontcare.adventplus.utils.DateUtils;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;
import java.util.List;

public class AdventInventory {

    private Inventory inventory;

    private String title;
    private int size;

    private List<Integer> giftSlots;

    public AdventInventory() {
        // Get data from config
        title = "&aAdvent Calendar " + DateUtils.getYear();
        size = 54;

        giftSlots = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24);

        inventory = Bukkit.createInventory(null, size, ChatUtils.translate(title));
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public List<Integer> getGiftSlots() {
        return giftSlots;
    }

}
