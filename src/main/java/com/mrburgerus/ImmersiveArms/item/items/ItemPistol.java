package com.mrburgerus.ImmersiveArms.item.items;

import com.mrburgerus.ImmersiveArms.entities.EntityBullet50;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPistol extends ItemWeapon {
    //fields
    boolean canFire = true;

    public ItemPistol(String unlocalizedName) {
        super(unlocalizedName, "PISTOL");
        this.setCreativeTab(null);
    }

    @Override
    public boolean canModify(ItemStack stack) {
        return false;
    }

    @Override
    public Slot[] getWorkbenchSlots(Container container, ItemStack stack, IInventory invItem) {
        return new Slot[0];
    }

    @Override
    public int getInternalSlots(ItemStack itemStack) {
        return 0;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (player.inventory.hasItem(Items.bullet50Case) && canFire && !world.isRemote)
        {
            player.inventory.consumeInventoryItem(Items.bullet50Case);
            world.playSoundAtEntity(player, "immersivearms:anti-materiel", .1F, .0000001F);
            world.spawnEntityInWorld(new EntityBullet50(world, player));
            canFire = false;
        }

        return itemStack;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        canFire = true;
        return super.onEntitySwing(entityLiving, stack);
    }
}
