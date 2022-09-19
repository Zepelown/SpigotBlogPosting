package io.github.zepelown.testplugin;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
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

    private static ItemStack buildItem(Material type, int amount, PotionEffectType effect, int duration, int amplifier, String displayName, String... lore){
        ItemStack stack = new ItemStack(type, amount);
        PotionMeta meta = (PotionMeta) stack.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(lore));
        PotionEffect potionEffect = new PotionEffect(effect, duration, amplifier);
        //마크는 시간을 ticks 이란 단위로 세기 때문에 20초를 원하면 200 * 20 을 해야함.
        meta.addCustomEffect(potionEffect,false);
        stack.setItemMeta(meta);
        return stack;
    }

    public static final ItemStack dia = buildItem(Material.DIAMOND, 1, ChatColor.AQUA +"다이아","흙을 캐서 얻은 다이아다",
            ChatColor.WHITE + "노말");

    public static final ItemStack enchantDia = buildItem(Material.DIAMOND, 1, ChatColor.AQUA +"다이아",
            Enchantment.DIG_SPEED, 1, false,"흙을 캐서 얻은 다이아다", ChatColor.LIGHT_PURPLE + "영웅");

    public static final ItemStack guiGrayGlassPane = buildItem(Material.GRAY_STAINED_GLASS_PANE, 1, ChatColor.GRAY + "빈칸","아이템 설명을 잘 읽어보세요");
    public static final ItemStack guiBuffItem = buildItem(Material.POTION,1,PotionEffectType.SPEED,200*20,2,ChatColor.LIGHT_PURPLE + "회복", "체력을 최대치로 회복시킵니다.");


}
