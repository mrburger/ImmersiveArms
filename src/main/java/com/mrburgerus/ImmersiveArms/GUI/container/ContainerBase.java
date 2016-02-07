package com.mrburgerus.ImmersiveArms.gui.container;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public  abstract class ContainerBase extends Container
{
    //fields
    public static final int INVROWS = 3;
    public static final int INVCOLS = 9;

    //methods
    @Override
    protected boolean mergeItemStack(ItemStack itemStack, int slotMin, int slotMax, boolean ascending)
    {
        boolean slotFound = false;
        int slotIndex = slotMin;
        if (ascending)
            slotIndex = slotMax - 1;
        Slot slot;
        ItemStack stackSlot;

        if (itemStack.isStackable())
        {
            while (itemStack.stackSize > 0 && (!ascending && slotIndex < slotMax || ascending && slotIndex >= slotMin))
            {
                slot = (Slot) this.inventorySlots.get(slotIndex);
                stackSlot = slot.getStack();

                if (slot.isItemValid(itemStack))
                {
                    int combinedStackSize = stackSlot.stackSize + itemStack.stackSize;
                    int slotStackSizeLimit = Math.min(stackSlot.getMaxStackSize(), slot.getSlotStackLimit());

                    if (combinedStackSize <= slotStackSizeLimit)
                    {
                        itemStack.stackSize = 0;
                        stackSlot.stackSize = combinedStackSize;
                        slot.onSlotChanged();
                        slotFound = true;
                    }
                    else if (stackSlot.stackSize < slotStackSizeLimit)
                    {
                        itemStack.stackSize -= slotStackSizeLimit - stackSlot.stackSize;
                        stackSlot.stackSize = slotStackSizeLimit;
                        slot.onSlotChanged();
                        slotFound = true;
                    }
                }

                slotIndex += ascending ? -1 : 1;

            }

        }
        return slotFound;
    }

}
