package com.mrburgerus.ImmersiveArms;

import com.mrburgerus.ImmersiveArms.gui.GuiHandler;
import com.mrburgerus.ImmersiveArms.item.blocks.Blocks;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = ImmersiveArms.MODID, version = ImmersiveArms.VERSION, dependencies = "required-after:ImmersiveEngineering")

public class ImmersiveArms
{
    //fields
    public static final String MODID = "immersivearms";
    public static final String VERSION = "0.1";

    @Mod.Instance(MODID)
    public static ImmersiveArms instance;



    @SidedProxy(clientSide="com.mrburgerus.ImmersiveArms.ClientProxy",serverSide="com.mrburgerus.ImmersiveArms.CommonProxy")
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

    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler(Minecraft.getMinecraft()));
    }

    public static CreativeTabs immersiveTab = new CreativeTabs("immersivearms")
    {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return new ItemStack(Blocks.vanadiumOre).getItem();
        }
    };
}
