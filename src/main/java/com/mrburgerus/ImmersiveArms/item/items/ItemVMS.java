package com.mrburgerus.ImmersiveArms.item.items;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by mrburgerUS on 2/12/2016.
 */
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
        return false;
    }

    @Override
    public Slot[] getWorkbenchSlots(Container container, ItemStack stack, IInventory invItem) {
        return new Slot[0];
    }

    @Override
    public int getInternalSlots(ItemStack itemStack) {
        return 0;
    }
}
