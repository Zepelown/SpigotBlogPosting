package io.github.zepelown.testplugin.inventory;

import io.github.zepelown.testplugin.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;



public class TestGUI implements InventoryHolder {
    private final Inventory inv;

    private void initItemSetting() {
        for(int i = 0; i < 9; i++){
            if(i==3)
                inv.setItem(i,ItemManager.dia);
            else if (i==4)
                inv.setItem(i, ItemManager.healPotion);
            else
                inv.setItem(i,ItemManager.guiGrayGlassPane);
        }
    }

    public TestGUI() {
        this.inv = Bukkit.createInventory(null,9,"TESTGUI");
        initItemSetting();
    }

    public void open(Player player){
        player.openInventory(inv);
    }



    @Override
    public Inventory getInventory() {
        return inv;
    }
}
