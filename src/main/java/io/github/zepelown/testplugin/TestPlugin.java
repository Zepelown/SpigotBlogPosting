package io.github.zepelown.testplugin;


import io.github.zepelown.testplugin.commands.*;
import io.github.zepelown.testplugin.config.ConfigManager;
import io.github.zepelown.testplugin.data.PlayerManager;
import io.github.zepelown.testplugin.event.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {
    private static ConfigManager configManager;
    private static EventManager eventManager;
    private static PlayerManager playerManager;

    public static String pluginPrefix = ChatColor.GRAY+"["+ChatColor.YELLOW+"플러그인"+ChatColor.GRAY+"]";

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new BreakEvent(), this);
        getServer().getPluginManager().registerEvents(new InvClickEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
        getServer().getPluginManager().registerEvents(new ChatEvent(), this);
    }

    private void registerCommands(){
        getServer().getPluginCommand("thelp").setExecutor(new Help());
        getServer().getPluginCommand("tgivedia").setExecutor(new GiveDia());
        getServer().getPluginCommand("topeninv").setExecutor(new OpenInv());
        getServer().getPluginCommand("tgetpotion").setExecutor(new GetPotion());
        getServer().getPluginCommand("treload").setExecutor(new ReloadConfig());
    }

    @Override
    public void onEnable() {
        getConfigManager();
        getEventManager();
        //getPlayerManager();
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
    }

    public static TestPlugin getPlugin() {
        return JavaPlugin.getPlugin(TestPlugin.class);
    }

    public static ConfigManager getConfigManager(){
        if(configManager == null)
            configManager = new ConfigManager();
        return configManager;
    }

    public static EventManager getEventManager(){
        if(eventManager == null)
            eventManager = new EventManager();
        return eventManager;
    }

    public static PlayerManager getPlayerManager(){
        if(playerManager == null)
            playerManager = new PlayerManager();
        return playerManager;
    }



}
