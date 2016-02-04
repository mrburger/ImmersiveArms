package com.mrburgerus.ImmersiveArms.item;

import blusunrize.immersiveengineering.api.tool.IUpgrade;
import blusunrize.immersiveengineering.api.tool.IUpgradeableTool;
import blusunrize.immersiveengineering.common.gui.IESlot;
import blusunrize.immersiveengineering.common.util.ItemNBTHelper;
import cofh.api.energy.IEnergyContainerItem;
import com.mrburgerus.ImmersiveArms.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.HashMap;

public class ItemLaserRifle extends Item implements IEnergyContainerItem, IUpgradeableTool
{
    int maxEnergy = 100000;
    String upgradeType;

    public ItemLaserRifle(String unlocalizedName)
    {
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(Main.immersiveTab);
        this.setMaxStackSize(1);
        upgradeType = "LASER";
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        player.playSound("immersiveengineering:chargeFast", 1.5f, 1);
        return stack;
    }

    @Override
    public NBTTagCompound getUpgrades(ItemStack itemStack)
    {
        return ItemNBTHelper.getTagCompound(itemStack, "upgrades");
    }

    @Override
    public void clearUpgrades(ItemStack itemStack)
    {
        ItemNBTHelper.remove(itemStack, "upgrades");
    }

    @Override
    public void recalculateUpgrades(ItemStack itemStack)
    {
        clearUpgrades(itemStack);
        ItemStack[] items = getContainedItems(itemStack);
        HashMap<String, Object> upgrade = new HashMap<>();
        for (int j = 0; j < items.length; j++)
        {
            ItemStack i = items[j];
            if (i != null && i.getItem() instanceof IUpgrade)
            {
                IUpgrade up = (IUpgrade) i.getItem();
                if(up.getUpgradeTypes(i).contains(upgradeType) && up.canApplyUpgrades(itemStack, i))
                    up.applyUpgrades(itemStack, i, upgrade);
            }
        }
    }

    @Override
    public boolean canTakeFromWorkbench(ItemStack itemStack)
    {
        return true;
    }

    @Override
    public void removeFromWorkbench(EntityPlayer entityPlayer, ItemStack itemStack)
    {
        ItemStack[] contents = this.getContainedItems(itemStack);
    }

    @Override
    public boolean canModify(ItemStack stack)
    {
        return true;
    }

    @Override
    public Slot[] getWorkbenchSlots(Container container, ItemStack stack, IInventory invItem)
    {
        Slot[] up = new Slot[]
        {
            new IESlot.Upgrades(container, invItem, 0, 80, 32, "LASER", stack, true)
        };
        return up;
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
    public int getInternalSlots(ItemStack itemStack) {
        return 2;
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

    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.bow;
    }
}
