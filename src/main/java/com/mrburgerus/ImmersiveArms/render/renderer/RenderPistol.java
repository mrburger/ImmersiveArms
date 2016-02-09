package com.mrburgerus.ImmersiveArms.render.renderer;

import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RenderPistol implements IItemRenderer {
    //fields
    static IModelCustom pistol;
    public static ResourceLocation texture;

    //constructors
    public RenderPistol()
    {
        pistol = AdvancedModelLoader.loadModel(new ResourceLocation(ImmersiveArms.MODID + ":" + "models/pistolo.obj"));
        texture = new ResourceLocation(ImmersiveArms.MODID + ":" + "textures/models/pistol.png");
    }

    //methods
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        float scale1 = 0.1F;
        GL11.glScalef(scale1, scale1, scale1);
        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
        {
            //rotate
            GL11.glRotatef(135F, 0F, 1F, 0F);
            //translate
            GL11.glTranslatef(0F, 7F, 0F);
        }
        else if (type == ItemRenderType.EQUIPPED)
        {

        }
        else if (type == ItemRenderType.ENTITY)
        {
            //rotate upright
            GL11.glRotatef(180F, 0F, 0F, 1F);


        }
        else if (type == ItemRenderType.INVENTORY)
        {
            float scale = 0.6F;
            GL11.glScalef(scale, scale, scale);
            //rotate upright
            GL11.glRotatef(180F, 0F, 0F, 1F);
            //translate into slot
            GL11.glTranslatef(0.1F, 0F, 0F);
            //fix OBJ
            GL11.glRotatef(180F, 1F, 0F, 0F);
            GL11.glRotatef(180F, 0F, 1F, 0F);
            GL11.glTranslatef(0F, -1F, 0F);


        }


        pistol.renderAll();
        GL11.glPopMatrix();

    }
}
