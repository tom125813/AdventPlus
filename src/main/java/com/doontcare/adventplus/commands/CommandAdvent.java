package com.doontcare.adventplus.commands;

import com.doontcare.adventplus.AdventPlus;
import com.doontcare.adventplus.advent.AdventInventory;
import com.doontcare.adventplus.config.ConfigManager;
import com.doontcare.adventplus.utils.ChatUtils;
import com.doontcare.adventplus.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class CommandAdvent implements CommandExecutor {

    private AdventPlus adventPlus;

    private ConfigManager configManager;
    private AdventInventory adventInventory;

    public CommandAdvent(AdventPlus adventPlus) {
        this.adventPlus = adventPlus;

        configManager = adventPlus.getConfigManager();
        adventInventory = adventPlus.getAdventInventory();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("advent")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatUtils.translate("&2AdventPlus: &adoontcare &o(SpigotMC/BuiltByBit) &aor tom125813 &o(GitHub)"));
                return false;
            }

            Player player = (Player) sender;

            if (args.length == 1 && args[0].equalsIgnoreCase("info")) {
                // Make this customizable
                List<String> infoStrings = Arrays.asList(
                        "&a&m" + StringUtils.repeat(" ", 80),
                        "&c&m" + StringUtils.repeat(" ", 80),
                        "&f&m" + StringUtils.repeat(" ", 80),
                        " ",
                        "                     &c&lChristmas Calendar &f" + DateUtils.getYear(),
                        "           &aGo ahead and claim your &2&navailable&r&a daily gifts!",
                        " ",
                        "&f&m" + StringUtils.repeat(" ", 80),
                        "&c&m" + StringUtils.repeat(" ", 80),
                        "&a&m" + StringUtils.repeat(" ", 80)
                );

                for (String line : infoStrings)
                    player.sendMessage(ChatUtils.translate(line));

            } else {
                // Open advent inventory
                player.sendMessage(ChatUtils.translate("&aOpening advent calendar..."));
                player.openInventory(adventInventory.getInventory());
            }
        }

        return false;
    }
}
