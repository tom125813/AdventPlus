package com.doontcare.adventplus.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ChatUtils {

    public static String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> translate(List<String> message) {
        List<String> newMessage = new ArrayList<>();

        message.forEach(m -> {
            newMessage.add(translate(m));
        });

        return newMessage;
    }

}
