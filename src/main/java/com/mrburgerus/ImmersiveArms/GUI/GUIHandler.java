package com.mrburgerus.ImmersiveArms.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GuiSniper.INV_NUM)
        {
            return new ContainerSniper(player, player.inventory, new InventorySniper(player.getHeldItem()));
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GuiSniper.INV_NUM)
        {
            return new GuiSniper(new ContainerSniper(player, player.inventory, new InventorySniper(player.getHeldItem())));
        }
        return null;
    }
}
