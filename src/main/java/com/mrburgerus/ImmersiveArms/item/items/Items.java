package com.mrburgerus.ImmersiveArms.item.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

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
    public static Item earMuffs;
    public static Item vms;
    public static Item scope;

    public static ItemArmor.ArmorMaterial EARMUFFS = EnumHelper.addArmorMaterial("EARMUFFS", -1, new int[]{0, 0, 0, 0}, 0);


    public static final void init()
    {
        GameRegistry.registerItem(sniperRifle = new ItemSniperRifle("sniperRifle"), "sniperRifle");
        GameRegistry.registerItem(bullet50 = new ItemBullet50("bullet50"), "bullet50");
        GameRegistry.registerItem(bullet50Case = new ItemBullet50Case("bullet50Case"), "bullet50Case");
        //GameRegistry.registerItem(sniperMags = new ItemSniperExtendedMags("sniperMags"), "sniperMags");
        GameRegistry.registerItem(sniperSuppressor = new ItemSniperSuppressor("snipersuppressor"), "snipersuppressor");
        GameRegistry.registerItem(pistol = new ItemPistol("pistol"), "pistol");
        GameRegistry.registerItem(earMuffs = new ItemEarMuffs("earMuffs", EARMUFFS, 0), "earMuffs");
        GameRegistry.registerItem(vms = new ItemVMS("vmsRifle"), "vmsRifle");
        GameRegistry.registerItem(scope = new ItemVMSScope("vmsScope"), "vmsScope");
    }

}
