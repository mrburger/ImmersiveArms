package com.mrburgerus.ImmersiveArms;

import com.mrburgerus.ImmersiveArms.item.Blocks;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = ImmersiveArms.MODID, version = ImmersiveArms.VERSION, dependencies = "required-after:ImmersiveEngineering")

public class ImmersiveArms
{
    public static final String MODID = "immersivearms";
    public static final String VERSION = "0.1";

    @Mod.Instance(MODID)
    public static ImmersiveArms instance;

    public static CreativeTabs immersiveTab = new CreativeTabs("immersivearms")
    {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return new ItemStack(Blocks.vanadiumOre).getItem();
        }
    };

    @SidedProxy(clientSide="com.mrburgerus.ImmersiveArms.ClientProxy", serverSide="com.mrburgerus.ImmersiveArms.ServerProxy")
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
        proxy.preInit(e);
        System.out.println("SICK GUITAR SOLO");
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {

    }
}
