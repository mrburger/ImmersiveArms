package com.mrburgerus.ImmersiveArms.GUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;

public class ContainerSniper extends Container
{


    public ContainerSniper(InventoryPlayer inventoryPlayer, World world)
    {
        System.out.println("DEBUG");
        bindPlayerInventory(inventoryPlayer);
    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 9; j++)
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 85 + i * 18));

        for (int i = 0; i < 9; i++)
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 143));
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }
}
