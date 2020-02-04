package cn.minecraft.MoFa;

//物品注册信息填写

import cn.minecraft.MoFa.GuiUi.Button;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RegisterItemAll {
    //机器列表
    public static ItemStack CJGZT(){ return Button.GetItem(Material.DISPENSER,"§e超级工作台",new String[]{"§6用于合成一些高级物品"}); }
    public static ItemStack MFGZT(){ return Button.GetItem(Material.ENCHANTMENT_TABLE,"§3魔法工作台",new String[]{"§3用于合成一些神秘物品"}); }

    public static List<ItemStack> CJGZTREC(){
        List<ItemStack> ItemRec = new ArrayList<ItemStack>();
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.CHEST));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.WORKBENCH));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.DISPENSER));
        ItemRec.add(new ItemStack(Material.AIR));
        return ItemRec;
    }
    public static List<ItemStack> MFGZTREC(){
        List<ItemStack> ItemRec = new ArrayList<ItemStack>();
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.ENCHANTMENT_TABLE));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.DISPENSER));
        ItemRec.add(new ItemStack(Material.WORKBENCH));
        ItemRec.add(new ItemStack(Material.CHEST));
        return ItemRec;
    }

    //宝石列表
    public static ItemStack Bs1(){ return Button.GetItem(Material.IRON_INGOT,"§f铁星石",new String[]{}); }
    public static List<ItemStack> Bs1Rec (){
        List<ItemStack> ItemRec = new ArrayList<ItemStack>();
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.IRON_ORE));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        return ItemRec;
    }

    public static ItemStack Bs2(){
        return Button.GetItem(Material.GOLD_INGOT,"§e金星石",new String[]{});
    }
    public static List<ItemStack> Bs2Rec (){
        List<ItemStack> ItemRec = new ArrayList<ItemStack>();
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.GOLD_ORE));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        return ItemRec;
    }

    public static ItemStack Bs3(){
        return Button.GetItem(Material.DIAMOND,"§b蓝星石",new String[]{});
    }
    public static List<ItemStack> Bs3Rec (){
        List<ItemStack> ItemRec = new ArrayList<ItemStack>();
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.DIAMOND_ORE));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        return ItemRec;
    }

    public static ItemStack Bs4(){
        return Button.GetItem(Material.REDSTONE,"§4红能石",new String[]{});
    }
    public static List<ItemStack> Bs4Rec (){
        List<ItemStack> ItemRec = new ArrayList<ItemStack>();
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.REDSTONE_ORE));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        return ItemRec;
    }

    //工具列表
    public static ItemStack Tools1(){
        return Button.GetItem(Material.IRON_HOE,"§4魔能锄",new String[]{"§6类型:§4魔能","","§e使用方法","§a右键泥土或草方块","","§b技能","§a一次可以挖掘4块耕地"});
    }
    public static List<ItemStack> Tools1Rec (){
        List<ItemStack> ItemRec = new ArrayList<ItemStack>();
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(Bs1());
        ItemRec.add(Bs1());
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(Bs4());
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.AIR));
        ItemRec.add(new ItemStack(Material.STICK));
        ItemRec.add(new ItemStack(Material.AIR));
        return ItemRec;
    }
}
