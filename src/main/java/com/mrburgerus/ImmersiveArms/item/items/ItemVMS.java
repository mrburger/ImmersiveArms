package com.mrburgerus.ImmersiveArms.item.items;

import blusunrize.immersiveengineering.common.gui.IESlot;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ItemVMS extends ItemWeapon
{
    //fields

    //constructors
    public ItemVMS(String unlocalizedName)
    {
        super(unlocalizedName, "VMS");
    }

    //methods
    @Override
    public boolean canModify(ItemStack stack) {
        return true;
    }

    @Override
    public Slot[] getWorkbenchSlots(Container container, ItemStack stack, IInventory invItem) {
        return new Slot[]
                {
                        new IESlot.Upgrades(container, invItem, 0, 80, 32, "VMS", stack, true ) {
                        }
                };
    }

    @Override
    public int getInternalSlots(ItemStack itemStack) {
        return 1;
    }

    @Override
    public boolean isFull3D() {
        return true;
    }
}
