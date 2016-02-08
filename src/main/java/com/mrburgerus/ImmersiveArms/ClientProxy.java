package com.mrburgerus.ImmersiveArms;

import com.mrburgerus.ImmersiveArms.entities.EntityBullet50;
import com.mrburgerus.ImmersiveArms.item.items.Items;
import com.mrburgerus.ImmersiveArms.render.renderer.RenderBullet50;
import com.mrburgerus.ImmersiveArms.render.renderer.RenderBullet50Case;
import com.mrburgerus.ImmersiveArms.render.renderer.RenderSniperRifle;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
    public static void registerRender()
    {

        EntityRegistry.registerModEntity(EntityBullet50.class, "immersivebullet50", 1, ImmersiveArms.MODID, 0, 1000, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityBullet50.class, new RenderSnowball(Items.bullet50));
        MinecraftForgeClient.registerItemRenderer(Items.sniperRifle, new RenderSniperRifle());
        MinecraftForgeClient.registerItemRenderer(Items.bullet50, new RenderBullet50());
        MinecraftForgeClient.registerItemRenderer(Items.bullet50Case, new RenderBullet50Case());
    }

}
