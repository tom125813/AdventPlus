package com.doontcare.adventplus.advent;

import com.doontcare.adventplus.utils.DateUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Date;

public class AdventItem {

    private String name;

    private Date unlockDate;

    private AdventResult locked;
    private AdventResult claimed;

    private String claimCommand;

    public AdventItem(int unlockDay, String name, String claimCommand) {
        this.name = name;
        this.claimCommand = claimCommand;

        unlockDate = new Date(DateUtils.getYear(), 12, unlockDay);
        locked = tryUnlock();

        claimed = AdventResult.UNCLAIMED;
    }

    private AdventResult tryUnlock() {
        if (unlockDate.after(new Date()))
            return AdventResult.LOCKED;
        return AdventResult.UNLOCKED;
    }

    public AdventResult claim(Player player) {
        if (tryUnlock() == AdventResult.LOCKED)
            return AdventResult.LOCKED;

        if (claimed == AdventResult.CLAIMED)
            return AdventResult.ALREADY_CLAIMED;

        claimed = AdventResult.CLAIMED;

        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), claimCommand.replace("{player}", player.getName()));

        return claimed;
    }

}
