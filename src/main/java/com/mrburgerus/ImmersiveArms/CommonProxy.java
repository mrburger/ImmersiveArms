package com.mrburgerus.ImmersiveArms;

import com.mrburgerus.ImmersiveArms.item.Blocks;
import com.mrburgerus.ImmersiveArms.item.Items;
import com.mrburgerus.ImmersiveArms.world.GenOres;
import com.sun.deploy.util.SessionState;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        Blocks.init();
        Items.init();
    }

    public void init(FMLInitializationEvent e)
    {
        GameRegistry.registerWorldGenerator(new GenOres(), 0);
        ClientProxy.registerRender();
    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }
}
