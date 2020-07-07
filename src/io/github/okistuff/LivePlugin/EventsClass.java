package io.github.okistuff.LivePlugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class EventsClass implements Listener {
    private Plugin plugin = LivePlugin.getPlugin(LivePlugin.class);
    private boolean ItemGiven = false;
    private int ItemsGivenTime =  0;

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        if(ItemGiven == false){
            Player player = event.getPlayer();
            Inventory inv = player.getInventory();
            inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 64));
        }

    }

    @EventHandler
    public void onSpawn(PlayerDropItemEvent event){
        Player player = event.getPlayer();
        if(ItemGiven == false){
            Inventory inv = player.getInventory();
            // Adding Swords to Inventory
            inv.addItem(new ItemStack(Material.DIAMOND_SWORD, 5));
            // Adding Cobblestone
            inv.addItem(new ItemStack(Material.COBBLESTONE, 64));
            inv.addItem(new ItemStack(Material.COBBLESTONE, 64));
            // check if all players got items
            if(ItemsGivenTime < 1){
                ItemsGivenTime++;
            }else if(ItemsGivenTime == 1){
                ItemGiven = true;
            }


        }else{
            // yes you can still other peoples items
            player.sendMessage(ChatColor.RED + "You already have all the items!");
        }



    }

}
