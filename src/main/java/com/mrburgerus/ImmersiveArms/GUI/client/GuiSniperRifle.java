package com.mrburgerus.ImmersiveArms.gui.client;

import com.mrburgerus.ImmersiveArms.gui.container.ContainerSniperRifle;
import com.mrburgerus.ImmersiveArms.gui.inventory.InventorySniperRifle;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class GuiSniperRifle extends GuiContainer
{
    //fields
    private final ItemStack parentItemStack;
    private final InventorySniperRifle inventorySniper;
    public static final int INVNUM = 0;

    //constructors
    public GuiSniperRifle(EntityPlayer entityPlayer, InventorySniperRifle inventorySniperRifle)
    {
        super(new ContainerSniperRifle(entityPlayer, entityPlayer.inventory, inventorySniperRifle));

        this.parentItemStack = inventorySniperRifle.parItemStack;
        this.inventorySniper = inventorySniperRifle;
    }
    //methods
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

    }
}
