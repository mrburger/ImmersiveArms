package com.mrburgerus.ImmersiveArms.potion;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class PotionEye extends Potion {

    //fields
    public static Potion eyeRelief;

    //constructors
    protected PotionEye(int id, boolean isBad, int color) {
        super(id, isBad, color);
    }

    //methods

    public void load(FMLPreInitializationEvent event)
    {
        Potion[] potionTypes = null;

        for (Field f : Potion.class.getDeclaredFields())
        {
            f.setAccessible(true);
            try
            {
                if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a"))
                {
                    Field modfield = Field.class.getDeclaredField("modifiers");
                    modfield.setAccessible(true);
                    modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

                    potionTypes = (Potion[])f.get(null);
                    final Potion[] newPotionTypes = new Potion[256];
                    System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
                    f.set(null, newPotionTypes);
                }
            }
            catch (Exception e)
            {
                System.err.println("Severe error, please report this to the mod author:");
                System.err.println(e);
            }
        }
    }

    public void load(FMLInitializationEvent event)
    {
        eyeRelief = (new PotionEye(32, true, 0)).setIconIndex(0, 0).setPotionName("potion.eyeRelief");
    }
}
