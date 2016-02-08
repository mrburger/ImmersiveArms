package com.mrburgerus.ImmersiveArms.item.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IScoped {
    public boolean canZoom(ItemStack stack, EntityPlayer player);
}
