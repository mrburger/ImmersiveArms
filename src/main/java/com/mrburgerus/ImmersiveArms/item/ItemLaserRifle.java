package com.mrburgerus.ImmersiveArms.item;

import blusunrize.immersiveengineering.api.tool.IUpgradeableTool;
import cofh.api.energy.IEnergyContainerItem;
import com.mrburgerus.ImmersiveArms.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemLaserRifle extends Item implements IEnergyContainerItem, IUpgradeableTool
{
    int maxEnergy = 100000;

    public ItemLaserRifle(String unlocalizedName)
    {
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(Main.immersiveTab);
        this.setMaxStackSize(1);
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        player.playSound("immersiveengineering:chargeFast", 1.5f, 1);
        return stack;
    }

    @Override
    public NBTTagCompound getUpgrades(ItemStack itemStack) {
        return null;
    }

    @Override
    public void clearUpgrades(ItemStack itemStack)
    {

    }

    @Override
    public void recalculateUpgrades(ItemStack itemStack)
    {

    }

    @Override
    public boolean canTakeFromWorkbench(ItemStack itemStack)
    {
        return false;
    }

    @Override
    public void removeFromWorkbench(EntityPlayer entityPlayer, ItemStack itemStack)
    {

    }

    @Override
    public boolean canModify(ItemStack stack)
    {
        return false;
    }

    @Override
    public Slot[] getWorkbenchSlots(Container container, ItemStack stack, IInventory invItem)
    {
        return new Slot[0];
    }

    @Override
    public ItemStack[] getContainedItems(ItemStack itemStack)
    {
        return new ItemStack[0];
    }

    @Override
    public void setContainedItems(ItemStack itemStack, ItemStack[] itemStacks)
    {

    }

    @Override
    public int getInternalSlots(ItemStack stack)
    {
        return 0;
    }

    @Override
    public int receiveEnergy(ItemStack itemStack, int i, boolean b)
    {
        return 0;
    }

    @Override
    public int extractEnergy(ItemStack itemStack, int i, boolean b)
    {
        int storedE = getEnergyStored(itemStack);
        int extract = Math.min(i, storedE);

        if (!b)
        {
            storedE -= extract;

        }

        return storedE;
    }

    @Override
    public int getEnergyStored(ItemStack itemStack)
    {
        return 0;
    }

    @Override
    public int getMaxEnergyStored(ItemStack itemStack)
    {
        return maxEnergy;
    }

    @Override
    public void setDamage(ItemStack stack, int damage)
    {

        super.setDamage(stack, 0);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.rare;
    }
}
