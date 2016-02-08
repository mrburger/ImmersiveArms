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
        switch (type){

            case EQUIPPED:
                return true;
            case EQUIPPED_FIRST_PERSON:
                return true;
            case ENTITY:
                return true;
            case INVENTORY:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {


        switch (type) {

            case EQUIPPED: {
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                float scale = 1.4F;
                GL11.glScalef(scale, scale, scale);
                GL11.glRotatef(180F, 0F, 0F, 1F);
                GL11.glRotatef(90F, 1F, 1F, 1F);

                this.sniperRifle.renderModel(.0625F);
                GL11.glPopMatrix();
            }
        }
    }

}
