package me.fodded.chatplugin;

import me.fodded.chatplugin.listeners.AsyncPlayerChatListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
