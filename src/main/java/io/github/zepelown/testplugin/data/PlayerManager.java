package io.github.zepelown.testplugin.data;

import io.github.zepelown.testplugin.TestPlugin;
import io.github.zepelown.testplugin.data.OnlinePlayerData;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;

public class PlayerManager {

    final FileConfiguration playersConfig = TestPlugin.getConfigManager().getConfig("player");
    final FileConfiguration rankConfig = TestPlugin.getConfigManager().getConfig("rank");

    private HashMap<Player, OnlinePlayerData> onlinePlayerData = new HashMap<>();
    private String RankList[];

    public PlayerManager(){
    }

    public void addPlayer(Player player, String rank, String job){
        onlinePlayerData.put(player,new OnlinePlayerData(player, player.getName(),
                rank, job));
    }

    public void addFirstPlayer(Player player){
        playersConfig.set("players."+player.getName()+".rank", "newbie");
        playersConfig.set("players."+player.getName()+".job", "jobless");
        TestPlugin.getConfigManager().saveConfig("player");

        onlinePlayerData.put(player,new OnlinePlayerData(player, player.getName(),
                "newbie", "jobless"));
    }

    public void setPlayerRank(Player player,String rank){
        OnlinePlayerData data = onlinePlayerData.get(player);
        data.setRank(rank);
    }

    public void removePlayer(Player player){
        onlinePlayerData.remove(player);
    }

    public OnlinePlayerData getOnlinePlayerData(Player player){
        return onlinePlayerData.get(player);
    }

    public String getOnlinePlayerRank(Player player){
        return onlinePlayerData.get(player).getRank();
    }

    public String getOnlinePlayerJob(Player player){
        return onlinePlayerData.get(player).getJob();
    }

    public boolean isOnline(Player player){
        return onlinePlayerData.containsKey(player);
    }
}
