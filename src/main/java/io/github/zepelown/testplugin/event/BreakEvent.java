package io.github.zepelown.testplugin.event;


import io.github.zepelown.testplugin.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class BreakEvent implements Listener {

    @EventHandler
    public void breakDirt(BlockBreakEvent e) {
        Material brBlock = e.getBlock().getBlockData().getMaterial();
        if(brBlock == Material.DIRT || brBlock == Material.GRASS_BLOCK){
            Player p = e.getPlayer();
            p.sendMessage("다이아를 발견하셨습니다.");
            if(Math.floor(Math.random() * 10)< 5){
                p.getInventory().addItem(ItemManager.enchantDia);
            } else {
                p.getInventory().addItem(ItemManager.dia);
            }
        }
        
    }

}
