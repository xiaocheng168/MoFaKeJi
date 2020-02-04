package cn.minecraft.MoFa;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Items {
    public static ItemStack GetMfBook(){
        ItemStack itemStack = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§b魔法§e§k|§6科技 - §bMoFaKeJiBooK");
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        arrayList.add("§a > 右键打开魔法世界");
        arrayList.add("");
        arrayList.add("§3开发者:小曾(Zcc)");
        itemMeta.setLore(arrayList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
