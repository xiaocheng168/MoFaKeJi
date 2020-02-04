package cn.minecraft.MoFa.GuiUi;

import java.awt.print.Book;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Skull;

public class Button {

   public static ItemStack HomeButton = GetItem(Material.BOOK, "§6首页", new String[]{"", " §a点击返回指南首页"});
   public static ItemStack DIS = GetItem(Material.DISPENSER, "§b机器", new String[]{"§6一些需要的工作机器"});
   public static ItemStack Cl = GetItem(Material.QUARTZ, "§a材料", new String[]{"§6一些合成需要用到的东西"});
   public static ItemStack Tools = GetItem(Material.STICK, "§6工具", new String[]{"§6一些工具,可能可以帮助你解决大事"});
   public static ItemStack Sw = GetItem(Material.APPLE, "§c食物", new String[]{"§a吃饱了才有力气干活,坐下来好好做点东西吃"});


   public static ItemStack GetItem(Material material, String ItemName, String[] lore) {
      ItemStack itemStack = new ItemStack(material);
      ItemMeta itemMeta = itemStack.getItemMeta();
      itemMeta.setDisplayName(ItemName);
      ArrayList arrayList = new ArrayList();

      for (int i = 0; i < lore.length; ++i) {
         arrayList.add(lore[i]);
      }

      itemMeta.setLore(arrayList);
      itemStack.setItemMeta(itemMeta);
      return itemStack;
   }

   public static ItemStack getItem(Material material, String ItemName, String[] lore) {
      ItemStack itemStack = new ItemStack(material);
      ItemMeta itemMeta = itemStack.getItemMeta();
      itemMeta.setDisplayName(ItemName);
      ArrayList arrayList = new ArrayList();

      for (int i = 0; i < lore.length; ++i) {
         arrayList.add(lore[i]);
      }

      itemMeta.setLore(arrayList);
      itemStack.setItemMeta(itemMeta);
      return itemStack;
   }
}
