package cn.minecraft.MoFa.Event;

import cn.minecraft.MoFa.RegisterItemAll;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

public class Bs implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent A) {
        Player player = A.getPlayer();
        if (A.isCancelled() == true) { return; }
        if (A.getBlock().getType().equals(Material.IRON_ORE)) {//铁星石 掉落
            Random random = new Random();
            int Count = random.nextInt(100);
            if (Count < 7) {
                player.playEffect(A.getBlock().getLocation(), Effect.HAPPY_VILLAGER, 1);
                A.getBlock().getWorld().dropItem(A.getBlock().getLocation(), RegisterItemAll.Bs1());
            }
        }
        if (A.getBlock().getType().equals(Material.GOLD_ORE)) {//铁星石 掉落
            Random random = new Random();
            int Count = random.nextInt(100);
            if (Count < 5) {
                player.playEffect(A.getBlock().getLocation(), Effect.HAPPY_VILLAGER, 1);
                A.getBlock().getWorld().dropItem(A.getBlock().getLocation(), RegisterItemAll.Bs2());
            }
        }
        if (A.getBlock().getType().equals(Material.DIAMOND_ORE)) {//蓝星石 掉落
            Random random = new Random();
            int Count = random.nextInt(100);
            if (Count < 10) {
                player.playEffect(A.getBlock().getLocation(), Effect.HAPPY_VILLAGER, 1);
                A.getBlock().getWorld().dropItem(A.getBlock().getLocation(), RegisterItemAll.Bs3());
            }
        }
        if (A.getBlock().getType().equals(Material.GLOWING_REDSTONE_ORE)) {//红能石 掉落
            Random random = new Random();
            int Count = random.nextInt(100);
            if (Count < 25) {
                player.playEffect(A.getBlock().getLocation(), Effect.HAPPY_VILLAGER, 1);
                A.getBlock().getWorld().dropItem(A.getBlock().getLocation(), RegisterItemAll.Bs4());
            }
        }
    }
}
