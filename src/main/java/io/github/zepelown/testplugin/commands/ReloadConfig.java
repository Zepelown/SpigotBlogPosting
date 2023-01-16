package io.github.zepelown.testplugin.commands;

import io.github.zepelown.testplugin.TestPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class ReloadConfig implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        TestPlugin plugin = TestPlugin.getPlugin();
        sender.sendMessage("config reload");
        plugin.reloadConfig();
        plugin.saveDefaultConfig();
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        sender.sendMessage("config reload complete");
        return false;
    }
}
