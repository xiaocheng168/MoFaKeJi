package cn.minecraft.MoFa.API;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class MoFaKeJiListener {
    public boolean PlayerOpenBookGui(Player player){return false;}

    public boolean PlayerItemHeldEvents(ItemStack itemStack, Player player){ return false; }

    public boolean PlayerRecEvents(ItemStack itemStack, Player player){ return false; }

    public boolean PlayerOpenMac(ItemStack itemStack,Player player){
        return false;
    }

}
