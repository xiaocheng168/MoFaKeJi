package cn.minecraft.MoFa.Event;

import cn.minecraft.MoFa.Item.MFKJ;
import cn.minecraft.MoFa.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


import java.util.Map;

import static cn.minecraft.MoFa.GuiUi.Button.HomeButton;

public class GuiEvent implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent a){ //打开物品合成表事件
        Inventory inv = a.getInventory();
        Player p = (Player) a.getWhoClicked();
        ItemStack itemStack = a.getCurrentItem();
        if (itemStack == null){return;}
        if (!(inv.getTitle().contains(main.GuiTitle))){ return; } //判断是否为魔法科技指南Gui
        if (inv.getTitle().contains(main.GuiTitle)){ a.setCancelled(true); }//防止玩家拿走Gui内物品;
        if (p.isOp() == true){ //OP右键直接给予物品
            if (a.getClick().equals(ClickType.RIGHT)){
                p.getInventory().addItem(itemStack);
                return;
            }
        } //OP直接拿物品
        if (MFKJ.isPluginItem(itemStack)) {//判断是否为插件注册物品 打开物品合成GUI
            if (MFKJ.RecGui(itemStack) == null) {
                p.sendRawMessage(main.prefix + "该物品没有合成方案");
                a.setCancelled(true);
                return;
            }
            main.PlayerS(p);//打开物品合成GUI
            p.openInventory(MFKJ.RecGui(itemStack));
            return;
        }

        int i = a.getSlot()+1-9;//单击格子位置

        if (MFKJ.GetGui(itemStack) != null){ //打开子菜单
            for (int i1 = 0; i1 < MFKJ.getMainGuiButton().size(); i1++) {
                if (MFKJ.getMainGuiButton().get(i1).equals(itemStack)){
                    main.PlayerS(p);
                    p.openInventory(MFKJ.GetGui(itemStack));
                    return;
                }
            }
        }
        if (a.getCurrentItem().equals(HomeButton)) {//返回主页
            p.openInventory(MFKJ.GetMainGui());
        }
    }
}