package com.mrburgerus.ImmersiveArms.item.items;

import blusunrize.immersiveengineering.api.tool.IInternalStorageItem;
import com.mrburgerus.ImmersiveArms.ClientZoomHandler;
import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import com.mrburgerus.ImmersiveArms.entities.EntityBullet50;
import com.mrburgerus.ImmersiveArms.gui.client.GuiSniperRifle;
import com.mrburgerus.ImmersiveArms.gui.inventory.InventorySniperRifle;
import com.mrburgerus.ImmersiveArms.key.KeyBind;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSniperRifle extends ItemWeapon implements IInternalStorageItem
{
    //fields
    public static boolean isChambered = false;
    private static boolean isCount = false;
    private int countDown = 0;
    private int delay = 40;
    boolean canFire;
    //constructors
    public ItemSniperRifle(String unlocalizedName)
    {
        super(unlocalizedName);
    }

    //methods


    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
        InventorySniperRifle inventorySniperRifle = new InventorySniperRifle(itemstack);
        canFire = isLoaded(inventorySniperRifle);

        if (KeyBind.reload.getIsKeyPressed() == true && !world.isRemote)
        {
            System.out.println("OPEN GUI");
            player.openGui(ImmersiveArms.instance, GuiSniperRifle.INVNUM, player.worldObj,(int) player.posX, (int) player.posY, (int) player.posZ);
        }
        else if (isChambered && !world.isRemote)
        {
            if (canFire)
            {
                System.out.println("SHOOTING");
                world.playSoundAtEntity(player, "immersivearms:anti-materiel", .5F, .0000001F);
                world.spawnEntityInWorld(new EntityBullet50(world, player));
                inventorySniperRifle.getStackInSlot(0).stackSize--;
                inventorySniperRifle.markDirty();
                isChambered = false;
            }
        }
        else if (isChambered)
        {
            System.out.println("Not Loaded, Chambered");
            world.playSoundAtEntity(player, "note.hat", .5F, .001F);
        }
        else if (canFire)
        {
            System.out.println("Can Fire");
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
        if (countDown <= 2 && isCount && shoot)
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
