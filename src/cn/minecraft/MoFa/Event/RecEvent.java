package cn.minecraft.MoFa.Event;

import cn.minecraft.MoFa.GuiUi.Button;
import cn.minecraft.MoFa.Item.MFKJ;

import cn.minecraft.MoFa.main;
import org.bukkit.*;
import org.bukkit.block.Chest;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/*玩家合成物品事件*/
public class RecEvent implements Listener{
    @EventHandler
    public void onInteract(PlayerInteractEvent A) {
        if (A.getClickedBlock() == null) return;
        if (!A.getAction().equals(Action.RIGHT_CLICK_BLOCK))return;
        Location l1 = A.getClickedBlock().getLocation();
        Location l2 = A.getClickedBlock().getLocation();
        Location l3 = A.getClickedBlock().getLocation();

        Location l4 = A.getClickedBlock().getLocation();
        Location l5 = A.getClickedBlock().getLocation();
        Location l6 = A.getClickedBlock().getLocation();

        Location l7 = A.getClickedBlock().getLocation();
        Location l8 = A.getClickedBlock().getLocation();
        Location l9 = A.getClickedBlock().getLocation();

        List<Location> list = new ArrayList<Location>();
        Location chest = null;
        Location dis = null;

        /**Z**/
        l1 = A.getClickedBlock().getLocation().clone();
        l1.setY(l1.getY() + 1);
        l1.setZ(l1.getZ() - 1);
        l2 = A.getClickedBlock().getLocation().clone();
        l2.setY(l2.getY() + 1);
        l3 = A.getClickedBlock().getLocation().clone();
        l3.setY(l3.getY() + 1);
        l3.setZ(l3.getZ() + 1);

        l4 = A.getClickedBlock().getLocation().clone();
        l4.setZ(l4.getZ() - 1);
        l5 = A.getClickedBlock().getLocation().clone();
        l6 = A.getClickedBlock().getLocation().clone();
        l6.setZ(l6.getZ() + 1);

        l7 = A.getClickedBlock().getLocation().clone();
        l7.setY(l7.getY() - 1);
        l7.setZ(l7.getZ() - 1);
        l8 = A.getClickedBlock().getLocation().clone();
        l8.setY(l8.getY() - 1);
        l9 = A.getClickedBlock().getLocation().clone();
        l9.setY(l9.getY() - 1);
        l9.setZ(l9.getZ() + 1);

        list.add(l1.getBlock().getLocation());
        list.add(l2.getBlock().getLocation());
        list.add(l3.getBlock().getLocation());
        list.add(l4.getBlock().getLocation());
        list.add(l5.getBlock().getLocation());
        list.add(l6.getBlock().getLocation());
        list.add(l7.getBlock().getLocation());
        list.add(l8.getBlock().getLocation());
        list.add(l9.getBlock().getLocation());

        if (MFKJ.isPluginRecl(list) != null) {
            List<ItemStack> zb = MFKJ.ZButton.get(Button.DIS);
            //判断是否为机器类型
            for (int i1 = 0; i1 < zb.size(); i1++) {
                boolean isdis = zb.get(i1).equals(MFKJ.isPluginRecl(list));
                if (isdis) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).getBlock().getType().equals(Material.CHEST)) {
                            chest = list.get(j);
                        }
                        if (list.get(j).getBlock().getType().equals(Material.DISPENSER)) {
                            dis = list.get(j);
                        }
                    }
                    if (chest == null || dis == null) {

                    } else {
                        A.setCancelled(true);
                        rec(MFKJ.isPluginRecl(list), chest, dis, A.getPlayer());
                        return;
                    }
                }
            }
        }else{ list.clear(); }



        l1 = A.getClickedBlock().getLocation().clone();l1.setY(l1.getY()+1);l1.setX(l1.getX()-1);
        l2 = A.getClickedBlock().getLocation().clone();l2.setY(l2.getY()+1);
        l3 = A.getClickedBlock().getLocation().clone();l3.setY(l3.getY()+1);l3.setX(l3.getX()+1);

        l4 = A.getClickedBlock().getLocation().clone();l4.setZ(l4.getX()-1);
        l5 = A.getClickedBlock().getLocation().clone();
        l6 = A.getClickedBlock().getLocation().clone();l6.setZ(l6.getX()+1);

        l7 = A.getClickedBlock().getLocation().clone();l7.setY(l7.getY()-1);l7.setX(l7.getX()-1);
        l8 = A.getClickedBlock().getLocation().clone();l8.setY(l8.getY()-1);
        l9 = A.getClickedBlock().getLocation().clone();l9.setY(l9.getY()-1);l9.setX(l9.getX()+1);



        list.add(l1.getBlock().getLocation());
        list.add(l2.getBlock().getLocation());
        list.add(l3.getBlock().getLocation());
        list.add(l4.getBlock().getLocation());
        list.add(l5.getBlock().getLocation());
        list.add(l6.getBlock().getLocation());
        list.add(l7.getBlock().getLocation());
        list.add(l8.getBlock().getLocation());
        list.add(l9.getBlock().getLocation());


        if (MFKJ.isPluginRecl(list) != null) {
            List<ItemStack> zb = MFKJ.ZButton.get(Button.DIS);
            //判断是否为机器类型
            for (int i1 = 0; i1 < zb.size(); i1++) {
                boolean isdis = zb.get(i1).equals(MFKJ.isPluginRecl(list));
                if (isdis) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).getBlock().getType().equals(Material.CHEST)) {
                            chest = list.get(j);
                        }
                        if (list.get(j).getBlock().getType().equals(Material.DISPENSER)) {
                            dis = list.get(j);
                        }
                    }
                    if (chest == null || dis == null) {
                        return;
                    } else {
                        A.setCancelled(true);
                        boolean Cancelled = false;
                        for (int i = 0; i < MFKJ.EventAll.size(); i++) {//传递数据至开发者区
                            if (MFKJ.EventAll.get(i).PlayerOpenMac(MFKJ.isPluginRecl(list),A.getPlayer())){
                                Cancelled = true;
                            }
                        }
                        if (Cancelled){ return; }/**判断是否取消事件**/

                        rec(MFKJ.isPluginRecl(list), chest, dis, A.getPlayer());
                        return;
                    }
                }
            }
        }
    }

    public void rec(ItemStack item, Location chestlocation,Location dispenserlocation, Player p){/*某机器触发了合成 传递机器物品、存放箱子、合成物品获取位置、玩家 至本子程序*/
        boolean Cancelled = false;
        if (dispenserlocation == null){ return; }
        if (chestlocation == null){ return; }
        if (dispenserlocation.getBlock().getState() instanceof Dispenser){//判断是否为发射器
            Dispenser dispenser = (Dispenser) Bukkit.getWorld(dispenserlocation.getWorld().getName()).getBlockAt(dispenserlocation).getState();//强制转换为发射器
            List<ItemStack> ItemStackList = new ArrayList<ItemStack>();
            Inventory Inv = dispenser.getInventory();

            for (int count = 0; count < 9; count++) {
                ItemStack itemStack = Inv.getItem(count);
                if (itemStack == null) {
                    ItemStackList.add(new ItemStack(Material.AIR));
                } else {
                    ItemStackList.add(itemStack);
                }
            }

            if (MFKJ.isPluginRec(ItemStackList) != null) {//判断是否为插件注册物品的合成方式

                //=====
                for (int i = 0; i < MFKJ.EventAll.size(); i++) {//传递数据至开发者区
                    if (MFKJ.EventAll.get(i).PlayerRecEvents(MFKJ.isPluginRec(ItemStackList),p)){
                        Cancelled = true;
                    }
                }
                if (Cancelled){ return; }/**判断是否取消事件**/
                //=====
                if (MFKJ.isPluginRec(ItemStackList) != null) {
                    for (int jc = 0; jc < 9; jc++) { //从0开始 0-8 计次循环
                        ItemStack itemStack = Inv.getItem(jc);
                        if (itemStack != null) {
                            ItemStack RecItem = Inv.getItem(jc);
                            if (RecItem.getAmount() > 1){
                                RecItem.setAmount(RecItem.getAmount()-1);
                            }else{
                                Inv.clear(jc);
                            }
                        }
                    }
                    ItemStack itemStack = MFKJ.isPluginRec(ItemStackList);

                    Chest chest = (Chest) Bukkit.getWorld(chestlocation.getWorld().getName()).getBlockAt(chestlocation).getState();
                    if (chest instanceof Chest){
                        Inventory ChestInv = chest.getInventory();
                        if (!ChestInv.addItem(itemStack).isEmpty()){
                            Location location1 = chest.getLocation().clone();
                            chestlocation.setY(chestlocation.getY()+1);
                            Bukkit.getWorld(chest.getLocation().getWorld().getName()).dropItem(location1,itemStack);
                            p.playEffect(chestlocation, Effect.HAPPY_VILLAGER,10);
                            p.playSound(p.getLocation(), Sound.EXPLODE, 1, 1);
                            p.sendRawMessage(main.GetMessage("§4箱子未找到空位子§a["+itemStack.getItemMeta().getDisplayName()+" × "+itemStack.getAmount()+"§a]§4掉出来了"));
                            return;
                        }else{
                            p.sendRawMessage(main.GetMessage("§e恭喜你获得了§a["+itemStack.getItemMeta().getDisplayName()+" × "+itemStack.getAmount()+"§a]"));
                            p.playEffect(chestlocation, Effect.HAPPY_VILLAGER,10);
                            p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1, 1);
                            return;
                        }
                    }
                }
            }
            p.sendRawMessage(main.GetMessage("§4没有找到该合成方式,请对应使用正确的合成方式进行"+"§f["+item.getItemMeta().getDisplayName()+"§f]"));
        }
    }
}
