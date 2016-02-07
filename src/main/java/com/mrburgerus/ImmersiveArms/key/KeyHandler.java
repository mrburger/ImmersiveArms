package com.mrburgerus.ImmersiveArms.key;

import com.mrburgerus.ImmersiveArms.item.items.ItemSniperRifle;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class KeyHandler
{


    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event)
    {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;

        if(KeyBind.rechamber.isPressed() && player.getCurrentEquippedItem().getItem() instanceof ItemSniperRifle)
        {
            ItemSniperRifle.rechamberCountDown();
        }

    }
}
