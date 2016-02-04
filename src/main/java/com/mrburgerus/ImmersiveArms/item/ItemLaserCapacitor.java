package com.mrburgerus.ImmersiveArms.item;

import blusunrize.immersiveengineering.api.tool.IUpgrade;
import blusunrize.immersiveengineering.api.tool.IUpgradeableTool;
import com.google.common.collect.ImmutableSet;
import com.mrburgerus.ImmersiveArms.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Set;

public class ItemLaserCapacitor extends Item implements IUpgrade
{

    public ItemLaserCapacitor(String unlocalizedName)
    {
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Main.MODID + ":" + unlocalizedName);
        this.setCreativeTab(Main.immersiveTab);
        this.setMaxStackSize(1);
    }
    @Override
    public Set<String> getUpgradeTypes(ItemStack upgrade)
    {
        return ImmutableSet.of("LASER");
    }

    @Override
    public boolean canApplyUpgrades(ItemStack itemStack, ItemStack itemStack1)
    {
        if(itemStack.getItem() instanceof IUpgradeableTool)
            return !((IUpgradeableTool) itemStack.getItem()).getUpgrades(itemStack).hasKey("LASER");
        return true;
    }

    @Override
    public void applyUpgrades(ItemStack itemStack, ItemStack up, HashMap<String, Object> hashMap) {
        if (up.getItem() instanceof ItemLaserCapacitor)
        {
            hashMap.put("capacity", true);
        }


    }
}
