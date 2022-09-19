package io.github.zepelown.testplugin.commands;

import io.github.zepelown.testplugin.inventory.TestGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenInv implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            TestGUI inv = new TestGUI();
            inv.open(player);
        }
        return false;
    }
}
