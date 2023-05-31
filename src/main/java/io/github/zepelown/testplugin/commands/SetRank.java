package io.github.zepelown.testplugin.commands;

import io.github.zepelown.testplugin.TestPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetRank implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player))
            return false;
        switch (args.length){
            case 0:
                sender.sendMessage("랭크를 입력하세요.");
                break;
            case 1:
                String rank = args[0].toLowerCase();
                break;
        }
        //TestPlugin.getPlayerManager().setPlayerRank("");
        return false;
    }
}
