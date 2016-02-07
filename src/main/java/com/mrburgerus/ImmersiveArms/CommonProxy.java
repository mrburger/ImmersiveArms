package com.mrburgerus.ImmersiveArms;

import com.mrburgerus.ImmersiveArms.gui.ContainerSniper;
import com.mrburgerus.ImmersiveArms.gui.GuiSniper;
import com.mrburgerus.ImmersiveArms.gui.InventorySniper;
import com.mrburgerus.ImmersiveArms.item.Blocks;
import com.mrburgerus.ImmersiveArms.item.ItemSniperRifle;
import com.mrburgerus.ImmersiveArms.item.Items;
import com.mrburgerus.ImmersiveArms.key.KeyBind;
import com.mrburgerus.ImmersiveArms.key.KeyHandler;
import com.mrburgerus.ImmersiveArms.world.GenOres;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler
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

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GuiSniper.INV_NUM) {
            System.out.println("WORKING");
            return new ContainerSniper(player, player.inventory, new InventorySniper(player.getHeldItem()));
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }
}
