package io.github.zepelown.testplugin.event;

import io.github.zepelown.testplugin.ChatManager;
import io.github.zepelown.testplugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        TestPlugin plugin = TestPlugin.getPlugin();
        String playerName = player.getName();
        FileConfiguration config = plugin.getConfig();

        ChatManager.sendConfigMessageToPlayer(player, "join-message.message");
        /*
        if(!config.contains("players."+playerName)) {
            ChatManager.sendMessageToPlayer(player,"님! 서버에 첫 방문을 환영합니다!");
            config.set("players."+playerName+".rank", "default");
            config.set("players."+playerName+".job", "jobless");
        } else{
            ChatManager.sendConfigMessageToPlayer(player, "join-message.message");
        }
        LocalDateTime now = LocalDateTime.now();
        String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        config.set("players."+playerName+".recent-join-date",formatedNow);

        plugin.saveConfig();*/
    }


}
