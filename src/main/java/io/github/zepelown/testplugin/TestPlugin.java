package io.github.zepelown.testplugin;


import io.github.zepelown.testplugin.commands.*;
import io.github.zepelown.testplugin.event.BreakEvent;
import io.github.zepelown.testplugin.event.InvClickEvent;
import io.github.zepelown.testplugin.event.JoinEvent;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    private static TestPlugin plugin;
    FileConfiguration config = this.getConfig();

    private void initConfig(){
        config.addDefault("join-message.display-message", true);
        config.addDefault("join-message.message", "&7{playername} 님 안녕하세요!");
        config.options().copyDefaults(true);
        saveConfig();
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new BreakEvent(), this);
        getServer().getPluginManager().registerEvents(new InvClickEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
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
        plugin = this;
        // Plugin startup logic
        getLogger().info("플러그인 활성화!!");
        registerCommands();
        registerEvents();
        initConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("플러그인 비활성화");
    }



    public static TestPlugin getPlugin() {
        return plugin;
    }
}
