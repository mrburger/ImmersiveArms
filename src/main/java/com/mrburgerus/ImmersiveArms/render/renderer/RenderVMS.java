package com.mrburgerus.ImmersiveArms.render.renderer;

import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created by mrburgerUS on 2/12/2016.
 */
public class RenderVMS implements IItemRenderer {
    //fields
    static IModelCustom vms;
    static ResourceLocation texture;

    //constructors
    public RenderVMS()
    {
        vms = AdvancedModelLoader.loadModel(new ResourceLocation(ImmersiveArms.MODID + ":" + "models/ModelVMS.obj"));
        texture = new ResourceLocation(ImmersiveArms.MODID + ":" + "textures/models/vmsRifle.png");
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
        vms.renderAll();
        GL11.glPopMatrix();
    }
}
