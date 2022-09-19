package io.github.zepelown.testplugin.commands;

import io.github.zepelown.testplugin.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveDia implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            switch (args.length) {
                case 0:
                    sender.sendMessage("다이아가 지급되었습니다.");
                    player.getInventory().addItem(ItemManager.dia);
                    break;
                case 1:
                    if(args[0].equalsIgnoreCase("enchant")) {
                        player.getInventory().addItem(ItemManager.enchantDia);
                        sender.sendMessage("다이아가 지급되었습니다.");
                        break;
                    } else {
                        try{
                            int amount = Integer.parseInt(args[0]);
                            ItemStack dia = new ItemStack(ItemManager.dia);
                            dia.setAmount(amount);
                            player.getInventory().addItem(dia);
                            break;
                        } catch (NumberFormatException e){
                            player.sendMessage("명령어를 제대로 입력해주세요.");
                            return false;
                        } catch (Exception e){
                            player.sendMessage("명령어를 제대로 입력해주세요.");
                            return false;
                        }
                    }
                case 2:
                    try{
                        int amount = Integer.parseInt(args[1]);
                        ItemStack dia = new ItemStack(ItemManager.enchantDia);
                        dia.setAmount(amount);
                        player.getInventory().addItem(dia);
                        break;
                    } catch (NumberFormatException e){
                        player.sendMessage("명령어를 제대로 입력해주세요.");
                        return false;
                    } catch (Exception e){
                        player.sendMessage("명령어를 제대로 입력해주세요.");
                        return false;
                    }
            }
        } else {
            sender.sendMessage("콘솔로 치지마세요 ~ ");
        }
        return false;
    }
}
