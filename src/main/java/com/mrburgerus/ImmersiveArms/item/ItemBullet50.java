package com.mrburgerus.ImmersiveArms.item;

import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import net.minecraft.item.Item;

public class ItemBullet50 extends Item
{
    //fields

    //constructors
    public ItemBullet50(String unlocalizedName)
    {
        this.setTextureName(ImmersiveArms.MODID + ":" + unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(ImmersiveArms.immersiveTab);
        this.setMaxStackSize(8);
    }

    //methods

    @Override
    public boolean isFull3D()
    {
        return true;
    }
}
