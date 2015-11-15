package me.randall123459.AntiCurse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCurse extends JavaPlugin implements Listener {
	
	@EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
    	if (!e.getPlayer().hasPermission("curse.true")) {
    		for (String word : e.getMessage().split("  ")) {
    			if (getConfig().getStringList("badwords").contains(word)) {
    				e.setCancelled(true);
    				e.getPlayer().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry you are not allowed to swear");
			}
    		}
        }
	}
	
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

}