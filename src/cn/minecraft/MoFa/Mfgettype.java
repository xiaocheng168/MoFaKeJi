package cn.minecraft.MoFa;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static cn.minecraft.MoFa.GuiUi.Button.GetItem;

public class Mfgettype {
    public static ItemStack IType_Build = GetItem(Material.BRICK, "§6类型", new String[]{"", " §a按照图纸 使用方块搭建"});
    public static ItemStack IType_DamageBlock = GetItem(Material.DIAMOND_PICKAXE, "§6类型", new String[]{"", " §a破坏左边物品获得"});
}
