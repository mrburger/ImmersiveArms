package com.mrburgerus.ImmersiveArms.item;

import blusunrize.immersiveengineering.api.tool.IInternalStorageItem;
import blusunrize.immersiveengineering.api.tool.IUpgradeableTool;
import com.mrburgerus.ImmersiveArms.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemWeapon extends Item
{
    //fields

    //constructors
    public ItemWeapon(String unlocalizedName) {
        this.setTextureName(Main.MODID + ":" + unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(Main.immersiveTab);
        this.setMaxStackSize(1);
    }

    //methods
}