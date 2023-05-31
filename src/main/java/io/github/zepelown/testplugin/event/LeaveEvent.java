package io.github.zepelown.testplugin.event;

import io.github.zepelown.testplugin.TestPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    private TestPlugin plugin = TestPlugin.getPlugin();

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        //TestPlugin.getPlayerManager().removePlayer(e.getPlayer());
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent e){
    }
}
