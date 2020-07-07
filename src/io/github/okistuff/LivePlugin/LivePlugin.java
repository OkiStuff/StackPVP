package io.github.okistuff.LivePlugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class LivePlugin extends JavaPlugin {

    public void onEnable(){
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "LivePlugin has been enabled");
        getServer().getPluginManager().registerEvents(new EventsClass(), this);
    }

    public void onDisable(){
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "LivePlugin has been disabled");
    }

    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
