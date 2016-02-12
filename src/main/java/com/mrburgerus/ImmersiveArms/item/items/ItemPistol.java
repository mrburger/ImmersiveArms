package com.mrburgerus.ImmersiveArms.item.items;

import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import com.mrburgerus.ImmersiveArms.entities.EntityBullet50;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ibxm.Player;
import net.java.games.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

import java.util.Map;

public class ItemPistol extends ItemWeapon {
    //fields
    boolean canFire = true;

    public ItemPistol(String unlocalizedName) {
        super(unlocalizedName, "PISTOL");
        this.setCreativeTab(ImmersiveArms.immersiveTab);
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

            world.spawnEntityInWorld(new EntityBullet50(world, player));
            world.playSoundAtEntity(player, "immersivearms:anti-materiel", .1F, .0000001F);



        return itemStack;
    }

    @Override
    public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        if ()
    }
}
