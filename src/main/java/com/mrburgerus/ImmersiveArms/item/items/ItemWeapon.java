package com.mrburgerus.ImmersiveArms.item.items;

import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import com.mrburgerus.ImmersiveArms.gui.inventory.InventorySniperRifle;
import net.minecraft.item.Item;

public class ItemWeapon extends Item
{
    //fields

    //constructors
    public ItemWeapon(String unlocalizedName) {
        this.setTextureName(ImmersiveArms.MODID + ":" + unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(ImmersiveArms.immersiveTab);
        this.setMaxStackSize(1);
    }

    //methods

}