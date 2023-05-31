package io.github.zepelown.testplugin.data;

import io.github.zepelown.testplugin.TestPlugin;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.List;
import java.util.UUID;

public class OnlinePlayerData {
    private UUID UUID;
    private String displayName;
    private String rank;
    private String job;
    private PermissionAttachment permissionAttachment;

    public OnlinePlayerData(Player player,String displayName, String rank, String job) {
        this.UUID = player.getUniqueId();
        this.displayName = displayName;
        this.rank = rank;
        this.job = job;
        permissionAttachment = player.addAttachment(TestPlugin.getPlugin());
        setUpPermission(player);
    }

    public UUID getPlayerUUID() {
        return UUID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getRank() {
        return rank;
    }

    public String getJob() {
        return job;
    }

    private void setUpPermission(Player player){
        List<String> temp;
        try{
            temp = TestPlugin.getConfigManager().getConfig("rank").getStringList("ranks."+rank+".permissions");
        } catch (NullPointerException e){
            TestPlugin.getPlugin().getServer().getLogger().info("펄미션 불가능");
            return;
        }
        TestPlugin.getPlugin().getServer().getLogger().info("펄미션 가능");
        for (String perms : temp){
            permissionAttachment.setPermission(perms, true);
        }
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
