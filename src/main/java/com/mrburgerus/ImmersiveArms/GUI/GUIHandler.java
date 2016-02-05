package com.mrburgerus.ImmersiveArms.GUI;

import com.mrburgerus.ImmersiveArms.item.ItemSniperRifle;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GUIHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {


        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (player.getCurrentEquippedItem().getItem() instanceof ItemSniperRifle)
        {
            System.out.println("HELLO!");
            return new ContainerSniper(player.inventory, world);
        }

        return null;
    }
}
