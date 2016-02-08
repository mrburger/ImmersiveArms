package com.mrburgerus.ImmersiveArms;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

/**
 * Created by mrburgerUS on 2/7/2016.
 */
public class ClientZoomHandler {
    //fields
    public static boolean isZooming = false;
    //methods
    @SubscribeEvent()
    public void onRenderOverlayPre(RenderGameOverlayEvent.Pre e)
    {
        if (isZooming && e.type==RenderGameOverlayEvent.ElementType.CROSSHAIRS)
        {
            e.setCanceled(true);
            if(isZooming)
            {


            }

        }

    }
}
