package com.mrburgerus.ImmersiveArms.item;

import blusunrize.immersiveengineering.api.tool.IBullet;
import com.mrburgerus.ImmersiveArms.Main;
import com.mrburgerus.ImmersiveArms.entities.EntityBullet50;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;

public class Bullet50 extends Item
{
    //fields

    //constructors
    public Bullet50(String unlocalizedName)
    {
        this.setTextureName(Main.MODID + ":" + unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(Main.immersiveTab);
        this.setMaxStackSize(4);
    }

    //methods
}
