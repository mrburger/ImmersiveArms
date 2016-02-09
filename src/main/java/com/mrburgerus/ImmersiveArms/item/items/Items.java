package com.mrburgerus.ImmersiveArms.item.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class Items
{
    public static Item laserRifle;
    public static Item laserCapacitor;
    public static Item sniperRifle;
    public static Item bullet50;
    public static Item bullet50Case;
    public static Item sniperMags;
    public static Item sniperSuppressor;
    public static Item pistol;

    public static final void init()
    {
        //GameRegistry.registerItem(laserRifle = new ItemLaserRifle("laserRifle"), "laserRifle");
        //GameRegistry.registerItem(laserCapacitor = new ItemLaserCapacitor("laserCapacitor"), "laserCapacitor");
        GameRegistry.registerItem(sniperRifle = new ItemSniperRifle("sniperRifle"), "sniperRifle");
        GameRegistry.registerItem(bullet50 = new ItemBullet50("bullet50"), "bullet50");
        GameRegistry.registerItem(bullet50Case = new ItemBullet50Case("bullet50Case"), "bullet50Case");
        //GameRegistry.registerItem(sniperMags = new ItemSniperExtendedMags("sniperMags"), "sniperMags");
        GameRegistry.registerItem(sniperSuppressor = new ItemSniperSuppressor("snipersuppressor"), "snipersuppressor");
        GameRegistry.registerItem(pistol = new ItemPistol("pistol"), "pistol");
    }

}
