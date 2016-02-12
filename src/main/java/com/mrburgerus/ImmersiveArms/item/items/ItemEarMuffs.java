package com.mrburgerus.ImmersiveArms.item.items;

import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEarMuffs extends ItemArmor {
    //fields


    //constructors
    public ItemEarMuffs(String unlocalizedName, ArmorMaterial mat, int type) {
        super(mat, 0, type);
        this.setCreativeTab(ImmersiveArms.immersiveTab);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(ImmersiveArms.MODID + ":" + unlocalizedName);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {

    }


}
