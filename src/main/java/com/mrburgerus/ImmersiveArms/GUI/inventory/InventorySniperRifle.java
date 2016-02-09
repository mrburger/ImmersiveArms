package com.mrburgerus.ImmersiveArms.gui.inventory;

import com.mrburgerus.ImmersiveArms.item.items.ItemBullet50;
import com.mrburgerus.ImmersiveArms.item.items.ItemSniperRifle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventorySniperRifle implements IInventory
{
    //fields
    public ItemStack parItemStack;
    public static int invSize = 1;
    public ItemStack[] inventory = new ItemStack[invSize];
    protected String cName = "SniperRifle";
    public int invLim;

    //constructors
    public InventorySniperRifle(ItemStack itemStack)
    {
        parItemStack = itemStack;
        if (!parItemStack.hasTagCompound())
            parItemStack.setTagCompound(new NBTTagCompound());

        readFromNBT(parItemStack.getTagCompound());
    }

    //methods

    @Override
    public int getSizeInventory() {
        return invSize;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {

        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack stack = getStackInSlot(slot);
        if(stack != null)
        {
            if(stack.stackSize > amount)
            {
                stack = stack.splitStack(amount);
                markDirty();
            }
            else
            {
                setInventorySlotContents(slot, null);
            }
        }
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack itemStack = getStackInSlot(slot);
        setInventorySlotContents(slot, null);
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        inventory[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
            itemStack.stackSize = getInventoryStackLimit();

        markDirty();
    }

    @Override
    public String getInventoryName() {
        return cName;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return cName.length() > 0;
    }

    @Override
    public int getInventoryStackLimit() {

        return invLim;
    }

    @Override
    public void markDirty() {
        for (int j = 0; j < getSizeInventory(); j++)
        {
            if (getStackInSlot(j) != null && getStackInSlot(j).stackSize == 0)
                inventory[j] = null;
        }
        writeToNBT(parItemStack.getTagCompound());
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return true;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack itemStack) {
        return (itemStack.getItem() instanceof ItemBullet50);
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        if (nbtTagCompound != null && nbtTagCompound.hasKey(cName))
        {
            if (nbtTagCompound.hasKey(cName))
            {
                NBTTagList tagList = nbtTagCompound.getTagList(cName, 10);
                inventory = new ItemStack[this.getSizeInventory()];
                for (int i = 0; i < tagList.tagCount(); ++i)
                {
                    NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
                    byte slotIndex = tagCompound.getByte("Slot");
                    if (slotIndex >= 0 && slotIndex < inventory.length)
                    {
                        inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
                    }
                }
            }

            if (nbtTagCompound.hasKey("display") && nbtTagCompound.getTag("display").getClass().equals(NBTTagCompound.class))
            {
                if (nbtTagCompound.getCompoundTag("display").hasKey("Name"))
                {
                    cName = nbtTagCompound.getCompoundTag("display").getString("Name");
                }
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex)
        {
            if (inventory[currentIndex] != null)
            {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag(cName, tagList);
    }

}
