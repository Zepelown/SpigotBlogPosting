package io.github.zepelown.testplugin;


import io.github.zepelown.testplugin.commands.GiveDia;
import io.github.zepelown.testplugin.commands.Help;
import io.github.zepelown.testplugin.commands.OpenInv;
import io.github.zepelown.testplugin.event.BreakEvent;
import io.github.zepelown.testplugin.event.InvClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("플러그인 활성화");
        getServer().getPluginManager().registerEvents(new BreakEvent(), this);
        getServer().getPluginManager().registerEvents(new InvClickEvent(), this);
        getServer().getPluginCommand("thelp").setExecutor(new Help());
        getServer().getPluginCommand("tgivedia").setExecutor(new GiveDia());
        getServer().getPluginCommand("topeninv").setExecutor(new OpenInv());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("플러그인 비활성화");
    }
}
