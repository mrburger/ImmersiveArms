package com.mrburgerus.ImmersiveArms.key;

import com.mrburgerus.ImmersiveArms.gui.inventory.InventorySniperRifle;
import com.mrburgerus.ImmersiveArms.item.items.ItemSniperRifle;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public class KeyHandler
{


    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;

        if (KeyBind.rechamber.isPressed() && player.getHeldItem().getItem() instanceof ItemSniperRifle) {

                InventorySniperRifle inventorySniperRifle = new InventorySniperRifle(player.getHeldItem());
                boolean shoot = ItemSniperRifle.isLoaded(inventorySniperRifle);

            if (!ItemSniperRifle.isChambered && shoot) {
                System.out.println("RECHAMBERING");
                ItemSniperRifle.rechamberCountDown();
            }

        }
    }
}
