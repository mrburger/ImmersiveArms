package com.mrburgerus.ImmersiveArms.item.items;

import com.google.common.collect.ImmutableSet;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Set;

public class ItemSniperSuppressor extends ItemUpgrade
{
    public ItemSniperSuppressor(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    public Set<String> getUpgradeTypes(ItemStack itemStack) {
        return ImmutableSet.of("SNIPER");
    }

    @Override
    public boolean canApplyUpgrades(ItemStack itemStack, ItemStack itemStack1) {
        return (itemStack.getItem() instanceof ItemSniperRifle);
    }

    @Override
    public void applyUpgrades(ItemStack itemStack, ItemStack itemStack1, HashMap<String, Object> hashMap) {
        hashMap.put("sniperSuppressor", true);
    }
}
