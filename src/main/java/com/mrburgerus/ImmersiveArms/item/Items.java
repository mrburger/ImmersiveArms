package com.mrburgerus.ImmersiveArms.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class Items
{
    public static Item laserRifle;
    public static Item laserCapacitor;
    public static Item sniperRifle;
    public static Item bullet50;

    public static final void init()
    {
        //GameRegistry.registerItem(laserRifle = new ItemLaserRifle("laserRifle"), "laserRifle");
        //GameRegistry.registerItem(laserCapacitor = new ItemLaserCapacitor("laserCapacitor"), "laserCapacitor");
        GameRegistry.registerItem(sniperRifle = new ItemSniperRifle("sniperRifle"), "sniperRifle");
        GameRegistry.registerItem(bullet50 = new Bullet50("bullet50"), "bullet50");
    }

}
