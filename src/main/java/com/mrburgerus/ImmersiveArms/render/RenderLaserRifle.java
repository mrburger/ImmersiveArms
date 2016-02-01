package com.mrburgerus.ImmersiveArms.render;

import com.mrburgerus.ImmersiveArms.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import org.lwjgl.opengl.GL11;

public class RenderLaserRifle implements IItemRenderer
{
    static IModelCustom laserRifle = AdvancedModelLoader.loadModel(new ResourceLocation(Main.MODID, "models/ModelLaserRifle.obj"));
    static ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/modelplasmacaster.png" );

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        GL11.glPushMatrix();
        GL11.glScalef(0.01F, 0.01F, 0.01F);

        switch (type) {

            case EQUIPPED:
            {
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                laserRifle.renderAll();
                GL11.glPopMatrix();
            }

            case EQUIPPED_FIRST_PERSON:
            {
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                laserRifle.renderAll();
                GL11.glPopMatrix();
            }

            case ENTITY:
            {
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                laserRifle.renderAll();
                GL11.glPopMatrix();
            }
        }


            GL11.glPopMatrix();
    }

}
