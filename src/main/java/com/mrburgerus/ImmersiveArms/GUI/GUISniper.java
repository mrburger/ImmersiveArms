package com.mrburgerus.ImmersiveArms.GUI;

import blusunrize.immersiveengineering.client.ClientUtils;
import net.minecraft.client.gui.GuiScreen;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;


public class GUISniper extends GuiScreen
{
    public static final int GUI_ID = 20;

    public GUISniper()
    {

    }

    @Override
    public void drawScreen(int x, int y, float f) {
        this.drawDefaultBackground();
    }
}
