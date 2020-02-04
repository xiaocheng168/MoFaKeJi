package cn.minecraft.MoFa.Event;

import cn.minecraft.MoFa.Item.MFKJ;
import cn.minecraft.MoFa.RegisterItemAll;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public class Event implements Listener{
    @EventHandler
    public void onItemHeld(PlayerItemHeldEvent a){//手持物品
        ItemStack itemStack = a.getPlayer().getInventory().getItem(a.getNewSlot());
        if (itemStack == null){ return; }
        if (MFKJ.isPluginItem(itemStack)){
            ItemStack itemStack1 = itemStack.clone();
            itemStack1.setAmount(1);
            for (int i = 0; i < MFKJ.EventAll.size(); i++) {//传递数据至开发者区
                a.setCancelled(MFKJ.EventAll.get(i).PlayerItemHeldEvents(itemStack,a.getPlayer()));
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent A){
        if (A.getItem() == null){ return; }
        if (A.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (A.getItem().equals(RegisterItemAll.Tools1())){ //魔能铁锄
                if (A.getClickedBlock().getType().equals(Material.GRASS) || A.getClickedBlock().getType().equals(Material.DIRT)){

                    Location Mlocation = A.getClickedBlock().getLocation().clone();
                    Mlocation.setX(Mlocation.getX()+1);
                    if (Bukkit.getWorld(Mlocation.getWorld().getName()).getBlockAt(Mlocation).getType().equals(Material.GRASS) || Bukkit.getWorld(Mlocation.getWorld().getName()).getBlockAt(Mlocation).getType().equals(Material.DIRT)) {
                        Bukkit.getWorld(A.getClickedBlock().getWorld().getName()).getBlockAt(Mlocation).setType(Material.SOIL);
                    }

                    Location Mlocation2 = A.getClickedBlock().getLocation().clone();
                    Mlocation2.setX(Mlocation2.getX()-1);
                    if (Bukkit.getWorld(Mlocation2.getWorld().getName()).getBlockAt(Mlocation2).getType().equals(Material.GRASS) || Bukkit.getWorld(Mlocation2.getWorld().getName()).getBlockAt(Mlocation2).getType().equals(Material.DIRT)) {
                        Bukkit.getWorld(A.getClickedBlock().getWorld().getName()).getBlockAt(Mlocation2).setType(Material.SOIL);
                    }

                    Location Mlocation3 = A.getClickedBlock().getLocation().clone();
                    Mlocation3.setZ(Mlocation3.getZ()+1);

                    if (Bukkit.getWorld(Mlocation3.getWorld().getName()).getBlockAt(Mlocation3).getType().equals(Material.GRASS) || Bukkit.getWorld(Mlocation3.getWorld().getName()).getBlockAt(Mlocation3).getType().equals(Material.DIRT)) {
                        Bukkit.getWorld(A.getClickedBlock().getWorld().getName()).getBlockAt(Mlocation3).setType(Material.SOIL);
                    }

                    Location Mlocation4 = A.getClickedBlock().getLocation().clone();
                    Mlocation4.setZ(Mlocation4.getZ()-1);
                    if (Bukkit.getWorld(Mlocation4.getWorld().getName()).getBlockAt(Mlocation4).getType().equals(Material.GRASS) || Bukkit.getWorld(Mlocation4.getWorld().getName()).getBlockAt(Mlocation4).getType().equals(Material.DIRT)) {
                        Bukkit.getWorld(A.getClickedBlock().getWorld().getName()).getBlockAt(Mlocation4).setType(Material.SOIL);
                    }
                }
            }
        }
    }
}
