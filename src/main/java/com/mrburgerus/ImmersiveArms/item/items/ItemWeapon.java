package com.mrburgerus.ImmersiveArms.item.items;

import blusunrize.immersiveengineering.api.tool.IInternalStorageItem;
import blusunrize.immersiveengineering.api.tool.IUpgrade;
import blusunrize.immersiveengineering.api.tool.IUpgradeableTool;
import blusunrize.immersiveengineering.common.util.ItemNBTHelper;
import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.HashMap;

public abstract class ItemWeapon extends Item implements IUpgradeableTool, IInternalStorageItem
{
    //fields
    String upgradeType;

    //constructors
    public ItemWeapon(String unlocalizedName, String upgrade) {
        this.setTextureName(ImmersiveArms.MODID + ":" + unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(ImmersiveArms.immersiveTab);
        this.setMaxStackSize(1);
        upgradeType = upgrade;
    }

    //methods
    @Override
    public NBTTagCompound getUpgrades(ItemStack itemStack) {
        return ItemNBTHelper.getTagCompound(itemStack, "upgrades");
    }

    @Override
    public void clearUpgrades(ItemStack itemStack) 
    {
        ItemNBTHelper.remove(itemStack, "upgrades");
    }

    @Override
    public void recalculateUpgrades(ItemStack itemStack) {
        clearUpgrades(itemStack);
        ItemStack[] inv = getContainedItems(itemStack);
        HashMap<String, Object> map = new HashMap<String, Object>();
        for(int i=0; i<inv.length; i++)//start at 1, 0 is the drill
        {
            ItemStack u = inv[i];
            if(u!=null && u.getItem() instanceof IUpgrade)
            {
                IUpgrade upg = (IUpgrade)u.getItem();
                if(upg.getUpgradeTypes(u).contains(upgradeType) && upg.canApplyUpgrades(itemStack, u))
                    upg.applyUpgrades(itemStack, u, map);
            }
        }
        NBTTagCompound upgradeTag = (NBTTagCompound)getUpgradeBase(itemStack).copy();
        for(String key : map.keySet())
        {
            Object o = map.get(key);
            if(o instanceof Byte)
                upgradeTag.setByte(key, (Byte)o);
            else if(o instanceof byte[])
                upgradeTag.setByteArray(key, (byte[])o);
            else if(o instanceof Boolean)
                upgradeTag.setBoolean(key, (Boolean)o);
            else if(o instanceof Integer)
                upgradeTag.setInteger(key, (Integer)o);
            else if(o instanceof int[])
                upgradeTag.setIntArray(key, (int[])o);
            else if(o instanceof Float)
                upgradeTag.setFloat(key, (Float)o);
            else if(o instanceof Double)
                upgradeTag.setDouble(key, (Double)o);
            else if(o instanceof String)
                upgradeTag.setString(key, (String)o);
        }
        ItemNBTHelper.setTagCompound(itemStack, "upgrades", upgradeTag);
    }

    @Override
    public boolean canTakeFromWorkbench(ItemStack itemStack) {
        return true;
    }

    @Override
    public void removeFromWorkbench(EntityPlayer entityPlayer, ItemStack itemStack) {

    }

    @Override
    public abstract boolean canModify(ItemStack stack);

    @Override
    public abstract Slot[] getWorkbenchSlots(Container container, ItemStack stack, IInventory invItem);

    @Override
    public ItemStack[] getContainedItems(ItemStack itemStack) {
        ItemStack[] stackList = new ItemStack[getInternalSlots(itemStack)];
        if(itemStack.hasTagCompound())
        {
            NBTTagList inv = itemStack.getTagCompound().getTagList("Inv",10);
            for (int i=0; i<inv.tagCount(); i++)
            {
                NBTTagCompound tag = inv.getCompoundTagAt(i);
                int slot = tag.getByte("Slot") & 0xFF;
                if ((slot >= 0) && (slot < stackList.length))
                    stackList[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }
        return stackList;
    }

    @Override
    public void setContainedItems(ItemStack itemStack, ItemStack[] itemStacks) {
        NBTTagList inv = new NBTTagList();
        for (int i = 0; i < itemStacks.length; i++)
            if (itemStacks[i] != null)
            {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte)i);
                itemStacks[i].writeToNBT(tag);
                inv.appendTag(tag);
            }
        if(!itemStack.hasTagCompound())
            itemStack.setTagCompound(new NBTTagCompound());
        itemStack.getTagCompound().setTag("Inv",inv);
    }

    @Override
    public abstract int getInternalSlots(ItemStack itemStack);

    public NBTTagCompound getUpgradeBase(ItemStack stack) {
        return new NBTTagCompound();
    }

}