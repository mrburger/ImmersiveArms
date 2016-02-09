package com.mrburgerus.ImmersiveArms.gui.client;

import blusunrize.immersiveengineering.client.ClientUtils;
import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import com.mrburgerus.ImmersiveArms.item.items.ItemSniperRifle;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

public class GuiZoom extends Gui {
    //fields
    private static final ResourceLocation texture = new ResourceLocation(ImmersiveArms.MODID + ":" + "textures/gui/scope.png");
    private Minecraft minecraft;

    public GuiZoom(Minecraft mc)
    {
        super();
        minecraft = mc;
    }

    @SubscribeEvent()
    public void onRenderOverlayPre(RenderGameOverlayEvent.Pre event)
    {
        if(minecraft.thePlayer.getCurrentEquippedItem() == null)
        {
            return;
        }
        else if (event.type==RenderGameOverlayEvent.ElementType.CROSSHAIRS && minecraft.thePlayer.getHeldItem().getItem() instanceof  ItemSniperRifle && minecraft.thePlayer.isSneaking()) {
            event.setCanceled(true);
            int width = event.resolution.getScaledWidth();
            int height = event.resolution.getScaledHeight();
            int resMin = Math.min(width, height);
            float offsetX = (width-resMin)/2f;
            float offsetY = (height-resMin)/2f;

            if(resMin==width)
            {
                ClientUtils.drawColouredRect(0, 0, width, (int) offsetY + 1, 0xff000000);
                ClientUtils.drawColouredRect(0, (int) offsetY + resMin, width,(int)offsetY + 1, 0xff000000);
            }
            else
            {
                ClientUtils.drawColouredRect(0,0, (int)offsetX + 1,height, 0xff000000);
                ClientUtils.drawColouredRect((int) offsetX + resMin, 0, (int) offsetX + 1, height, 0xff000000);
            }

            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            GL11.glTranslatef(offsetX, offsetY, 0);
            ClientUtils.drawTexturedRect(0, 0, resMin, resMin, 0f, 1f, 0f, 1f);



        }

    }

    @SubscribeEvent()
    public void onFOVUpdate(FOVUpdateEvent event)
    {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        if(player.getCurrentEquippedItem() !=null && player.getCurrentEquippedItem().getItem() instanceof ItemSniperRifle && player.isSneaking())
        {
            event.newfov = 0.1F;
        }
    }

}
