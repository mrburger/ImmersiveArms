package com.mrburgerus.ImmersiveArms.item.items;

import blusunrize.immersiveengineering.api.tool.IInternalStorageItem;
import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import com.mrburgerus.ImmersiveArms.entities.EntityBullet50;
import com.mrburgerus.ImmersiveArms.gui.client.GuiSniperRifle;
import com.mrburgerus.ImmersiveArms.key.KeyBind;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSniperRifle extends ItemWeapon implements IInternalStorageItem
{
    //fields
    public static boolean isChambered = true;
    private static boolean isCount = false;
    private int countDown = 0;
    private int delay = 50;
    //constructors
    public ItemSniperRifle(String unlocalizedName)
    {
        super(unlocalizedName);
    }

    //methods


    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
        boolean canFire = isLoaded(itemstack);

        if (KeyBind.reload.getIsKeyPressed() == true && !world.isRemote)
        {
            System.out.println("OPEN GUI");
            player.openGui(ImmersiveArms.instance, GuiSniperRifle.INVNUM, player.worldObj,(int) player.posX, (int) player.posY, (int) player.posZ);
        }
        else if (isChambered && !world.isRemote)
        {
            if (canFire || player.capabilities.isCreativeMode)
            {
                System.out.println("SHOOTING");
                world.playSoundAtEntity(player, "immersivearms:anti-materiel", .5F, .0000001F);
                world.spawnEntityInWorld(new EntityBullet50(world, player));
                isChambered = false;
            }
        }
        else if (player.capabilities.isCreativeMode || canFire)
        {
            System.out.println("Can Shoot");
            world.playSoundAtEntity(player, "note.hat", .5F, .001F);
        }
        else {
            System.out.println("POOP");
            world.playSoundAtEntity(player, "note.hat", 1F, 1F);
        }

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
    public int getInternalSlots(ItemStack itemStack)
    {
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
