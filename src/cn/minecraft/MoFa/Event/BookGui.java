package cn.minecraft.MoFa.Event;

import cn.minecraft.MoFa.Item.MFKJ;
import cn.minecraft.MoFa.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

//使用书本打开魔法科技主菜单
public class BookGui implements Listener {

    /**玩家打开GUI界面**/
    @EventHandler
    public void onInteract(PlayerInteractEvent A){
        boolean Cancelled = false;
        Player player = A.getPlayer();
        if (A.getAction().equals(Action.RIGHT_CLICK_AIR) || A.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (A.getItem() != null){
                ItemStack itemStack = A.getItem();
                if (itemStack.getItemMeta().hasDisplayName() == true){
                    if (itemStack.getItemMeta().getDisplayName().contains("§b魔法§e§k|§6科技")){
                        for (int i = 0; i < MFKJ.EventAll.size(); i++) {//传递数据至开发者区
                            if (MFKJ.EventAll.get(i).PlayerOpenBookGui(player)) {
                                A.setCancelled(true);
                                Cancelled = true;
                            }
                        }
                        if (Cancelled){ return; }
                        if (main.gui.get(player) == null){
                            main.PlayerS(player);
                            player.openInventory(MFKJ.GetMainGui());
                        }else{
                            player.openInventory(main.gui.get(player));
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void CloseGui(InventoryCloseEvent A){
        if (A.getInventory().getTitle().contains(main.GuiTitle)) {
            Player player = (Player) A.getPlayer();
            main.gui.put(player, A.getInventory());
            main.PlayerS(player);
        }
    }
}
