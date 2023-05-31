package io.github.zepelown.testplugin.commands;

import io.github.zepelown.testplugin.TestPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadConfig implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        sender.sendMessage("config reload");
        TestPlugin.getConfigManager().reloadConfigs();
        sender.sendMessage("config reload complete");
        return false;
    }
}
