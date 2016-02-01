package com.mrburgerus.ImmersiveArms;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = Main.MODID, version = Main.VERSION, dependencies = "required-after:ImmersiveEngineering")

public class Main
{
    public static final String MODID = "immersivearms";
    public static final String VERSION = "0.1";

    public static CreativeTabs immersiveTab = new CreativeTabs("immersivearms")
    {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return new ItemStack(Blocks.dirt).getItem();
        }
    };

    @SidedProxy(clientSide="com.mrburgerus.ImmersiveArms.ClientProxy", serverSide="com.mrburgerus.ImmersiveArms.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        proxy.preInit(e);
        System.out.println("SICK GUITAR SOLO");
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
    }
}