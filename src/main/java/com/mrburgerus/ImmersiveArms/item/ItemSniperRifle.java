package com.mrburgerus.ImmersiveArms.item;

import blusunrize.immersiveengineering.common.gui.IESlot;
import blusunrize.immersiveengineering.common.items.ItemUpgradeableTool;
import com.mrburgerus.ImmersiveArms.GUI.GUISniper;
import com.mrburgerus.ImmersiveArms.Main;
import cpw.mods.fml.common.Mod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSniperRifle extends ItemUpgradeableTool
{

    public ItemSniperRifle(String unlocalizedName)
    {
        super(unlocalizedName, 1, "SNIPER");
        this.setTextureName(Main.MODID + ":" + unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(Main.immersiveTab);
    }

    @Override
    public boolean canModify(ItemStack itemStack)
    {
        return true;
    }

    @Override
    public Slot[] getWorkbenchSlots(Container container, ItemStack itemStack, IInventory iInventory) {
        return new Slot[]
                {
                        new IESlot.Upgrades(container, iInventory, 0, 80, 32, "SNIPER", itemStack, true),
                        new IESlot.Upgrades(container, iInventory, 1, 100, 32, "SNIPER", itemStack, true),
                };
    }

    @Override
    public int getInternalSlots(ItemStack itemStack)
    {
        return 10;
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (!world.isRemote && player.isSneaking())
        {
            player.openGui(Main.instance, 1, world, (int) player.posX, (int) player.posY, (int) player.posZ);

        }
        return stack;
    }
}
