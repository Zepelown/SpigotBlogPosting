package io.github.zepelown.testplugin.event;

import io.github.zepelown.testplugin.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClickEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getClickedInventory() == null)
            return;
        if(ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("TESTGUI")){
            e.setCancelled(true);
            if(e.getCurrentItem() == null)
                return;
            else if(e.getCurrentItem().isSimilar(ItemManager.dia)){
                Player player = (Player) e.getWhoClicked();
                player.getInventory().addItem(ItemManager.dia);
                player.sendMessage("다이아가 지급되었습니다.");
                player.closeInventory();
            }
        }
    }
}
