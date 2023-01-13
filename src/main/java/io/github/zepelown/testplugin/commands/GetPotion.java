package io.github.zepelown.testplugin.commands;

import io.github.zepelown.testplugin.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetPotion implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player))
            sender.sendMessage("인게임에서 명령어를 쳐주세요");
        Player player = (Player) sender;
        switch (args.length) {
            case 1:
                if (args[0].equalsIgnoreCase("heal")) {
                    player.getInventory().addItem(ItemManager.healPotion);
                    sender.sendMessage("회복 포션이 지급되었습니다.");
                    break;
                }
                else if (args[0].equalsIgnoreCase("speed")) {
                    player.getInventory().addItem(ItemManager.speedPotion);
                    sender.sendMessage("스피드 포션이 지급되었습니다.");
                    break;
                }
                else {
                    sender.sendMessage("포션명을 적어주세요.");
                    break;
                }
            default:
                player.sendMessage("명령어를 제대로 입력해주세요.");
        }

        return false;
    }
}
