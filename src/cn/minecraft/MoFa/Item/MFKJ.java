package cn.minecraft.MoFa.Item;

import cn.minecraft.MoFa.GuiUi.Button;
import cn.minecraft.MoFa.API.MoFaKeJiListener;
import cn.minecraft.MoFa.main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.minecraft.MoFa.GuiUi.Button.*;

public class MFKJ {
    private static List<ItemStack> MainGuiButton = new ArrayList<ItemStack>();//类型大全 主GUI的按钮

    public static List<ItemStack> Items = new ArrayList<ItemStack>();//物品 //已注册的物品 全部

    public static List<List> ItemRec = new ArrayList<List>();//物品合成表 //注册物品的合成表 全部

    public static List<String> UidAll = new ArrayList<String>();//物品Uid //物品的Uid 全部

    public static HashMap<ItemStack,ItemStack> GetType = new HashMap<>();//物品获得方式

    public static HashMap<ItemStack,List<Material>> Jq_list = new HashMap<ItemStack, List<Material>>();//机器搭建Rec

    public static HashMap<ItemStack,List<ItemStack>> ZButton = new HashMap<>();//类型大全 子UI内物品

    public static List<MoFaKeJiListener> EventAll = new ArrayList<MoFaKeJiListener>();//主窗口GUI按钮

    public static boolean registerListener(MoFaKeJiListener eventI){
        if (EventAll.add(eventI)){
            return true;
        }
        return false;
    }
    public static boolean RegisterItem(ItemStack itemStack ,List<ItemStack> itemStacksRec,ItemStack getType,ItemStack classType) {
        if (!main.LoadFPlugin) {
            return false;
        }
        //注册物品 参数:
        // 物品
        // 物品合成表
        // 物品获得方式
        // 物品归类类型
        File file = new File(main.dir, "Items.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        for (int i = 0; i < Items.size(); i++) {
            if (itemStack.equals(Items.get(i))) {
                return false;
            }
        }

        List<ItemStack> ItemStack = new ArrayList<ItemStack>();
        for (int i = 0; i < itemStacksRec.size(); i++) {
            ItemStack.add(itemStacksRec.get(i));
        }

        String itemname = itemStack.getItemMeta().getDisplayName();
        if (config.get(itemname + ".use") != null && !config.getBoolean(itemname + ".use")) {
            return false;
        }
        //载入成功
        Items.add(itemStack);
        ItemRec.add(itemStacksRec);
        GetType.put(itemStack, getType);
        ZButton.get(classType).add(itemStack);
        config.set(itemname + ".name", itemStack.getItemMeta().getDisplayName());
        config.set(itemname + ".type", itemStack.getType().name());
        config.set(itemname + ".lore", itemStack.getItemMeta().getLore() != null ? itemStack.getItemMeta().getLore() : new ArrayList<String>());
        config.set(itemname + ".use", true);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean isPluginItem(ItemStack itemStacks){ //检测是否为插件注册物品
        if (itemStacks == null){ return false; }
        for (int i = 0; i < Items.size(); i++) {
            ItemStack GitemStack = Items.get(i);
            GitemStack.setAmount(itemStacks.getAmount());//同步数量
            if (GitemStack.equals(itemStacks)){
                return true;
            }
        }return false;
    }
    public static ItemStack isPluginRec(List<ItemStack> ZItemRec) {//检测是否为插件注册合成表
        int air = 0;
        List<ItemStack> ok_item = new ArrayList<>();
        for (int i = 0; i < ZItemRec.size(); i++) {
            ok_item.add(ZItemRec.get(i).clone());
            ok_item.get(i).setAmount(1);
            if (ok_item.get(i).getType().equals(Material.AIR)) {//判断是否为空气
                air++;
                if (air == 9) {
                    return null;
                }
            }
        }
        for (int i = 0; i < ItemRec.size(); i++) {
            if (ItemRec.get(i).equals(ok_item)){
                return Items.get(i);
            }
        }
        return null;
    }
    public static ItemStack isPluginRecl(List<Location> ZItemRec) {//检测是否为机器合成表
        for (int i = 0; i < ItemRec.size(); i++) {
            int count = 0 ;
            List<ItemStack> ItemsRce1 = ItemRec.get(i);
            for (int i1 = 0; i1 < ItemsRce1.size(); i1++) {
                ItemStack ZItemRecz = new ItemStack(ZItemRec.get(i1).getBlock().getType());
                if (ItemsRce1.get(i1).getType().equals(ZItemRecz.getType())) {
                    count++;
                    if (count == 9) {
                        ItemStack itemStack = Items.get(i).clone();
                        return itemStack;
                    }
                }
            }
        }
        return null;
    }
    public static Inventory GetMainGui(){ //获取主GUI界面
        Inventory inventory = Bukkit.createInventory(null,54,main.GuiTitle);
        for (int i = 0; i < 9; i++) { inventory.setItem(i,getItem(Material.STAINED_GLASS_PANE,"§6MoFaKeJi",new String[]{})); }
        for (int i = 0; i < MainGuiButton.size(); i++) {
            inventory.addItem(MainGuiButton.get(i));
        }
        for (int i = 54; i > 45; i--) {
            inventory.setItem(i-1,getItem(Material.STAINED_GLASS_PANE,"§6MoFaKeJi",new String[]{}));
        }
        return inventory;
    }
    public static Inventory GetGui(ItemStack itemStack){ //获取物品类型GUI界面 子界面
        if (itemStack.getType().equals(Material.AIR)){ return null; }//判断点击的物品是否为空
        Inventory Gui = Bukkit.createInventory(null,54, main.GuiTitle+"   "+itemStack.getItemMeta().getDisplayName());//创建GUI
        for (int i = 0; i < 9; i++) {
            Gui.setItem(i,getItem(Material.STAINED_GLASS_PANE,"§6MoFaKeJi",new String[]{}));
        }
        /**子菜单**/
        List<ItemStack> list = ZButton.get(itemStack);
        if (list != null){
            for (int i = 0; i < list.size(); i++) {
                Gui.addItem(list.get(i));
            }
        }
        for (int i = 54; i > 45; i--) {
            Gui.setItem(i-1,getItem(Material.STAINED_GLASS_PANE,"§6MoFaKeJi",new String[]{}));
        }
        Gui.setItem(49, HomeButton);
        return Gui;
    }
    public static Integer GetItemUid(ItemStack itemStacks){ //获取物品Uid
        for (int i = 0; i < Items.size(); i++) {
            ItemStack GitemStack = Items.get(i);
            GitemStack.setAmount(itemStacks.getAmount());//同步数量
            if (GitemStack.equals(itemStacks)){
                return Integer.valueOf(UidAll.get(i));
            }
        }return null;
    }
    public static Inventory RecGui(ItemStack item){//获得合成Gui
        Inventory Gui = Bukkit.createInventory(null,54, main.GuiTitle +"   "+item.getItemMeta().getDisplayName());
        for (int i = 0; i < Items.size(); i++) {
            if (Items.get(i).equals(item)){
                List<ItemStack> Rec = ItemRec.get(i);
                if (Rec.get(0).equals(Button.GetItem(Material.BOOK,"禁止合成",new String[]{}))){ return null; }
                Gui.setItem(0,Rec.get(0));
                Gui.setItem(1,Rec.get(1));
                Gui.setItem(2,Rec.get(2));

                Gui.setItem(9,Rec.get(3));
                Gui.setItem(10,Rec.get(4));
                Gui.setItem(11,Rec.get(5));

                Gui.setItem(18,Rec.get(6));
                Gui.setItem(19,Rec.get(7));
                Gui.setItem(20,Rec.get(8));

                Gui.setItem(Gui.getSize()-1,HomeButton);//返回首页

                Gui.setItem(13,getitemrectype(item.clone()));
                Gui.setItem(16,item);
                return Gui;
            }
        }
        return null;
    }
    public static ItemStack getitemrectype(ItemStack itemStack){
        for (Map.Entry<ItemStack,ItemStack> arg : MFKJ.GetType.entrySet()){
            if(arg.getKey().getItemMeta().getDisplayName().equals(itemStack.getItemMeta().getDisplayName())){
                return arg.getValue();
            }
        }
        if (GetType.get(itemStack) == null){
            return new ItemStack(Material.AIR);
        }
        return GetType.get(itemStack);
    }
    public static ItemStack AddItemClass(ItemStack itemStack){ //添加ClassType类
        if (!main.LoadFPlugin){ return null; }
        for (int i = 0; i < MainGuiButton.size(); i++) {
            if (MainGuiButton.get(i).equals(itemStack)){
                System.out.printf(itemStack.getItemMeta().getDisplayName() + "类载入失败 原因:该类已存在");
                return null;
            }
        }
        MainGuiButton.add(itemStack);
        ZButton.put(itemStack,new ArrayList<ItemStack>());
        return itemStack;
    }
    public static List<List> getitemrec(){
        return ItemRec;
    }
    public static List<String> getUidAll(){
        return UidAll;
    }
    public static HashMap<ItemStack, ItemStack> getIType(){
        return GetType;
    }
    public static List NoRec(){
        List<ItemStack> list = new ArrayList<ItemStack>();
        for (int a = 0;a<9;a++){
            list.add(Button.GetItem(Material.BOOK,"禁止合成",new String[]{}));
        }
        return list;
    }
    public static List<ItemStack> getMainGuiButton() { return MainGuiButton; }
    public static List<ItemStack> getItems() { return Items; }

}