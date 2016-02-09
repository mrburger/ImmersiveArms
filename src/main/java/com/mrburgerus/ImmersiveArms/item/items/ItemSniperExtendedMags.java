package com.mrburgerus.ImmersiveArms.item.items;

import com.google.common.collect.ImmutableSet;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Set;

public class ItemSniperExtendedMags extends ItemUpgrade
{
    //fields

    //constructors
    public ItemSniperExtendedMags(String unlocalizedName)
    {
        super(unlocalizedName);
    }


    //methods
    @Override
    public Set<String> getUpgradeTypes(ItemStack itemStack) {
        return ImmutableSet.of("SNIPER");
    }

    @Override
    public boolean canApplyUpgrades(ItemStack target, ItemStack upgrade) {
        return (target.getItem() instanceof ItemSniperRifle);
    }

    @Override
    public void applyUpgrades(ItemStack itemStack, ItemStack itemStack1, HashMap<String, Object> upgradeThing) {
        upgradeThing.put("sniperMags", true);
    }


}
