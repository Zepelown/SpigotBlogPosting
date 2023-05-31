package io.github.zepelown.testplugin.config;

import io.github.zepelown.testplugin.TestPlugin;
import io.github.zepelown.testplugin.config.ConfigMaker;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.*;

public class ConfigManager {
    private final TestPlugin plugin = TestPlugin.getPlugin();
    private final String path = plugin.getDataFolder().getAbsolutePath();

    private HashMap<String, ConfigMaker> configSet = new HashMap<>();

    public ConfigManager() {
        configSet.put("message", new ConfigMaker(path, "message.yml"));
        configSet.put("rank", new ConfigMaker(path, "rank.yml"));
        configSet.put("player",new ConfigMaker(path,"player.yml"));
        loadSettings();
        saveConfigs();
    }

    public void reloadConfigs() {
        for (String key : configSet.keySet()){
            plugin.getLogger().info(key);
            configSet.get(key).reloadConfig();
        }
    }

    public void reloadConfig(String fileName){
        configSet.get(fileName).reloadConfig();
    }

    public void saveConfigs(){
        for (String key : configSet.keySet())
            configSet.get(key).saveConfig();
    }

    public void saveConfig(String fileName){
        configSet.get(fileName).saveConfig();
    }

    public FileConfiguration getConfig(String fileName) {
        return configSet.get(fileName).getConfig();
    }

    public String getConfigColorString(String fileName, String path){ return ChatColor.translateAlternateColorCodes('&',
            getConfig(fileName).getString(path));
    }

    public void loadSettings(){
        FileConfiguration messageConfig = getConfig("message");
        FileConfiguration rankConfig = getConfig("rank");

        getConfig("player").options().copyDefaults(true);
        messageConfig.options().copyDefaults(true);
        rankConfig.options().copyDefaults(true);

        messageConfig.addDefault("join-message.display-message", true);
        messageConfig.addDefault("join-message.message", "&7{playername} 님이 접속하였습니다.");
        messageConfig.addDefault("quit-message.display-message", true);
        messageConfig.addDefault("quit-message.message", "&7{playername} 님이 접속을 종료하셨습니다.");
        messageConfig.addDefault("kick-message.display-message", true);
        messageConfig.addDefault("kick-message.message", "&4{playername} 님이 {reason} 이유로 인해 퇴장당하셨습니다.");
        messageConfig.addDefault("new-player-join-message.display-message", true);
        messageConfig.addDefault("new-player-join-message.message", "&e{playername} 님! 첫 접속을 환영합니다!!!");



        rankConfig.addDefault("ranks.admin.prefix", "[Admin]");
        List<String> test = Arrays.asList("test1","test2");
        rankConfig.addDefault("ranks.admin.permissions", test);
        rankConfig.addDefault("ranks.newbie.prefix","[Newbie]");
    }


}
