package com.mrburgerus.ImmersiveArms.gui.container;

import com.mrburgerus.ImmersiveArms.gui.inventory.InventorySniperRifle;
import com.mrburgerus.ImmersiveArms.gui.slot.Slot50;
import com.mrburgerus.ImmersiveArms.item.items.ItemSniperRifle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSniperRifle extends ContainerBase {
    //fields
    private final EntityPlayer entityPlayer;
    public final InventorySniperRifle inventorySniperRifle;

    //constructors
    public ContainerSniperRifle (EntityPlayer player, InventoryPlayer inventoryPlayer, InventorySniperRifle inventorySniper)
    {
        this.entityPlayer = player;
        this.inventorySniperRifle = inventorySniper;

        this.addSlotToContainer(new Slot50(inventorySniperRifle, 0, 80, 26));

        // PLAYER INVENTORY - uses default locations for standard inventory texture file
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // PLAYER ACTION BAR - uses default locations for standard action bar texture file
        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }


    }


    //methods
    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }



}
