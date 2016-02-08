package com.mrburgerus.ImmersiveArms.item.items;

import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import net.minecraft.item.Item;

public class ItemBullet50Case extends Item
{
    //fields

    //constructors
    public ItemBullet50Case(String unlocalizedName)
    {
        this.setTextureName(ImmersiveArms.MODID + ":" + unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(ImmersiveArms.immersiveTab);
        this.setMaxStackSize(32);
    }

    //methods

    @Override
    public boolean isFull3D()
    {
        return true;
    }
}
