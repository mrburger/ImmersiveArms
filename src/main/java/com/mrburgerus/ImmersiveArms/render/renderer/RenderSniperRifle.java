package com.mrburgerus.ImmersiveArms.render.renderer;

import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import com.mrburgerus.ImmersiveArms.render.model.ModelSniperRifle;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderSniperRifle implements IItemRenderer {
    //fields
    private ModelSniperRifle sniperRifle;
    public static ResourceLocation texture = new ResourceLocation(ImmersiveArms.MODID + ":" + "textures/models/sniperrifle.png" );

    //constructors
    public RenderSniperRifle()
    {
        sniperRifle = new ModelSniperRifle();
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
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {

        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
        {
            float scale = 4F;
            GL11.glScalef(scale, scale, scale);
            //rotate upright
            GL11.glRotatef(180F, 1F, 0F, 0F);
            //rotate to be parallel with arm
            GL11.glRotatef(45F, 0F, -1F, 0F);
            //translate
            GL11.glTranslatef(1F, -0.1F, -0.1F);

            this.sniperRifle.renderModel(.0625F);
        }
        else if (type == ItemRenderType.EQUIPPED)
        {

            float scale = 1.1F;
            GL11.glScalef(scale, scale, scale);
            //put upright
            GL11.glRotatef(180F, 0F, 0F, 1F);
            //align with arm side to side
            GL11.glRotatef(45F, 0F, 1F, 0F);
            //Put in hand
            GL11.glRotatef(70F, 0F, 0F, 1F);
            GL11.glTranslatef(0.5F, 0.6F, 0F);

            this.sniperRifle.renderModel(.0625F);
        }
        else if (type == ItemRenderType.ENTITY)
        {
            float scale = 1F;
            GL11.glScalef(scale, scale, scale);
            //rotate upright
            GL11.glRotatef(180F, 0F, 0F, 1F);

            this.sniperRifle.renderModel(.0625F);
        }
        else if (type == ItemRenderType.INVENTORY)
        {
            float scale = 0.6F;
            GL11.glScalef(scale, scale, scale);
            //rotate upright
            GL11.glRotatef(180F, 0F, 0F, 1F);
            //translate into slot
            GL11.glTranslatef(0.1F, 0F, 0F);

            this.sniperRifle.renderModel(.0625F);
        }

        GL11.glPopMatrix();
    }
}

