package com.mrburgerus.ImmersiveArms.GUI;

import blusunrize.immersiveengineering.client.ClientUtils;
import net.minecraft.client.gui.GuiScreen;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import org.lwjgl.opengl.GL11;


public class GUISniper extends GuiContainer
{

    public GUISniper(Container p_i1072_1_) {
        super(p_i1072_1_);
    }



    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        ClientUtils.bindTexture("immersiveengineering:textures/gui/revolver.png");
        this.drawTexturedModalRect(guiLeft,guiTop+77, 0,125, 176,89);
    }
}
