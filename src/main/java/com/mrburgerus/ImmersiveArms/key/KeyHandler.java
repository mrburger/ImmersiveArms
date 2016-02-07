package com.mrburgerus.ImmersiveArms.key;

import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import com.mrburgerus.ImmersiveArms.gui.GuiSniper;
import com.mrburgerus.ImmersiveArms.item.ItemSniperRifle;
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

        if(KeyBind.reload.isPressed() && player.getCurrentEquippedItem().getItem() instanceof ItemSniperRifle)
        {
                player.openGui(ImmersiveArms.instance, GuiSniper.INV_NUM, Minecraft.getMinecraft().theWorld, (int) player.posX, (int) player.posY, (int) player.posZ);
        }

        if(KeyBind.rechamber.isPressed() && player.getCurrentEquippedItem().getItem() instanceof ItemSniperRifle && !ItemSniperRifle.isChambered)
        {
            ItemSniperRifle.rechamberCountDown();
        }

    }
}
