package io.github.zepelown.testplugin;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ChatManager {

    public static String prefix = ChatColor.GRAY+"["+ChatColor.YELLOW+"테스트"+ChatColor.GRAY+"]";

    public static void sendConfigMessageToPlayer(Player player, String path){
        TestPlugin plugin = TestPlugin.getPlugin();
        FileConfiguration config = plugin.getConfig();
        player.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&',config.getString(path)
                .replace("{playername}",player.getName())));
    }

    public static void sendMessageToPlayer(Player player, String string){
        player.sendMessage(prefix + string);
    }

}
