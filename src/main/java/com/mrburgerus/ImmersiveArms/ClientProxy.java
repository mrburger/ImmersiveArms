package com.mrburgerus.ImmersiveArms;

import com.mrburgerus.ImmersiveArms.entities.EntityBullet50;
import com.mrburgerus.ImmersiveArms.item.items.Items;
import com.mrburgerus.ImmersiveArms.render.RenderLaserRifle;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
    public static void registerRender()
    {
        //EntityRegistry.registerModEntity(EntityLaser.class, "immersivelaser", 1, ImmersiveArms.MODID, 80, 3, true);
        EntityRegistry.registerModEntity(EntityBullet50.class, "immersivebullet50", 1, ImmersiveArms.MODID, 0, 1000, true);
        MinecraftForgeClient.registerItemRenderer(Items.laserRifle, new RenderLaserRifle());
        RenderingRegistry.registerEntityRenderingHandler(EntityBullet50.class, new RenderSnowball(Items.bullet50));
    }
}
