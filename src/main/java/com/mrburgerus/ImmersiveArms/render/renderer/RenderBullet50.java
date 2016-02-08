package com.mrburgerus.ImmersiveArms.render.renderer;

        import com.mrburgerus.ImmersiveArms.ImmersiveArms;
        import com.mrburgerus.ImmersiveArms.render.model.ModelBullet50;
        import com.mrburgerus.ImmersiveArms.render.model.ModelSniperRifle;
        import net.minecraft.client.Minecraft;
        import net.minecraft.item.ItemStack;
        import net.minecraft.util.ResourceLocation;
        import net.minecraftforge.client.IItemRenderer;
        import org.lwjgl.opengl.GL11;

public class RenderBullet50 implements IItemRenderer
{
    //fields
    private ModelBullet50 modelBullet50;
    public static ResourceLocation texture = new ResourceLocation(ImmersiveArms.MODID + ":" + "textures/models/bullet50.png" );

    //constructors
    public RenderBullet50()
    {
        modelBullet50 = new ModelBullet50();
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
        float scale = .4F;
        GL11.glScalef(scale, scale, scale);
        //upright
        GL11.glRotatef(180F, 1F, 0F, 0F);
        //center
        GL11.glTranslatef(-0.1F, 0F, 0F);
        this.modelBullet50.renderModel(.0625F);
        GL11.glPopMatrix();
    }
}
