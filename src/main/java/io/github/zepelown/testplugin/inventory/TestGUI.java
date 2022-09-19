package io.github.zepelown.testplugin.inventory;

import io.github.zepelown.testplugin.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TestGUI implements Listener {
    private final Inventory inv;

    private void initItemSetting() {
        inv.setItem(0,ItemManager.guiBuffItem);
    }

    public TestGUI() {
        this.inv = Bukkit.createInventory(null,9,"TESTGUI");
        initItemSetting();
    }

    public void open(Player player){
        player.openInventory(inv);
    }

    @EventHandler
    public void invClick(InventoryClickEvent e){
        if(!e.getInventory().equals(inv)) return;

        e.setCancelled(true);

        ItemStack clickedItem = e.getCurrentItem();

        if(clickedItem == null || clickedItem.getType().isAir()) return;
        else if(clickedItem.isSimilar(ItemManager.guiBuffItem)){
            Player player = (Player) e.getWhoClicked();
            player.getInventory().addItem(ItemManager.guiBuffItem);
        }



    }


}
