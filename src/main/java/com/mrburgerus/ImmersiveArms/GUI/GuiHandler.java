package com.mrburgerus.ImmersiveArms.gui;

import com.mrburgerus.ImmersiveArms.gui.client.GuiSniperRifle;
import com.mrburgerus.ImmersiveArms.gui.container.ContainerSniperRifle;
import com.mrburgerus.ImmersiveArms.gui.inventory.InventorySniperRifle;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        System.out.println("SERVER CALLED");
        if (ID == GuiSniperRifle.INVNUM)
        {
            System.out.println("SERVER INV");
            return new ContainerSniperRifle(player, player.inventory, new InventorySniperRifle(player.getHeldItem()));
        }
        else
            return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        System.out.println("CLIENT CALLED");
        if (ID == GuiSniperRifle.INVNUM)
        {
            System.out.println("CLIENT INV");
            return new GuiSniperRifle(player, new InventorySniperRifle(player.getHeldItem()));
        }

        return null;
    }
}
