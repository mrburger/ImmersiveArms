package com.mrburgerus.ImmersiveArms.item;

import blusunrize.immersiveengineering.api.tool.IInternalStorageItem;
import com.mrburgerus.ImmersiveArms.entities.EntityBullet50;
import com.mrburgerus.ImmersiveArms.gui.InventorySniper;
import com.mrburgerus.ImmersiveArms.key.KeyHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSniperRifle extends ItemWeapon implements IInternalStorageItem
{
    //fields
    public static boolean isChambered = true;
    private static boolean isCount = false;
    private int countDown = 0;
    private int delay = 35;
    //constructors
    public ItemSniperRifle(String unlocalizedName)
    {
        super(unlocalizedName);
    }

    //methods


    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {

        if (isChambered && !world.isRemote)
        {
            if (player.capabilities.isCreativeMode || isLoaded(itemstack))
            {
                world.playSoundAtEntity(player, "immersivearms:anti-materiel", .5F, .0000001F);
                world.spawnEntityInWorld(new EntityBullet50(world, player));
                isChambered = false;
            }
        }
        else if (player.capabilities.isCreativeMode || isLoaded(itemstack))
            world.playSoundAtEntity(player, "note.hat", .5F, .001F);
        else
            world.playSoundAtEntity(player, "note.hat", 1F, 1F);

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

    public boolean isLoaded(ItemStack itemStack) {
        ItemStack[] items = this.getContainedItems(itemStack);
        for (int j = 0; j < items.length; j++) {
            if (items[j].getItem() instanceof ItemBullet50)
                return true;
        }
        return false;
    }

    public static void rechamberCountDown()
    {
        isCount = true;
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int i1, boolean b1)
    {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        if (isCount)
            countDown++;
        if (countDown <= 3 && isCount)
             world.playSoundAtEntity(player, "immersivearms:reload", 10F, 1F);
        if (countDown == delay) {
            isChambered = true;
            isCount = false;
            countDown = 0;
        }

    }
}
