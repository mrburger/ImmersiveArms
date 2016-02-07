package com.mrburgerus.ImmersiveArms.gui;

import blusunrize.immersiveengineering.common.gui.IESlot;
import com.mrburgerus.ImmersiveArms.item.Bullet50;
import com.mrburgerus.ImmersiveArms.item.ItemSniperRifle;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class Slot50 extends Slot
{
    //fields

    //constructors
    public Slot50(IInventory inventory, int index, int xPos, int yPos)
    {
        super(inventory, index, xPos, yPos);
    }

    //methods
    @Override
    public boolean isItemValid(ItemStack itemstack)
    {
        return (itemstack.getItem() instanceof Bullet50);
    }
}
