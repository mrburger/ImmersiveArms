package com.mrburgerus.ImmersiveArms.item.items;

import blusunrize.immersiveengineering.api.tool.IUpgrade;
import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Set;

public abstract class ItemUpgrade extends Item implements IUpgrade
{
    public ItemUpgrade(String unlocalizedName)
    {
        this.setTextureName(ImmersiveArms.MODID + ":" + unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(ImmersiveArms.immersiveTab);
        this.setMaxStackSize(1);
    }

    @Override
    public abstract Set<String> getUpgradeTypes(ItemStack itemStack);

    @Override
    public abstract boolean canApplyUpgrades(ItemStack itemStack, ItemStack itemStack1);

    @Override
    public abstract void applyUpgrades(ItemStack itemStack, ItemStack itemStack1, HashMap<String, Object> hashMap);
}
