package com.mrburgerus.ImmersiveArms.item.items;

import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import net.minecraft.item.ItemArmor;

/**
 * Created by mrburgerUS on 2/10/2016.
 */
public class ItemEarMuffs extends ItemArmor {
    //fields


    //constructors
    public ItemEarMuffs(String unlocalizedName, ArmorMaterial mat, int type) {
        super(mat, 0, type);
        this.setCreativeTab(ImmersiveArms.immersiveTab);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(ImmersiveArms.MODID + ":" + unlocalizedName);
    }
}
