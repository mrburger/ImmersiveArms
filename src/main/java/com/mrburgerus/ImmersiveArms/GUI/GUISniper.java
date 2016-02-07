package com.mrburgerus.ImmersiveArms.gui;

import blusunrize.immersiveengineering.client.ClientUtils;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.lwjgl.opengl.GL11;

public class GuiSniper extends GuiContainer
{
    //fields
    public static final int INV_NUM = 0;
    private float xSize2;
    private float ySize2;
    //private final InventorySniper inventorySniper;

    public GuiSniper(ContainerSniper con)
    {
        super(con);
    }

    //methods
    public void drawScreen(int par1, int par2, float par3)
    {
        super.drawScreen(par1, par2, par3);
        this.xSize2 = (float)par1;
        this.ySize2= (float)par2;
    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        ClientUtils.bindTexture("immersiveengineering:textures/gui/arcFurnace.png");
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }


}
