package io.github.zepelown.testplugin.event;

import io.github.zepelown.testplugin.TestPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        //String rank = TestPlugin.getConfigManager().getConfig("rank").getString("ranks.newbie.prefix");
        //e.setFormat(rank + player.getName() + " : " + e.getMessage());
    }
}
