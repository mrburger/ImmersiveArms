package com.mrburgerus.ImmersiveArms.item;

import blusunrize.immersiveengineering.api.tool.IBullet;
import blusunrize.immersiveengineering.api.tool.IInternalStorageItem;
import blusunrize.immersiveengineering.common.gui.IESlot;
import blusunrize.immersiveengineering.common.items.ItemUpgradeableTool;
import com.mrburgerus.ImmersiveArms.Main;
import com.mrburgerus.ImmersiveArms.entities.EntityBullet50;
import com.mrburgerus.ImmersiveArms.gui.GuiSniper;
import com.mrburgerus.ImmersiveArms.gui.InventorySniper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSniperRifle extends ItemWeapon implements IInternalStorageItem
{
    //fields

    //consturctors
    public ItemSniperRifle(String unlocalizedName)
    {
        super(unlocalizedName);
    }

    //methods
    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
        if (!world.isRemote && player.isSneaking())
        {
            player.openGui(Main.instance, GuiSniper.INV_NUM, world, (int) player.posX, (int) player.posY, (int) player.posZ);
            System.out.println("HEY!");
        }
        else if (!world.isRemote && player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(Items.bullet50))
        {
            world.playSoundAtEntity(player, "random.pop", 1F, .0000001F);
            world.spawnEntityInWorld(new EntityBullet50(world, player));
        }
        else
            world.playSoundAtEntity(player, "random.pop", 1F, 10F);

        return itemstack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 1;
    }


    @Override
    public ItemStack[] getContainedItems(ItemStack itemStack) {
        return new ItemStack[0];
    }

    @Override
    public void setContainedItems(ItemStack itemStack, ItemStack[] itemStacks) {

    }

    @Override
    public int getInternalSlots(ItemStack itemStack) {
        return 0;
    }
}
