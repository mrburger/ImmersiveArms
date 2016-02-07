package com.mrburgerus.ImmersiveArms.key;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class KeyBind
{
    //fields
    public static KeyBinding reload;
    public static KeyBinding rechamber;

    //methods
    public static void init() {

        reload = new KeyBinding("key.reload", Keyboard.KEY_R, "key.categories.ImmersiveArms");
        rechamber = new KeyBinding("key.rechamber", Keyboard.KEY_G, "key.categories.ImmersiveArms");


        ClientRegistry.registerKeyBinding(reload);
        ClientRegistry.registerKeyBinding(rechamber);
    }
}
