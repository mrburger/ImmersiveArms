package com.mrburgerus.ImmersiveArms;

import com.mrburgerus.ImmersiveArms.item.blocks.Blocks;
import com.mrburgerus.ImmersiveArms.item.items.Items;
import com.mrburgerus.ImmersiveArms.key.KeyBind;
import com.mrburgerus.ImmersiveArms.key.KeyHandler;
import com.mrburgerus.ImmersiveArms.world.GenOres;
import cpw.mods.fml.common.FMLCommonHandler;
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
        FMLCommonHandler.instance().bus().register(new KeyHandler());
        KeyBind.init();


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
