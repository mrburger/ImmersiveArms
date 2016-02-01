package com.mrburgerus.ImmersiveArms;

import com.mrburgerus.ImmersiveArms.entities.EntityLaser;
import com.mrburgerus.ImmersiveArms.item.Items;
import com.mrburgerus.ImmersiveArms.render.RenderLaserRifle;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
    public static void registerRender()
    {
        EntityRegistry.registerModEntity(EntityLaser.class, "immersivelaser", 1, Main.MODID, 80, 3, true);
        MinecraftForgeClient.registerItemRenderer(Items.laserRifle, new RenderLaserRifle());
    }
}
