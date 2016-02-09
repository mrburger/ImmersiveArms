package com.mrburgerus.ImmersiveArms.item.items;

import blusunrize.immersiveengineering.api.tool.IInternalStorageItem;
import blusunrize.immersiveengineering.common.gui.IESlot;
import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import com.mrburgerus.ImmersiveArms.entities.EntityBullet50;
import com.mrburgerus.ImmersiveArms.gui.client.GuiSniperRifle;
import com.mrburgerus.ImmersiveArms.gui.inventory.InventorySniperRifle;
import com.mrburgerus.ImmersiveArms.key.KeyBind;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSniperRifle extends ItemWeapon
{
    //fields
    public static boolean isChambered = false;
    private static boolean isCount = false;
    private int countDown = 0;
    private int delay = 40;
    boolean canFire;
    public static boolean hasMags;
    //constructors
    public ItemSniperRifle(String unlocalizedName)
    {
        super(unlocalizedName, "SNIPER");
    }

    //methods


    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
        InventorySniperRifle inventorySniperRifle = new InventorySniperRifle(itemstack);
        canFire = isLoaded(inventorySniperRifle);

        if (KeyBind.reload.getIsKeyPressed() == true && !world.isRemote)
        {
            player.openGui(ImmersiveArms.instance, GuiSniperRifle.INVNUM, player.worldObj,(int) player.posX, (int) player.posY, (int) player.posZ);
        }
        else if (!isChambered && !world.isRemote)
        {
            rechamberCountDown();
        }
        else if (isChambered && !world.isRemote)
        {
            if (canFire)
            {
                world.playSoundAtEntity(player, "immersivearms:anti-materiel", .5F, .0000001F);
                world.spawnEntityInWorld(new EntityBullet50(world, player));
                inventorySniperRifle.getStackInSlot(0).stackSize--;
                world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(Items.bullet50Case, 1)));
                inventorySniperRifle.markDirty();
                isChambered = false;
            }
        }
        else if (isChambered)
        {
            System.out.println();
            world.playSoundAtEntity(player, "note.hat", .5F, .001F);
        }
        else if (canFire)
        {
            world.playSoundAtEntity(player, "note.hat", .5F, .001F);
        }
        else {
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
    public boolean canModify(ItemStack stack) {
        return true;
    }

    @Override
    public Slot[] getWorkbenchSlots(Container container, ItemStack stack, IInventory invItem) {
        return new Slot[]
                {
                        new IESlot.Upgrades(container, invItem,0, 80, 32, "SNIPER", stack, true),
                        new IESlot.Upgrades(container, invItem,1, 100, 32, "SNIPER", stack, true),
                };
    }

    @Override
    public int getInternalSlots(ItemStack itemStack) {
        return 2;
    }


    public static void rechamberCountDown()
    {
        isCount = true;
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int i1, boolean b1)
    {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        InventorySniperRifle inventorySniperRifle = new InventorySniperRifle(itemStack);
        boolean shoot = isLoaded(inventorySniperRifle);
        if (isCount && shoot)
            countDown++;
        if (countDown == 1 && isCount && shoot)
             world.playSoundAtEntity(player, "immersivearms:reload", 10F, 1F);
        if (countDown == delay) {
            isChambered = true;
            isCount = false;
            countDown = 0;
        }
    }

    public static boolean isLoaded(InventorySniperRifle inventorySniperRifle)
    {
        if (inventorySniperRifle.getStackInSlot(0) != null && inventorySniperRifle.getStackInSlot(0).getItem() instanceof ItemBullet50)
            return true;
        else
            return false;
    }

    @Override
    public boolean isFull3D() {
        return true;
    }
}
