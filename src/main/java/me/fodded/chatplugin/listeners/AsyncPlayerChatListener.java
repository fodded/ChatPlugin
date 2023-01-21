package me.fodded.chatplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    private String format(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    @EventHandler
    public void onChatListener(AsyncPlayerChatEvent event) {
        event.setCancelled(true);

        Player sender = event.getPlayer();

        for(Player player : Bukkit.getOnlinePlayers()) {
            double distance = player.getLocation().distance(sender.getLocation());

            if(event.getMessage().startsWith("!")) {
                player.sendMessage(format("&7[Global] " + event.getMessage().substring(1)));
            } else {
                if(distance <= 100) {
                    player.sendMessage(format("&8[Local] " + event.getMessage()));
                }
            }
        }
    }
}
