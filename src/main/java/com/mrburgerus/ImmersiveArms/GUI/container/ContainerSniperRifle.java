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
    private static final int invStart = InventorySniperRifle.invSize, invEnd = invStart + 26,
            hotStart = invEnd + 1, hotEnd = hotStart + 8;

    //constructors
    public ContainerSniperRifle(EntityPlayer player, InventoryPlayer inventoryPlayer, InventorySniperRifle inventorySniper) {
        this.entityPlayer = player;
        this.inventorySniperRifle = inventorySniper;

        this.addSlotToContainer(new Slot50(inventorySniperRifle, 0, 80, 26));

        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < INVROWS; ++inventoryRowIndex)
        {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < INVCOLS; ++inventoryColumnIndex)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 8 + inventoryColumnIndex * 18, 79 + inventoryRowIndex * 18));
            }
        }

        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < INVCOLS; ++actionBarSlotIndex)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 137));
        }
    }

    //methods
    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }

    @Override
    public ItemStack slotClick(int slot, int button, int flag, EntityPlayer player) {
        if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItem()) {
            return null;
        }
        return super.slotClick(slot, button, flag, player);
    }

    @Override
    protected boolean mergeItemStack(ItemStack stack, int start, int end, boolean backwards) {
        boolean flag1 = false;
        int k = (backwards ? end - 1 : start);
        Slot slot;
        ItemStack itemstack1;

        if (stack.isStackable()) {
            while (stack.stackSize > 0 && (!backwards && k < end || backwards && k >= start)) {
                slot = (Slot) inventorySlots.get(k);
                itemstack1 = slot.getStack();

                if (!slot.isItemValid(stack)) {
                    k += (backwards ? -1 : 1);
                    continue;
                }

                if (itemstack1 != null && itemstack1.getItem() == stack.getItem() &&
                        (!stack.getHasSubtypes() || stack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(stack, itemstack1)) {
                    int l = itemstack1.stackSize + stack.stackSize;

                    if (l <= stack.getMaxStackSize() && l <= slot.getSlotStackLimit()) {
                        stack.stackSize = 0;
                        itemstack1.stackSize = l;
                        inventorySniperRifle.markDirty();
                        flag1 = true;
                    } else if (itemstack1.stackSize < stack.getMaxStackSize() && l < slot.getSlotStackLimit()) {
                        stack.stackSize -= stack.getMaxStackSize() - itemstack1.stackSize;
                        itemstack1.stackSize = stack.getMaxStackSize();
                        inventorySniperRifle.markDirty();
                        flag1 = true;
                    }
                }

                k += (backwards ? -1 : 1);
            }
        }
        if (stack.stackSize > 0) {
            k = (backwards ? end - 1 : start);
            while (!backwards && k < end || backwards && k >= start) {
                slot = (Slot) inventorySlots.get(k);
                itemstack1 = slot.getStack();

                if (!slot.isItemValid(stack)) {
                    k += (backwards ? -1 : 1);
                    continue;
                }

                if (itemstack1 == null) {
                    int l = stack.stackSize;
                    if (l <= slot.getSlotStackLimit()) {
                        slot.putStack(stack.copy());
                        stack.stackSize = 0;
                        inventorySniperRifle.markDirty();
                        flag1 = true;
                        break;
                    } else {
                        putStackInSlot(k, new ItemStack(stack.getItem(), slot.getSlotStackLimit(), stack.getItemDamage()));
                        stack.stackSize -= slot.getSlotStackLimit();
                        inventorySniperRifle.markDirty();
                        flag1 = true;
                    }
                }

                k += (backwards ? -1 : 1);
            }
        }

        return flag1;
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int index) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < invStart)
            {
                if (!this.mergeItemStack(itemstack1, invStart, hotEnd + 1, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else
            {
                if (index >= invStart)
                {
                    if (!this.mergeItemStack(itemstack1, 0, invStart, false))
                    {
                        return null;
                    }
                }

            }

        }
        return itemstack;
    }
}
