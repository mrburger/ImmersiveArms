package com.mrburgerus.ImmersiveArms.gui;

import com.mrburgerus.ImmersiveArms.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSniper extends Container {
    //fields
    private static InventorySniper sniper;
    private static final int invStart = InventorySniper.invSize;
    private static final int invEnd = invStart + 26;
    private static final int hotStart = invEnd + 1;
    private static final int hotEnd = hotStart + 8;

    //constructors
    public ContainerSniper (EntityPlayer player, InventoryPlayer inventoryPlayer, InventorySniper inventorySniper)
    {
        this.sniper = inventorySniper;
        this.addSlotToContainer(new Slot50(this.sniper, 0, 80, 80));

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 9; j++)
                addSlotToContainer(new Slot(inventoryPlayer, j+i*9+9, 8+j*18, 126+i*18));
        for (int i = 0; i < 9; i++)
            addSlotToContainer(new Slot(inventoryPlayer, i, 8+i*18, 184));

    }

    //methods
    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int index)
    {
        ItemStack item = null;
        Slot slotInd = (Slot) this.inventorySlots.get(index);




        return item;
    }
}
