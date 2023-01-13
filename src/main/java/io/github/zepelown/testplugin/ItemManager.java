package io.github.zepelown.testplugin;


import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public class ItemManager {

    private static ItemStack buildItem(Material type, int amount, String displayName, String... lore) {
        ItemStack stack = new ItemStack(type, amount);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(lore));
        stack.setItemMeta(meta);
        return stack;
    }

    private static ItemStack buildItem(Material type, int amount, String displayName, Enchantment enchant, int enchantlvl, boolean enchantRestrict, String... lore) {
        ItemStack stack = new ItemStack(type, amount);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(lore));
        meta.addEnchant(enchant, enchantlvl, enchantRestrict);
        stack.setItemMeta(meta);
        return stack;
    }

    private static ItemStack buildItem(Material type, int amount, Color color, PotionEffectType effect, int duration, int amplifier, String displayName, String... lore){
        ItemStack stack = new ItemStack(type, amount);
        PotionMeta meta = (PotionMeta) stack.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(lore));
        meta.setColor(color);
        PotionEffect potionEffect = new PotionEffect(effect, duration, amplifier);
        //마크는 시간을 ticks 이란 단위로 세기 때문에 수정 필요
        meta.addCustomEffect(potionEffect,false);
        stack.setItemMeta(meta);
        return stack;
    }



    public static final ItemStack dia = buildItem(Material.DIAMOND, 1, ChatColor.AQUA +"다이아","흙을 캐서 얻은 다이아다",
            ChatColor.WHITE + "노말");

    public static final ItemStack enchantDia = buildItem(Material.DIAMOND, 1, ChatColor.AQUA +"다이아",
            Enchantment.DIG_SPEED, 1, false,"흙을 캐서 얻은 다이아다", ChatColor.LIGHT_PURPLE + "영웅");

    public static final ItemStack guiGrayGlassPane = buildItem(Material.GRAY_STAINED_GLASS_PANE, 1, ChatColor.GRAY + "빈칸","아이템 설명을 잘 읽어보세요");


    public static final ItemStack healPotion = buildItem(Material.POTION,1, Color.PURPLE,PotionEffectType.REGENERATION,100,2,ChatColor.YELLOW + "재생", "체력을 재생시킵니다");

    public static final ItemStack speedPotion = buildItem(Material.POTION,1,Color.BLUE,PotionEffectType.SPEED,400,10,ChatColor.BLUE + "스피드", ChatColor.GREEN+"아주 빠르게!");


}
