package com.mrburgerus.ImmersiveArms;

import com.mrburgerus.ImmersiveArms.entities.EntityBullet50;
import com.mrburgerus.ImmersiveArms.item.Items;
import com.mrburgerus.ImmersiveArms.render.RenderLaserRifle;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
    public static void registerRender()
    {
        //EntityRegistry.registerModEntity(EntityLaser.class, "immersivelaser", 1, Main.MODID, 80, 3, true);
        EntityRegistry.registerModEntity(EntityBullet50.class, "immersivebullet50", 1, Main.MODID, 0, 1000, true);
        MinecraftForgeClient.registerItemRenderer(Items.laserRifle, new RenderLaserRifle());
    }
}
