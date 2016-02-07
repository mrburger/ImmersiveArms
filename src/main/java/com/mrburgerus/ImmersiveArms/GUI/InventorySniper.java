package com.mrburgerus.ImmersiveArms.gui;

import blusunrize.immersiveengineering.common.items.ItemBullet;
import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class InventorySniper implements IInventory
{
    //fields
    private String name = "Sniper Rifle";
    private final ItemStack invItem;
    public static final int invSize = 10;
    private ItemStack[] inventory = new ItemStack[invSize];
    private String tagName = ImmersiveArms.MODID + "SniperInventory";

    //constructors
    public InventorySniper(ItemStack itemStack)
    {
        invItem = itemStack;
        if (!itemStack.hasTagCompound())
        {
            invItem.setTagCompound(new NBTTagCompound());
        }

        readFromNBT(invItem.getTagCompound());
    }

    //methods
    @Override
    public int getSizeInventory()
    {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt)
    {
        if(this.inventory[slot] != null){
            ItemStack itemstack;

            if(this.inventory[slot].stackSize <= slot){
                itemstack = this.inventory[slot];
                this.inventory[slot] = null;
                return itemstack;
            }else{
                itemstack = this.inventory[slot].splitStack(slot);

                if(this.inventory[slot].stackSize == 0){
                    this.inventory[slot] = null;
                }

                return itemstack;
            }
        }else{
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack itemStack = getStackInSlot(slot);
        setInventorySlotContents(slot, null);
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        inventory[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
            itemStack.stackSize = getInventoryStackLimit();

        markDirty();
    }

    @Override
    public String getInventoryName()
    {
        return name;
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return name.length() > 0;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 6;
    }

    @Override
    public void markDirty()
    {
        for (int j = 0; j < getSizeInventory(); j++)
        {
            if (getStackInSlot(j) != null && getStackInSlot(j).stackSize == 0)
                inventory[j] = null;
        }
        writeToNBT(invItem.getTagCompound());
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        return true;
    }

    @Override
    public void openInventory()
    {

    }

    @Override
    public void closeInventory()
    {
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack)
    {
        return (itemStack.getItem() instanceof ItemBullet);
    }

    public void readFromNBT(NBTTagCompound tagCompound)
    {
        NBTTagList list = tagCompound.getTagList(tagName, Constants.NBT.TAG_COMPOUND);

        for (int j = 0; j < list.tagCount(); j++)
        {
            NBTTagCompound item = (NBTTagCompound) list.getCompoundTagAt(j);
            int slot = item.getInteger("Slot");

            if (slot >= 0 && slot < getSizeInventory())
                setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));

        }
    }

    public void writeToNBT(NBTTagCompound tagcompound)
    {
        NBTTagList nbttaglist = tagcompound.getTagList(tagName, Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < this.getSizeInventory(); ++i)
        {
            if (this.getStackInSlot(i) != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                this.getStackInSlot(i).writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        tagcompound.setTag(tagName, nbttaglist);
    }
}
