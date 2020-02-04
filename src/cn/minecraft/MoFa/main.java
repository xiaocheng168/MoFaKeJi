package cn.minecraft.MoFa;

import cn.minecraft.MoFa.Event.Bs;
import cn.minecraft.MoFa.Event.Event;
import cn.minecraft.MoFa.Event.GuiEvent;
import cn.minecraft.MoFa.Event.RecEvent;
import cn.minecraft.MoFa.Event.BookGui;
import cn.minecraft.MoFa.Item.MFKJ;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static cn.minecraft.MoFa.GuiUi.Button.*;
import static cn.minecraft.MoFa.GuiUi.Button.Sw;

public class main extends JavaPlugin implements Listener {
    private List<ItemStack> list = new ArrayList<ItemStack>();
    public static String prefix = "§a[§b魔法§e§k|§6科技§a]§6";
    public static String GuiTitle = "§2魔法科技 - §4MoFaKeJi";
    public static boolean LoadFPlugin = false;
    public static File dir;

    public static HashMap<Player,Inventory> gui = new HashMap<Player, Inventory>();//玩家关闭时的GUI界面 保存 下次打开的界面

    @Override
    public void onEnable() {
        dir = getDataFolder();
        saveDefaultConfig();
        File file = new File(main.dir,"Items.yml");
        if (!file.exists()){ try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } }
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new RecEvent(), this);
        Bukkit.getPluginManager().registerEvents(new GuiEvent(), this);
        Bukkit.getPluginManager().registerEvents(new Event(), this);
        Bukkit.getPluginManager().registerEvents(new BookGui(), this);
        Bukkit.getPluginManager().registerEvents(new Bs(), this);
        LoadPluginItem();
        getLogger().info("魔法科技已载入:"+MFKJ.getItems().size()+"个原版物品");
    }
    @Override
    public void onDisable(){ getLogger().info("魔法科技已卸载"); }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command,String sender,String[] l){
        if (command.getName().equalsIgnoreCase("mf")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(GetMessage("目前后台无法使用指令"));
                return true;
            }
            Player p = (Player) commandSender;
            p.getInventory().addItem(Items.GetMfBook());
            p.sendRawMessage(prefix+"你已领取一本魔法科技书,赶紧看看吧！");
        }
        return false;
    }
    public static String GetMessage(String Message){ return prefix+Message; }//获得前缀
    public static void AddLog(String Test){
        System.out.printf(Test);
    }//调试输出
    public void LoadPluginItem(){//注册基础物品//初始化MainGui
        LoadFPlugin = true;
        ItemStack dis =MFKJ.AddItemClass(DIS);//机器
        ItemStack cl =MFKJ.AddItemClass(Cl);//材料
        ItemStack tools =MFKJ.AddItemClass(Tools);//工具
        ItemStack sw =MFKJ.AddItemClass(Sw);//食物

        //机器
        MFKJ.RegisterItem(RegisterItemAll.CJGZT(),RegisterItemAll.CJGZTREC(),Type.IType_Build,dis);
        MFKJ.RegisterItem(RegisterItemAll.MFGZT(),RegisterItemAll.MFGZTREC(),Type.IType_Build,dis);


        //材料
        MFKJ.RegisterItem(RegisterItemAll.Bs1(),RegisterItemAll.Bs1Rec(),Type.IType_DeBlock,cl);
        MFKJ.RegisterItem(RegisterItemAll.Bs2(),RegisterItemAll.Bs2Rec(),Type.IType_DeBlock,cl);
        MFKJ.RegisterItem(RegisterItemAll.Bs3(),RegisterItemAll.Bs3Rec(),Type.IType_DeBlock,cl);
        MFKJ.RegisterItem(RegisterItemAll.Bs4(),RegisterItemAll.Bs4Rec(),Type.IType_DeBlock,cl);

        //工具
        MFKJ.RegisterItem(RegisterItemAll.Tools1(),RegisterItemAll.Tools1Rec(),RegisterItemAll.MFGZT(),tools);
    }
    public static void PlayerS(Player p){
        p.playSound(p.getLocation(), Sound.BAT_LOOP,1,2);
    }
}
