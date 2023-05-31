package io.github.zepelown.testplugin.event;

import io.github.zepelown.testplugin.TestPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    FileConfiguration messageConfig = TestPlugin.getConfigManager().getConfig("message");
    FileConfiguration playerConfig = TestPlugin.getConfigManager().getConfig("player");

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        String rank, job, prefix;
        String playerName = player.getName();
        //만약 월드 데이터에 플레이어 정보가 없다면
        if(!player.hasPlayedBefore()){
            rank = "newbie"; job = "jobless";
            if(messageConfig.getBoolean("new-player-join-message.display-message"))
                e.setJoinMessage(TestPlugin.getConfigManager().getConfigColorString("message","new-player-join-message.message")
                    .replace("{playername}", playerName));
            TestPlugin.getPlayerManager().addFirstPlayer(player);
        } else {
            rank = playerConfig.getString("players."+playerName+".rank");
            job = playerConfig.getString("players."+playerName+".job");
            //config 데이터가 손실됐을 경우
            if(rank == null || job == null){
                rank = "newbie";
                job = "jobless";
                player.sendMessage(TestPlugin.pluginPrefix +"등급과 직업이 존재하지 않아 기본값을 부여하였습니다");
            }
            if (messageConfig.getBoolean("join-message.display-message"))
                e.setJoinMessage(TestPlugin.getConfigManager().getConfigColorString("message","join-message.message")
                    .replace("{playername}", playerName));
            TestPlugin.getPlayerManager().addPlayer(player,rank,job);
        }
        prefix = TestPlugin.getConfigManager().getConfig("rank").getString("ranks." + rank + ".prefix");
        player.setPlayerListName(prefix + playerName);

    }


}
